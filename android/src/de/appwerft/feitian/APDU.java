package de.appwerft.feitian;

import java.nio.ByteBuffer;

import com.ftsafe.Utility;

public class APDU {
	public static final String SELECT_MF = "00A4040C07D2760001448000";
	public static final String SELECT_HCA = "00A4040C06D27600000102";
	public static final String EF_VERSION_1 = "00B2018400";
	public static final String EF_VERSION_2 = "00B2028400";
	public static final String EF_VERSION_3 = "00B2038400";
	public static final String SELECT_FILE_PD = "00B0810002";
	public static final String SELECT_FILE_VD = "00B0820008";
	
	public static final String READ_PD = "00B08100000000";
	
	public static final String AUTOPOWEROFF_OFF = "A55A8031";
	public static final String AUTOPOWEROFF_ON = "A55A8030";
	
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
		hexString = hexString.toUpperCase();
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
