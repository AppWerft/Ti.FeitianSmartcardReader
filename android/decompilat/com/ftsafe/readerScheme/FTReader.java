// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.readerScheme;

import com.ftsafe.Utility;
import com.ftsafe.bt4.BT4;
import com.ftsafe.bt3.BT3;
import com.ftsafe.usb.USB;
import android.os.Message;
import android.content.Context;
import android.os.Handler;
import com.ftsafe.CCIDScheme;

public class FTReader
{
    CCIDScheme ccidScheme;
    Handler gHandler;
    private Handler mHandler;
    
    public FTReader(final Context context, final Handler gHandler, final int n) {
        this.gHandler = null;
        this.mHandler = new Handler() {
            public void handleMessage(final Message message) {
                super.handleMessage(message);
                FTReader.this.gHandlerSendMessage(message.what, message.obj);
            }
        };
        this.gHandler = gHandler;
        try {
            switch (n) {
                case 0: {
                    this.ccidScheme = new CCIDScheme(new USB(context, this.mHandler), this.mHandler);
                    return;
                }
                case 1: {
                    this.ccidScheme = new CCIDScheme(new BT3(context, this.mHandler), this.mHandler);
                    return;
                }
                case 2: {
                    this.ccidScheme = new CCIDScheme(new BT4(context, this.mHandler), this.mHandler);
                    break;
                }
            }
            new Exception("FTREADER_TYPE error");
        }
        catch (Exception ex) {
            this.showErrLog(ex);
        }
    }
    
