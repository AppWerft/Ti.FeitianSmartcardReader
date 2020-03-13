package de.appwerft.feitian;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.ftsafe.Utility;
// https://github.com/patrick-werner/EGKfhir/blob/master/src/main/java/de/gecko/egkfeuer/service/CardReaderServiceImpl.java
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollObject;
import org.appcelerator.kroll.common.Log;
import org.apache.commons.io.IOUtils;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTException;
import com.ftsafe.readerScheme.FTReader;
import com.ftsafe.Utility;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import android.os.AsyncTask;

public class HealthCardAsyncAdapter extends AsyncTask<Void, Void, byte[]> {
	public FTReader ftReader;
	KrollFunction onRcv;
	KrollObject krollobject;
	private static final String LCAT = FeitianModule.LCAT;

	public HealthCardAsyncAdapter(KrollObject krollobject, KrollFunction onRcv, FTReader ftReader) {
		this.ftReader = ftReader;
		this.onRcv = onRcv;
		this.krollobject = krollobject;
		Log.d(LCAT,"ftReader imported");
	}

	private String getPatientData() throws IOException {
		// Create read command for the first two bytes of patient file.
		// Read first two byte of patient data. These contain the length of the PD file.
		// byte[] data = transmit(APDU.readData(0,2));

		// Since the two bytes are included themselves those two bytes are subtracted
		// from the length.
		// int pdLength = 8*data[0]+data[1]-2;
		byte[] READ_PD = new byte[] { 0x00, (byte) 0xb0, (byte) (0x80 + 0x01), 0x00, 0x00, 0x00, 0x00 };
		Log.d(LCAT, "READ_PD try to send = "+ Utility.bytes2HexStr(READ_PD));
		byte[] pd;
		try {
			//pd = transmit(READ_PD);
			transmit(APDU.getCmd(APDU.SELECT_FILE_PD));
			pd = transmit(APDU.getCmd(APDU.READ_PD));
			Log.d(LCAT, "READ_PD sent");
			Log.d(LCAT, "Length of raw pd =" + pd.length);
			Log.d(LCAT, "first 2 bytes =" + pd[0] + pd[1]);
			int pdLength = ((pd[0] & 0xff) << 8) | (pd[1] & 0xff);
			Log.d(LCAT, "Length of pd =" + pdLength);
			byte[] pdDataCompressed = new byte[pdLength];
			System.arraycopy(pd, 2, pdDataCompressed, 0, pdLength);
			return new String(unzip(pdDataCompressed), Charset.forName("ISO-8859-15"));
		} catch (FTException e) {
			Log.e(LCAT,e.getLocalizedMessage());	
			e.printStackTrace();
		}
		
		return null; 
	}

	private byte[] transmit(byte[] apdu) throws FTException {
			Log.d(LCAT, "SEND: " +Utility.bytes2HexStr(apdu));
			byte[] res = ftReader.readerXfr(0, apdu);
			Log.d(LCAT, "RCV: " + Utility.bytes2HexStr(res));
			return res;
	}

	@Override
	protected byte[] doInBackground(Void... arg0) {
		byte[] recv = null;
		String generation = "";
		Log.d(LCAT, "doInBackground started");
		// Select Masterfile (root)
		try {
			transmit(APDU.getCmd(APDU.SELECT_MF));
			transmit(APDU.getCmd(APDU.SELECT_HCA));
		} catch (FTException e1) {
			Log.d(LCAT,e1.getLocalizedMessage());
			e1.printStackTrace();
		}

		// detecting generation:
		/*
		 * String ef_v_1 = Utility.bytes2HexStr(transmit(EF_VERSION_1)); String ef_v_2 =
		 * Utility.bytes2HexStr(transmit(EF_VERSION_2)); String ef_v_3 =
		 * Utility.bytes2HexStr(transmit(EF_VERSION_3)); if (ef_v_1.equals("3.0.0") &&
		 * ef_v_2.equals("3.0.0") && ef_v_3.equals("3.0.2")) generation = "G1"; else if
		 * (ef_v_1.equals("3.0.0") && ef_v_2.equals("3.0.1") && ef_v_3.equals("3.0.3"))
		 * generation = "G1 plus"; else if(ef_v_1.startsWith("4.0")) generation = "G2";
		 */
		// Select Health Care Application
		

		// Select file containing patient data
		// transmit(APDU.getCmd(APDU.SELECT_FILE_PD));
		// Log.d(LCAT,"SELECT_FILE_PD started");
		try {
			String patientContent = getPatientData();
			KrollDict res = new KrollDict();
			res.put("xml", patientContent);
			onRcv.callAsync(krollobject, res);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recv;
	}

	protected void onPostExecute(byte[] result) {
		if (onRcv != null) {
			KrollDict res = new KrollDict();
			res.put("data", Utility.bytes2HexStr(result));
			this.onRcv.call(krollobject, res);
		}
	}

	private static byte[] unzip(byte[] zip) throws IOException {
		return IOUtils.toByteArray(new GZIPInputStream(new ByteArrayInputStream(zip)));
	}
}
