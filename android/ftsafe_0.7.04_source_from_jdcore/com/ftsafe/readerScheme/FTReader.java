package com.ftsafe.readerScheme;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.ftsafe.CCIDScheme;
import com.ftsafe.Utility;
import com.ftsafe.bt3.BT3;
import com.ftsafe.bt4.BT4;
import com.ftsafe.usb.USB;




public class FTReader
{
  CCIDScheme ccidScheme;
  Handler gHandler = null;
  
  public FTReader(Context paramContext, Handler paramHandler, int paramInt) {
    gHandler = paramHandler;
    try {
      switch (paramInt) {
      case 0: 
        ccidScheme = new CCIDScheme(new USB(paramContext, mHandler), mHandler);
        break;
      case 1: 
        ccidScheme = new CCIDScheme(new BT3(paramContext, mHandler), mHandler);
        break;
      case 2: 
        ccidScheme = new CCIDScheme(new BT4(paramContext, mHandler), mHandler);
      default: 
        new Exception("FTREADER_TYPE error");
      }
    }
    catch (Exception localException) {
      showErrLog(localException);
    }
  }
  
  public void readerFind() throws FTException {
    try {
      ccidScheme.readerFind();
    } catch (Exception localException) {
      throwFTError(localException);
    }
  }
  
  public String[] readerOpen(Object paramObject) throws FTException { String[] arrayOfString = null;
    try {
      arrayOfString = (String[])ccidScheme.readerOpen(paramObject);
      if (arrayOfString == null) {
        throw new FTException("readerNames == null");
      }
    } catch (Exception localException) {
      throwFTError(localException);
    }
    return arrayOfString;
  }
  
  public void readerClose() throws FTException {
    try {
      ccidScheme.readerClose();
    } catch (Exception localException) {
      throwFTError(localException);
    }
  }
  
  public byte[] readerPowerOn(int paramInt) throws FTException {
    byte[] arrayOfByte = null;
    try {
      arrayOfByte = (byte[])ccidScheme.readerPowerOn(paramInt);
    } catch (Exception localException) {
      throwFTError(localException);
    }
    return arrayOfByte;
  }
  
  public void readerPowerOff(int paramInt) throws FTException
  {
    try {
      ccidScheme.readerPowerOff(paramInt);
    } catch (Exception localException) {
      throwFTError(localException);
    }
  }
  
