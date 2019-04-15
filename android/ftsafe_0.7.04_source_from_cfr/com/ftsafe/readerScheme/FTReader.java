/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Message
 */
package com.ftsafe.readerScheme;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.ftsafe.CCIDScheme;
import com.ftsafe.Utility;
import com.ftsafe.bt3.BT3;
import com.ftsafe.bt4.BT4;
import com.ftsafe.readerScheme.FTException;
import com.ftsafe.readerScheme.FTReaderInf;
import com.ftsafe.usb.USB;

public class FTReader {
    CCIDScheme ccidScheme;
    Handler gHandler = null;
    private Handler mHandler = new Handler(){

        public void handleMessage(Message message) {
            super.handleMessage(message);
            FTReader.this.gHandlerSendMessage(message.what, message.obj);
        }
    };

    public FTReader(Context context, Handler handler, int n) {
        this.gHandler = handler;
        try {
            switch (n) {
                case 0: {
                    this.ccidScheme = new CCIDScheme(new USB(context, this.mHandler), this.mHandler);
                    break;
                }
                case 1: {
                    this.ccidScheme = new CCIDScheme(new BT3(context, this.mHandler), this.mHandler);
                    break;
                }
                case 2: {
                    this.ccidScheme = new CCIDScheme(new BT4(context, this.mHandler), this.mHandler);
                }
                default: {
                    new Exception("FTREADER_TYPE error");
                    break;
                }
            }
        }
        catch (Exception exception) {
            this.showErrLog(exception);
        }
    }

