package com.ftsafe;

import java.util.Locale;

public class Utility { public Utility() {}
  
  private static byte charToByte(char paramChar) { return (byte)"0123456789ABCDEF".indexOf(paramChar); }
  














  public static byte[] hexStrToBytes(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return hexStrToBytes(paramString, paramString.length() / 2);
  }
  
  public static byte[] hexStrToBytes(String paramString, int paramInt) {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    paramString = paramString.toUpperCase(Locale.getDefault());
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++) {
      int j = i * 2;
      arrayOfByte[i] = ((byte)(charToByte(arrayOfChar[j]) << 4 | charToByte(arrayOfChar[(j + 1)])));
    }
    return arrayOfByte;
  }
  


















  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    return bytes2HexStr(paramArrayOfByte, paramArrayOfByte.length);
  }
  

  public static String bytes2HexStr(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    
    for (int i = 0; i < paramInt; i++) {
      int j = paramArrayOfByte[i] & 0xFF;
      String str = Integer.toHexString(j);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str + "");
    }
    return localStringBuilder.toString();
  }
}
