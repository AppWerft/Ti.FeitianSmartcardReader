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
	boolean mobile;
	private static final String LCAT = FeitianModule.LCAT;

	public HealthCardAsyncAdapter(KrollObject krollobject, KrollFunction onRcv, FTReader ftReader, boolean mobile) {
		this.ftReader = ftReader;
		this.onRcv = onRcv;
		this.krollobject = krollobject;
		this.mobile = mobile;
		Log.d(LCAT, "ftReader imported");
	}

	private String getPatientData() throws IOException {
		byte[] pdmeta;
		try {
		
			pdmeta = transmit(APDU.getCmd(APDU.SELECT_FILE_PD), "SELECT_FILE_PD");

			Log.d(LCAT, Utility.bytes2HexStr(pdmeta));
		
			int pdLength = ((pdmeta[0] & 0xff) << 8) | (pdmeta[1] & 0xff);
			Log.d(LCAT, "Length of pd =" + pdLength);
			
			byte[] pd = (mobile) ? transmit(APDU.getCmd(APDU.READ_PD_MOBILE), "READ_PD_MOBILE")
					: transmit(APDU.getCmd(APDU.READ_PD_STAT + Utility.bytes2HexStr(pdmeta, 2)), "READ_PD_STAT + LEN");

			byte[] pdDataCompressed = new byte[pdLength];
			// java.lang.ArrayIndexOutOfBoundsException:
			// src.length=4 srcPos=2 dst.length=364 dstPos=0 length=364
			// System.arraycopy(pd, 2, pdDataCompressed, 0, pdLength);
			// Log.d(LCAT,Utility.bytes2HexStr(pdDataCompressed));
			// return new String(unzip(pdDataCompressed), Charset.forName("ISO-8859-15"));
		} catch (FTException e) {
			Log.e(LCAT, e.getLocalizedMessage());
			e.printStackTrace();
			try {
				ftReader.readerClose();
			} catch (FTException e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

	private byte[] transmit(byte[] apdu, String comment) throws FTException {
		Log.d(LCAT, "SEND: " + Utility.bytes2HexStr(apdu) + "  (" + comment + ")");
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
			transmit(APDU.getCmd(APDU.SELECT_MF), "SELECT_MF");
			transmit(APDU.getCmd(APDU.SELECT_HCA), "SELECT_HCA");
			transmit(APDU.getCmd(APDU.READ_BINARY_EF_STATUSVD), "READ_BINARY_EF_STATUSVD");
		} catch (FTException e1) {
			Log.d(LCAT, e1.getLocalizedMessage());
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
