package de.appwerft.feitian;

import java.nio.ByteBuffer;

import com.ftsafe.Utility;

public class APDU {
	
	public static final String RESET_CT = 		"2011000000";
	public static final String REQUEST_ICC1 =	"201201000101";
	public static final String EJECT_ICC1   =   "201501000101";
	
	public static final String SELECT_MF =      "00 A4 04 0C 07 D2 76 00 01 44 80 00"; // select
	public static final String SELECT_HCA =     "00 A4 04 0C 06 D2 76 00 00 01 02";   // select
	public static final String EF_VERSION_1 =   "00 B2 01 84 00";  // read record
	public static final String EF_VERSION_2 =   "00 B2 02 84 00";  // read record
	public static final String EF_VERSION_3 =   "00 B2 03 84 00";  // read record
	public static final String SELECT_FILE_PD = "00 B0 81 00 02";  // read binary
	public static final String SELECT_FILE_VD = "00 B0 82 00 08";  // read binary
	
	public static final String READ_PD_MOBILE = "00 B0 81 00 00 00 00"; // read binary
	public static final String READ_PD_STAT  =  "00 B0 00 02 00";
	
		
	public static byte[] getCmd(String cmd) {
		return hexStringToBytes(cmd);
	}
	
	public static byte[] readData(int pos, int length) {
		ByteBuffer cmd = ByteBuffer.allocate(5);
		cmd.put(0,(byte) 0x00);
		cmd.put(1,(byte) 0xB0);
		cmd.putInt(2,pos);
		cmd.putInt(4,length);
        return cmd.array();
		
	}
	
	private static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase().replaceAll("\\s+","");
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static String byte2HexStr(byte[] src, int len) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		int n = len;
		if (len > src.length)
			n = src.length;

		for (int i = 0; i < n; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv + " ");
		}
		return stringBuilder.toString();
	}

	public static String byte2HexStr2(byte[] src, int len) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		int n = len;
		if (len > src.length)
			n = src.length;

		for (int i = 0; i < n; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
