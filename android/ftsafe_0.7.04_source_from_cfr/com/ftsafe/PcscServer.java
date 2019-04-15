/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Message
 */
package com.ftsafe;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PcscServer {
    Handler gHandler = null;
    FTReader ftReader = null;
    private boolean isContextVaild = false;
    private int gType;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
    private Handler mHandler = new Handler(){

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 113: 
                case 129: {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice)message.obj;
                    if (PcscServer.this.arrayForBlueToothDevice.contains((Object)bluetoothDevice)) break;
                    PcscServer.this.arrayForBlueToothDevice.add(bluetoothDevice);
                    break;
                }
                case 130: {
                    PcscServer.this.arrayForBlueToothDevice.clear();
                }
            }
            PcscServer.this.gHandlerSendMessage(message.what, message.obj);
        }
    };

    public PcscServer(final int n, Context context, Handler handler, int n2) {
        this.gHandler = handler;
        this.gType = n2;
        this.ftReader = new FTReader(context, this.mHandler, n2);
        new Thread(new Runnable(){

            @Override
            public void run() {
                PcscServer.this.startServer(n);
            }
        }).start();
    }

    private void startServer(int n) {
        try {
            String[] arrstring = null;
            byte[][] arrarrby = new byte[16][];
            Object object2 = null;
            ServerSocket serverSocket = new ServerSocket(n);
            block24 : do {
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                try {
                    do {
                        Object object3;
                        block89 : {
                            Object object42;
                            byte[] arrby;
                            int n2;
                            String string = bufferedReader.readLine();
                            object3 = null;
                            if (string == null) continue block24;
                            String[] arrstring2 = string.split(":");
                            String string2 = arrstring2[0];
                            if (string2.startsWith("typeA")) {
                                this.showLog("RECV : " + string + " FOR SCardEstablishContext");
                                try {
                                    if (this.isContextVaild) {
                                        object3 = "RECVOK";
                                        break block89;
                                    }
                                    if (this.gType == 0) {
                                        this.ftReader.readerFind();
                                        this.isContextVaild = true;
                                        object3 = "RECVOK";
                                        break block89;
                                    }
                                    this.arrayForBlueToothDevice.clear();
                                    this.isContextVaild = true;
                                    object3 = "RECVOK";
                                }
                                catch (Exception object42) {
                                    object3 = "RECVERR:0x8010002E";
                                    object2 = ((Throwable)object42).getMessage();
                                    this.isContextVaild = false;
                                }
                            } else if (string2.startsWith("typeB")) {
                                this.showLog("RECV : " + string + " FOR SCardReleaseContext");
                                try {
                                    if (this.gType == 0) {
                                        this.ftReader.readerClose();
                                        this.isContextVaild = false;
                                        object3 = "RECVOK";
                                        break block89;
                                    }
                                    this.arrayForBlueToothDevice.clear();
                                    this.isContextVaild = false;
                                    object3 = "RECVOK";
                                }
                                catch (Exception exception) {
                                    object3 = "RECVERR:0x88000006";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeC")) {
                                this.showLog("RECV : " + string + " FOR SCardListReaders");
                                try {
                                    if (this.isContextVaild) {
                                        if (this.gType == 0) {
                                            arrstring = this.ftReader.readerOpen(null);
                                            object42 = "RECVOK";
                                            for (n2 = 0; n2 < arrstring.length; ++n2) {
                                                object42 = (String)object42 + ":" + arrstring[n2];
                                            }
                                            object3 = object42;
                                        } else {
                                            this.ftReader.readerFind();
                                            if (this.arrayForBlueToothDevice.isEmpty()) {
                                                object3 = "RECVERR:0x8010002E";
                                                object2 = "arrayForBlueToothDevice.isEmpty()";
                                            } else {
                                                object42 = "RECVOK";
                                                for (n2 = 0; n2 < this.arrayForBlueToothDevice.size(); ++n2) {
                                                    object42 = (String)object42 + ":" + this.arrayForBlueToothDevice.get(n2).getName();
                                                }
                                                object3 = object42;
                                            }
                                        }
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x8010002E";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeD")) {
                                try {
                                    this.showLog("RECV : " + string + " FOR SCardConnect");
                                    if (this.isContextVaild) {
                                        if (arrstring2.length != 2) {
                                            object2 = object3 = "RECVERR:0x88000003";
                                        } else if (this.gType == 0) {
                                            int n3;
                                            for (n3 = 0; n3 < arrstring.length && !arrstring[n3].equals(arrstring2[1]); ++n3) {
                                            }
                                            arrarrby[n3] = null;
                                            this.showLog("BBBBBBBBBBBBBBBBBBBBBB" + n3);
                                            if ("typeD1".equals(arrstring2[0])) {
                                                arrarrby[n3] = this.ftReader.readerPowerOn(n3);
                                            }
                                            object3 = "RECVOK:" + n3;
                                        } else {
                                            if (this.arrayForBlueToothDevice.isEmpty()) {
                                                object3 = "RECVERR:0x8010002E";
                                                object2 = "arrayForBlueToothDevice.isEmpty()";
                                            }
                                            object42 = null;
                                            for (n2 = 0; n2 < this.arrayForBlueToothDevice.size(); ++n2) {
                                                if (!this.arrayForBlueToothDevice.get(n2).getName().equals(arrstring2[1])) continue;
                                                object42 = this.arrayForBlueToothDevice.get(n2);
                                                break;
                                            }
                                            if (object42 == null) {
                                                object3 = "RECVERR:0x88000004";
                                                object2 = "device = null";
                                            } else {
                                                arrstring = this.ftReader.readerOpen(object42);
                                                for (n2 = 0; n2 < arrstring.length && !arrstring[n2].substring(3).equals(arrstring2[1]); ++n2) {
                                                }
                                                arrarrby[n2] = null;
                                                if ("typeD1".equals(arrstring2[0])) {
                                                    Thread.sleep(500L);
                                                    try {
                                                        arrarrby[n2] = this.ftReader.readerPowerOn(n2);
                                                        object3 = "RECVOK:" + n2;
                                                    }
                                                    catch (Exception exception) {
                                                        object3 = "RECVERR:0x80100010";
                                                        object2 = exception.getMessage();
                                                    }
                                                } else {
                                                    object3 = "RECVOK:" + n2;
                                                }
                                            }
                                        }
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000005";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeE")) {
                                this.showLog("RECV : " + string + " FOR SCardStatus");
                                try {
                                    if (this.isContextVaild) {
                                        int n4 = Integer.parseInt(arrstring2[1]);
                                        n2 = this.ftReader.readerGetSlotStatus(n4);
                                        object3 = "RECVOK:" + n2 + ":" + Utility.bytes2HexStr(arrarrby[n4]);
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000000";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeF")) {
                                this.showLog("RECV : " + string + " FOR SCardTransmit");
                                try {
                                    int n5 = Integer.parseInt(arrstring2[1]);
                                    if (this.isContextVaild) {
                                        byte[] arrby2 = Utility.hexStrToBytes(arrstring2[2]);
                                        arrby = this.ftReader.readerXfr(n5, arrby2);
                                        object3 = "RECVOK:" + Utility.bytes2HexStr(arrby);
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000000";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeG")) {
                                this.showLog("RECV : " + string + " FOR SCardDisconnect");
                                try {
                                    int n6 = Integer.parseInt(arrstring2[1]);
                                    if (this.isContextVaild) {
                                        this.ftReader.readerPowerOff(n6);
                                        if (this.gType != 0) {
                                            this.ftReader.readerClose();
                                        }
                                        object3 = "RECVOK";
                                        this.arrayForBlueToothDevice.clear();
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000000";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeH")) {
                                this.showLog("RECV : " + string + "FOR SCardControl");
                                try {
                                    int n7 = Integer.parseInt(arrstring2[1]);
                                    if (this.isContextVaild) {
                                        byte[] arrby3 = Utility.hexStrToBytes(arrstring2[2]);
                                        arrby = this.ftReader.readerEscape(n7, arrby3);
                                        object3 = "RECVOK:" + Utility.bytes2HexStr(arrby);
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000000";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeI")) {
                                this.showLog("RECV : " + string + "FOR SCardIsValidContext");
                                if (this.isContextVaild) {
                                    object3 = "RECVOK";
                                } else {
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                            } else if (string2.startsWith("typeJ")) {
                                this.showLog("RECV : " + string + " FOR SCardGetStatusChange");
                                try {
                                    if (this.isContextVaild) {
                                        if (arrstring2.length != 2) {
                                            object2 = object3 = "RECVERR:0x88000003";
                                        } else if (arrstring == null) {
                                            object3 = "RECVERR:0x8010002E";
                                            object2 = "readerList is empty";
                                        } else if (this.gType == 0) {
                                            int n8;
                                            for (n8 = 0; n8 < arrstring.length; ++n8) {
                                                this.showLog("WW " + arrstring[n8]);
                                                if (arrstring[n8].equals(arrstring2[1])) break;
                                            }
                                            n2 = this.ftReader.readerGetSlotStatus(n8);
                                            object3 = "RECVOK:" + n2 + ":" + Utility.bytes2HexStr(arrarrby[n8]);
                                        } else {
                                            int n9;
                                            for (n9 = 0; n9 < arrstring.length; ++n9) {
                                                this.showLog("WW " + arrstring[n9]);
                                                if (arrstring[n9].substring(3).equals(arrstring2[1])) break;
                                            }
                                            if (n9 == arrstring.length) {
                                                object2 = object3 = "RECVERR:0x88000004";
                                            } else {
                                                n2 = this.ftReader.readerGetSlotStatus(n9);
                                                object3 = "RECVOK:" + n2 + ":" + Utility.bytes2HexStr(arrarrby[n9]);
                                            }
                                        }
                                        break block89;
                                    }
                                    object3 = "RECVERR:0x80100003";
                                    object2 = "isContextVaild false";
                                }
                                catch (Exception exception) {
                                    this.showLog("ERROR : " + exception.getMessage());
                                    object3 = "RECVERR:0x88000000";
                                    object2 = exception.getMessage();
                                }
                            } else if (string2.startsWith("typeK")) {
                                this.showLog("RECV : " + string + " FOR SCardGetLastError");
                                object3 = "RECVOK:" + (String)object2;
                            }
                        }
                        this.showLog("SEND : " + (String)object3);
                        printWriter.println((String)object3);
                    } while (true);
                }
                catch (Exception exception) {
                    socket.close();
                    continue;
                }
                break;
            } while (true);
        }
        catch (Exception exception) {
            this.showLog("startServer ERROR and END:" + exception.getMessage());
            return;
        }
    }

    private void gHandlerSendMessage(int n, Object object2) {
        if (this.gHandler != null) {
            this.gHandler.sendMessage(this.gHandler.obtainMessage(n, object2));
        }
    }

    private void showLog(String string) {
        if (this.gHandler != null) {
            String string2 = Thread.currentThread().getStackTrace()[3].getClassName();
            String string3 = Thread.currentThread().getStackTrace()[3].getMethodName();
            this.gHandler.sendMessage(this.gHandler.obtainMessage(96, (Object)("[LOG]" + string2 + ":" + string3 + "--->" + string)));
        }
    }

}