    public void readerFind() throws FTException {
        try {
            this.ccidScheme.readerFind();
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
    }

    public String[] readerOpen(Object object2) throws FTException {
        String[] arrstring = null;
        try {
            arrstring = (String[])this.ccidScheme.readerOpen(object2);
            if (arrstring == null) {
                throw new FTException("readerNames == null");
            }
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
        return arrstring;
    }

    public void readerClose() throws FTException {
        try {
            this.ccidScheme.readerClose();
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
    }

    public byte[] readerPowerOn(int n) throws FTException {
        byte[] arrby = null;
        try {
            arrby = (byte[])this.ccidScheme.readerPowerOn(n);
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
        return arrby;
    }

    public void readerPowerOff(int n) throws FTException {
        try {
            this.ccidScheme.readerPowerOff(n);
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
    }

    public byte[] readerXfr(int n, byte[] arrby) throws FTException {
        byte[] arrby2 = null;
        try {
            int n2 = arrby.length;
            if (!(n2 == 4 || n2 == 5 || n2 == 7 && (arrby[4] & 255) == 0 || n2 > 5 && (arrby[4] & 255) != 0 && n2 == (arrby[4] & 255) + 4 + 1 || n2 > 7 && (arrby[4] & 255) == 0 && n2 == (arrby[5] & 255) * 256 + (arrby[6] & 255) + 4 + 3 || n2 > 6 && (arrby[4] & 255) != 0 && n2 == (arrby[4] & 255) + 4 + 1 + 1 || n2 > 10 && (arrby[4] & 255) == 0 && n2 == (arrby[5] & 255) * 256 + (arrby[6] & 255) + 4 + 3 + 3)) {
                throw new Exception("apdu lc le error");
            }
            arrby2 = (byte[])this.ccidScheme.readerXfrBlock(n, arrby);
            if (arrby2.length <= 0) {
                throw new Exception("apdu send recv error");
            }
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
        return arrby2;
    }

    public byte[] readerEscape(int n, byte[] arrby) throws FTException {
        byte[] arrby2 = null;
        try {
            arrby2 = (byte[])this.ccidScheme.readerEscape(n, arrby);
        }
        catch (Exception exception) {
            this.throwFTError(exception);
        }
        return arrby2;
    }

    public int readerGetSlotStatus(int n) throws FTException {
        try {
            int n2 = this.ccidScheme.readerSlotStatus(n);
            switch (n2) {
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
        catch (Exception exception) {
            this.throwFTError(exception);
        }
        return 2;
    }

    public int readerGetType() throws FTException {
        try {
            int n = this.ccidScheme.readerGetPid();
            switch (n) {
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
            }
            return 120;
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return 120;
        }
    }

    public byte[] readerGetSerialNumber() throws FTException {
        try {
            int n = this.readerGetType();
            if (n == 100 || n == 101 || n == 102 || n == 108) {
                byte[] arrby = new byte[]{-91, 90, 50, 49};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            if (n == 103 || n == 104) {
                byte[] arrby = new byte[]{-91, 90, 112, 0};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            if (n == 105 || n == 106 || n == 107) {
                byte[] arrby = new byte[]{90, -91, 49, 49};
                return this.readerEscape(0, arrby);
            }
            throw new Exception("Not Support");
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public String readerGetFirmwareVersion() throws FTException {
        try {
            int n = this.ccidScheme.readerGetBcdDevice();
            byte[] arrby = new byte[]{(byte)(n % 256)};
            return n / 256 + "." + Utility.bytes2HexStr(arrby);
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return "";
        }
    }

    public byte[] readerGetUID() throws FTException {
        try {
            int n = this.readerGetType();
            if (n == 100 || n == 101 || n == 102 || n == 103 || n == 104 || n == 108) {
                byte[] arrby = new byte[]{-91, 90, 49, 49};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            if (n == 105 || n == 106 || n == 107) {
                byte[] arrby = new byte[]{90, -91, 112, 49};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            throw new Exception("Not Support");
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public byte[] FT_AutoTurnOffReader(boolean bl) throws FTException {
        try {
            if (bl) {
                byte[] arrby = new byte[]{-91, 90, 57, 1};
                return this.readerEscape(0, arrby);
            }
            byte[] arrby = new byte[]{-91, 90, 57, 2};
            return this.readerEscape(0, arrby);
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public byte[] readerGetManufacturer() throws FTException {
        try {
            int n = this.readerGetType();
            if (n == 105 || n == 101 || n == 102) {
                byte[] arrby = new byte[]{-91, 90, 56, 19};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            throw new Exception("Not Support");
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public byte[] readerGetHardwareInfo() throws FTException {
        try {
            int n = this.readerGetType();
            if (n == 101 || n == 102) {
                byte[] arrby = new byte[]{-91, 90, 52, 1};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            if (n == 105) {
                byte[] arrby = new byte[]{-91, 90, 56, 21};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            throw new Exception("Not Support");
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public byte[] readerGetReaderName() throws FTException {
        try {
            int n = this.readerGetType();
            if (n == 105 || n == 101 || n == 102) {
                byte[] arrby = new byte[]{-91, 90, 56, 18};
                return this.readerEscapeWithParseSw1Sw2(arrby);
            }
            throw new Exception("Not Support");
        }
        catch (Exception exception) {
            this.throwFTError(exception);
            return null;
        }
    }

    public static String readerGetLibVersion() {
        return "0.7.04";
    }

    private byte[] readerEscapeWithParseSw1Sw2(byte[] arrby) throws Exception {
        int n;
        byte[] arrby2 = this.readerEscape(0, arrby);
        if (arrby2[(n = arrby2.length) - 2] == -112 && arrby2[n - 1] == 0) {
            byte[] arrby3 = new byte[n - 2];
            System.arraycopy(arrby2, 0, arrby3, 0, n - 2);
            return arrby3;
        }
        byte[] arrby4 = new byte[]{arrby2[n - 2], arrby2[n - 1]};
        String string = "[" + Utility.bytes2HexStr(arrby4) + "]";
        if (arrby4[0] == 108) {
            switch (arrby4[1]) {
                case 128: {
                    string = string + "Data length error";
                    break;
                }
                case 129: {
                    string = string + "LC length and data length not equal";
                    break;
                }
                case 130: {
                    string = string + "UID exist";
                    break;
                }
                case 131: {
                    string = string + "UID can't generate";
                    break;
                }
                case 132: {
                    string = string + "Ciphertext decryption data comparison error";
                    break;
                }
                case 133: {
                    string = string + "HID exist";
                    break;
                }
                case 134: {
                    string = string + "Out of storage range";
                    break;
                }
                case 135: {
                    string = string + "Unable to erase storage space normally";
                    break;
                }
                case 136: {
                    string = string + "Unable to read storage space normally";
                    break;
                }
                case 137: {
                    string = string + "Unable to write storage space normally";
                    break;
                }
                case 138: {
                    string = string + "Seed error";
                    break;
                }
                case 139: {
                    string = string + "Data error in data area";
                    break;
                }
                case 140: {
                    string = string + "Address byte check error";
                    break;
                }
                case 141: {
                    string = string + "The program is in space byte detection error";
                    break;
                }
                case 142: {
                    string = string + "Update step error";
                    break;
                }
                case 143: {
                    string = string + "Cipher check error";
                    break;
                }
                case 112: {
                    string = string + "Plaintext validation error";
                    break;
                }
                case 71: {
                    string = string + "Error with module communication";
                    break;
                }
            }
        }
        throw new Exception(string);
    }

    private void gHandlerSendMessage(int n, Object object2) {
        if (this.gHandler != null) {
            this.gHandler.sendMessage(this.gHandler.obtainMessage(n, object2));
        }
    }

    private void throwFTError(Exception exception) throws FTException {
        String string = Thread.currentThread().getStackTrace()[3].getClassName();
        String string2 = Thread.currentThread().getStackTrace()[3].getMethodName();
        exception.printStackTrace();
        throw new FTException("[ERROR][" + string + ":" + string2 + "][" + exception.getMessage() + "][" + exception.toString() + "]");
    }

    private void showErrLog(Exception exception) {
        String string = Thread.currentThread().getStackTrace()[3].getClassName();
        String string2 = Thread.currentThread().getStackTrace()[3].getMethodName();
        this.showLog("ERROR::" + string + ":" + string2 + " [" + exception.getMessage() + "]" + "[" + exception.toString() + "]");
    }

    private void showLog(String string) {
        String string2 = Thread.currentThread().getStackTrace()[3].getClassName();
        String string3 = Thread.currentThread().getStackTrace()[3].getMethodName();
        this.gHandlerSendMessage(80, "[LOG]" + string2 + ":" + string3 + "--->" + string);
    }

}