  public byte[] readerXfr(int paramInt, byte[] paramArrayOfByte) throws FTException {
    byte[] arrayOfByte = null;
    try {
      int i = paramArrayOfByte.length;
      
      if (i != 4)
      {
        if (i != 5)
        {
          if ((i != 7) || ((paramArrayOfByte[4] & 0xFF) != 0))
          {
            if ((i <= 5) || ((paramArrayOfByte[4] & 0xFF) == 0) || (i != (paramArrayOfByte[4] & 0xFF) + 4 + 1))
            {
              if ((i <= 7) || ((paramArrayOfByte[4] & 0xFF) != 0) || (i != (paramArrayOfByte[5] & 0xFF) * 256 + (paramArrayOfByte[6] & 0xFF) + 4 + 3))
              {
                if ((i <= 6) || ((paramArrayOfByte[4] & 0xFF) == 0) || (i != (paramArrayOfByte[4] & 0xFF) + 4 + 1 + 1))
                {
                  if ((i <= 10) || ((paramArrayOfByte[4] & 0xFF) != 0) || (i != (paramArrayOfByte[5] & 0xFF) * 256 + (paramArrayOfByte[6] & 0xFF) + 4 + 3 + 3))
                  {

                    throw new Exception("apdu lc le error"); } } }
            }
          }
        }
      }
      arrayOfByte = (byte[])ccidScheme.readerXfrBlock(paramInt, paramArrayOfByte);
      
      if (arrayOfByte.length <= 0) {
        throw new Exception("apdu send recv error");
      }
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return arrayOfByte;
  }
  
  public byte[] readerEscape(int paramInt, byte[] paramArrayOfByte) throws FTException {
    byte[] arrayOfByte = null;
    try {
      arrayOfByte = (byte[])ccidScheme.readerEscape(paramInt, paramArrayOfByte);
    } catch (Exception localException) {
      throwFTError(localException);
    }
    return arrayOfByte;
  }
  
  public int readerGetSlotStatus(int paramInt) throws FTException {
    try {
      int i = ccidScheme.readerSlotStatus(paramInt);
      switch (i) {
      case 0: 
        return 0;
      case 1: 
        return 1;
      case 2: 
        return 2;
      }
    } catch (Exception localException) {
      throwFTError(localException);
    }
    return 2;
  }
  
  public int readerGetType() throws FTException {
    try {
      int i = ccidScheme.readerGetPid();
      
      switch (i) {
      case 1283: 
        return 100;
      case 1572: 
        return 101;
      case 1571: 
        return 102;
      case 1544: 
        return 103;
      case 1549: 
        return 104;
      case 1562: 
        return 105;
      case 1564: 
        return 106;
      case 1561: 
        return 107;
      case 1570: 
        return 108;
      }
      return 120;
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return 120;
  }
  
  public byte[] readerGetSerialNumber() throws FTException {
    try { int i = readerGetType();
      byte[] arrayOfByte; if ((i == 100) || (i == 101) || (i == 102) || (i == 108))
      {




        arrayOfByte = new byte[] { -91, 90, 50, 49 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte); }
      if ((i == 103) || (i == 104))
      {


        arrayOfByte = new byte[] { -91, 90, 112, 0 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte); }
      if ((i == 105) || (i == 106) || (i == 107))
      {



        arrayOfByte = new byte[] { 90, -91, 49, 49 };
        return readerEscape(0, arrayOfByte);
      }
      
      throw new Exception("Not Support");
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    
    return null;
  }
  
  public String readerGetFirmwareVersion() throws FTException {
    try { int i = ccidScheme.readerGetBcdDevice();
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)(i % 256));
      return i / 256 + "." + Utility.bytes2HexStr(arrayOfByte);
    } catch (Exception localException) {
      throwFTError(localException);
    }
    return "";
  }
  
  public byte[] readerGetUID() throws FTException {
    try { int i = readerGetType();
      byte[] arrayOfByte; if ((i == 100) || (i == 101) || (i == 102) || (i == 103) || (i == 104) || (i == 108))
      {






        arrayOfByte = new byte[] { -91, 90, 49, 49 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte); }
      if ((i == 105) || (i == 106) || (i == 107))
      {



        arrayOfByte = new byte[] { 90, -91, 112, 49 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte);
      }
      throw new Exception("Not Support");
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return null;
  }
  
  public byte[] FT_AutoTurnOffReader(boolean paramBoolean) throws FTException {
    try {
      if (paramBoolean) {
        arrayOfByte = new byte[] { -91, 90, 57, 1 };
        return readerEscape(0, arrayOfByte);
      }
      byte[] arrayOfByte = { -91, 90, 57, 2 };
      return readerEscape(0, arrayOfByte);
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return null;
  }
  
  public byte[] readerGetManufacturer() throws FTException
  {
    try {
      int i = readerGetType();
      if ((i == 105) || (i == 101) || (i == 102))
      {
        byte[] arrayOfByte = { -91, 90, 56, 19 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte);
      }
      throw new Exception("Not Support");
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return null;
  }
  
  public byte[] readerGetHardwareInfo() throws FTException
  {
    try {
      int i = readerGetType();
      byte[] arrayOfByte; if ((i == 101) || (i == 102))
      {
        arrayOfByte = new byte[] { -91, 90, 52, 1 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte); }
      if (i == 105) {
        arrayOfByte = new byte[] { -91, 90, 56, 21 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte);
      }
      throw new Exception("Not Support");
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return null;
  }
  
  public byte[] readerGetReaderName() throws FTException
  {
    try {
      int i = readerGetType();
      if ((i == 105) || (i == 101) || (i == 102))
      {
        byte[] arrayOfByte = { -91, 90, 56, 18 };
        return readerEscapeWithParseSw1Sw2(arrayOfByte);
      }
      throw new Exception("Not Support");
    }
    catch (Exception localException) {
      throwFTError(localException);
    }
    return null;
  }
  
  public static String readerGetLibVersion() {
    return "0.7.04";
  }
  
  private byte[] readerEscapeWithParseSw1Sw2(byte[] paramArrayOfByte) throws Exception
  {
    byte[] arrayOfByte1 = readerEscape(0, paramArrayOfByte);
    int i = arrayOfByte1.length;
    if ((arrayOfByte1[(i - 2)] == -112) && (arrayOfByte1[(i - 1)] == 0)) {
      arrayOfByte2 = new byte[i - 2];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i - 2);
      return arrayOfByte2;
    }
    byte[] arrayOfByte2 = new byte[2];
    arrayOfByte2[0] = arrayOfByte1[(i - 2)];
    arrayOfByte2[1] = arrayOfByte1[(i - 1)];
    String str = "[" + Utility.bytes2HexStr(arrayOfByte2) + "]";
    if (arrayOfByte2[0] == 108) {
      switch (arrayOfByte2[1]) {
      case 128: 
        str = str + "Data length error";
        break;
      case 129: 
        str = str + "LC length and data length not equal";
        break;
      case 130: 
        str = str + "UID exist";
        break;
      case 131: 
        str = str + "UID can't generate";
        break;
      case 132: 
        str = str + "Ciphertext decryption data comparison error";
        break;
      case 133: 
        str = str + "HID exist";
        break;
      case 134: 
        str = str + "Out of storage range";
        break;
      case 135: 
        str = str + "Unable to erase storage space normally";
        break;
      case 136: 
        str = str + "Unable to read storage space normally";
        break;
      case 137: 
        str = str + "Unable to write storage space normally";
        break;
      case 138: 
        str = str + "Seed error";
        break;
      case 139: 
        str = str + "Data error in data area";
        break;
      case 140: 
        str = str + "Address byte check error";
        break;
      case 141: 
        str = str + "The program is in space byte detection error";
        break;
      case 142: 
        str = str + "Update step error";
        break;
      case 143: 
        str = str + "Cipher check error";
        break;
      case 112: 
        str = str + "Plaintext validation error";
        break;
      case 71: 
        str = str + "Error with module communication";
        break;
      }
      
    }
    


    throw new Exception(str);
  }
  


  private void gHandlerSendMessage(int paramInt, Object paramObject)
  {
    if (gHandler != null) {
      gHandler.sendMessage(gHandler.obtainMessage(paramInt, paramObject));
    }
  }
  

  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {
      super.handleMessage(paramAnonymousMessage);
      










      FTReader.this.gHandlerSendMessage(what, obj);
    }
  };
  
  private void throwFTError(Exception paramException)
    throws FTException
  {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    paramException.printStackTrace();
    throw new FTException("[ERROR][" + str1 + ":" + str2 + "][" + paramException.getMessage() + "][" + paramException.toString() + "]");
  }
  
  private void showErrLog(Exception paramException)
  {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    showLog("ERROR::" + str1 + ":" + str2 + " [" + paramException.getMessage() + "]" + "[" + paramException.toString() + "]");
  }
  
  private void showLog(String paramString)
  {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    gHandlerSendMessage(80, "[LOG]" + str1 + ":" + str2 + "--->" + paramString);
  }
}