    public void readerFind() throws FTException {
        try {
            this.ccidScheme.readerFind();
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
    }
    
    public String[] readerOpen(final Object device) throws FTException {
        String[] array = null;
        try {
            array = (String[])this.ccidScheme.readerOpen(device);
            if (array == null) {
                throw new FTException("readerNames == null");
            }
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
        return array;
    }
    
    public void readerClose() throws FTException {
        try {
            this.ccidScheme.readerClose();
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
    }
    
    public byte[] readerPowerOn(final int index) throws FTException {
        byte[] array = null;
        try {
            array = (byte[])this.ccidScheme.readerPowerOn(index);
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
        return array;
    }
    
    public void readerPowerOff(final int index) throws FTException {
        try {
            this.ccidScheme.readerPowerOff(index);
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
    }
    
    public byte[] readerXfr(final int index, final byte[] data) throws FTException {
        byte[] array = null;
        try {
            final int length = data.length;
            if (length != 4) {
                if (length != 5) {
                    if (length != 7 || (data[4] & 0xFF) != 0x0) {
                        if (length <= 5 || (data[4] & 0xFF) == 0x0 || length != (data[4] & 0xFF) + 4 + 1) {
                            if (length <= 7 || (data[4] & 0xFF) != 0x0 || length != (data[5] & 0xFF) * 256 + (data[6] & 0xFF) + 4 + 3) {
                                if (length <= 6 || (data[4] & 0xFF) == 0x0 || length != (data[4] & 0xFF) + 4 + 1 + 1) {
                                    if (length <= 10 || (data[4] & 0xFF) != 0x0 || length != (data[5] & 0xFF) * 256 + (data[6] & 0xFF) + 4 + 3 + 3) {
                                        throw new Exception("apdu lc le error");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            array = (byte[])this.ccidScheme.readerXfrBlock(index, data);
            if (array.length <= 0) {
                throw new Exception("apdu send recv error");
            }
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
        return array;
    }
    
    public byte[] readerEscape(final int index, final byte[] data) throws FTException {
        byte[] array = null;
        try {
            array = (byte[])this.ccidScheme.readerEscape(index, data);
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
        return array;
    }
    
    public int readerGetSlotStatus(final int index) throws FTException {
        try {
            switch (this.ccidScheme.readerSlotStatus(index)) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
            }
        }
        catch (Exception ex) {
            this.throwFTError(ex);
        }
        return 2;
    }
    
    public int readerGetType() throws FTException {
        try {
            switch (this.ccidScheme.readerGetPid()) {
                case 1283: {
                    return 100;
                }
                case 1572: {
                    return 101;
                }
                case 1571: {
                    return 102;
                }
                case 1544: {
                    return 103;
                }
                case 1549: {
                    return 104;
                }
                case 1562: {
                    return 105;
                }
                case 1564: {
                    return 106;
                }
                case 1561: {
                    return 107;
                }
                case 1570: {
                    return 108;
                }
                default: {
                    return 120;
                }
            }
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return 120;
        }
    }
    
    public byte[] readerGetSerialNumber() throws FTException {
        try {
            final int readerGetType = this.readerGetType();
            if (readerGetType == 100 || readerGetType == 101 || readerGetType == 102 || readerGetType == 108) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 50, 49 });
            }
            if (readerGetType == 103 || readerGetType == 104) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 112, 0 });
            }
            if (readerGetType == 105 || readerGetType == 106 || readerGetType == 107) {
                return this.readerEscape(0, new byte[] { 90, -91, 49, 49 });
            }
            throw new Exception("Not Support");
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public String readerGetFirmwareVersion() throws FTException {
        try {
            final int readerGetBcdDevice = this.ccidScheme.readerGetBcdDevice();
            return readerGetBcdDevice / 256 + "." + Utility.bytes2HexStr(new byte[] { (byte)(readerGetBcdDevice % 256) });
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return "";
        }
    }
    
    public byte[] readerGetUID() throws FTException {
        try {
            final int readerGetType = this.readerGetType();
            if (readerGetType == 100 || readerGetType == 101 || readerGetType == 102 || readerGetType == 103 || readerGetType == 104 || readerGetType == 108) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 49, 49 });
            }
            if (readerGetType == 105 || readerGetType == 106 || readerGetType == 107) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { 90, -91, 112, 49 });
            }
            throw new Exception("Not Support");
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public byte[] FT_AutoTurnOffReader(final boolean b) throws FTException {
        try {
            if (b) {
                return this.readerEscape(0, new byte[] { -91, 90, 57, 1 });
            }
            return this.readerEscape(0, new byte[] { -91, 90, 57, 2 });
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public byte[] readerGetManufacturer() throws FTException {
        try {
            final int readerGetType = this.readerGetType();
            if (readerGetType == 105 || readerGetType == 101 || readerGetType == 102) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 56, 19 });
            }
            throw new Exception("Not Support");
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public byte[] readerGetHardwareInfo() throws FTException {
        try {
            final int readerGetType = this.readerGetType();
            if (readerGetType == 101 || readerGetType == 102) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 52, 1 });
            }
            if (readerGetType == 105) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 56, 21 });
            }
            throw new Exception("Not Support");
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public byte[] readerGetReaderName() throws FTException {
        try {
            final int readerGetType = this.readerGetType();
            if (readerGetType == 105 || readerGetType == 101 || readerGetType == 102) {
                return this.readerEscapeWithParseSw1Sw2(new byte[] { -91, 90, 56, 18 });
            }
            throw new Exception("Not Support");
        }
        catch (Exception ex) {
            this.throwFTError(ex);
            return null;
        }
    }
    
    public static String readerGetLibVersion() {
        return "0.7.04";
    }
    
    private byte[] readerEscapeWithParseSw1Sw2(final byte[] array) throws Exception {
        final byte[] readerEscape = this.readerEscape(0, array);
        final int length = readerEscape.length;
        if (readerEscape[length - 2] == -112 && readerEscape[length - 1] == 0) {
            final byte[] array2 = new byte[length - 2];
            System.arraycopy(readerEscape, 0, array2, 0, length - 2);
            return array2;
        }
        final byte[] array3 = { readerEscape[length - 2], readerEscape[length - 1] };
        String message = "[" + Utility.bytes2HexStr(array3) + "]";
        if (array3[0] == 108) {
            switch (array3[1]) {
                case Byte.MIN_VALUE: {
                    message += "Data length error";
                    break;
                }
                case -127: {
                    message += "LC length and data length not equal";
                    break;
                }
                case -126: {
                    message += "UID exist";
                    break;
                }
                case -125: {
                    message += "UID can't generate";
                    break;
                }
                case -124: {
                    message += "Ciphertext decryption data comparison error";
                    break;
                }
                case -123: {
                    message += "HID exist";
                    break;
                }
                case -122: {
                    message += "Out of storage range";
                    break;
                }
                case -121: {
                    message += "Unable to erase storage space normally";
                    break;
                }
                case -120: {
                    message += "Unable to read storage space normally";
                    break;
                }
                case -119: {
                    message += "Unable to write storage space normally";
                    break;
                }
                case -118: {
                    message += "Seed error";
                    break;
                }
                case -117: {
                    message += "Data error in data area";
                    break;
                }
                case -116: {
                    message += "Address byte check error";
                    break;
                }
                case -115: {
                    message += "The program is in space byte detection error";
                    break;
                }
                case -114: {
                    message += "Update step error";
                    break;
                }
                case -113: {
                    message += "Cipher check error";
                    break;
                }
                case 112: {
                    message += "Plaintext validation error";
                    break;
                }
                case 71: {
                    message += "Error with module communication";
                    break;
                }
            }
        }
        throw new Exception(message);
    }
    
    private void gHandlerSendMessage(final int n, final Object o) {
        if (this.gHandler != null) {
            this.gHandler.sendMessage(this.gHandler.obtainMessage(n, o));
        }
    }
    
    private void throwFTError(final Exception ex) throws FTException {
        final String className = Thread.currentThread().getStackTrace()[3].getClassName();
        final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        ex.printStackTrace();
        throw new FTException("[ERROR][" + className + ":" + methodName + "][" + ex.getMessage() + "][" + ex.toString() + "]");
    }
    
    private void showErrLog(final Exception ex) {
        this.showLog("ERROR::" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + " [" + ex.getMessage() + "]" + "[" + ex.toString() + "]");
    }
    
    private void showLog(final String str) {
        this.gHandlerSendMessage(80, "[LOG]" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + "--->" + str);
    }
}
