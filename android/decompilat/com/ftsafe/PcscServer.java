// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe;

import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import android.os.Message;
import android.content.Context;
import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import com.ftsafe.readerScheme.FTReader;
import android.os.Handler;

public class PcscServer
{
    Handler gHandler;
    FTReader ftReader;
    private boolean isContextVaild;
    private int gType;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice;
    private Handler mHandler;
    
    public PcscServer(final int n, final Context context, final Handler gHandler, final int gType) {
        this.gHandler = null;
        this.ftReader = null;
        this.isContextVaild = false;
        this.arrayForBlueToothDevice = new ArrayList<BluetoothDevice>();
        this.mHandler = new Handler() {
            public void handleMessage(final Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 113:
                    case 129: {
                        final BluetoothDevice bluetoothDevice = (BluetoothDevice)message.obj;
                        if (!PcscServer.this.arrayForBlueToothDevice.contains(bluetoothDevice)) {
                            PcscServer.this.arrayForBlueToothDevice.add(bluetoothDevice);
                            break;
                        }
                        break;
                    }
                    case 130: {
                        PcscServer.this.arrayForBlueToothDevice.clear();
                        break;
                    }
                }
                PcscServer.this.gHandlerSendMessage(message.what, message.obj);
            }
        };
        this.gHandler = gHandler;
        this.gType = gType;
        this.ftReader = new FTReader(context, this.mHandler, gType);
        new Thread(new Runnable() {
            @Override
            public void run() {
                PcscServer.this.startServer(n);
            }
        }).start();
    }
    
    private void startServer(final int port) {
        try {
            String[] array = null;
            final byte[][] array2 = new byte[16][];
            String str = null;
            final ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                final Socket accept = serverSocket.accept();
                final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(accept.getOutputStream())), true);
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                try {
                    while (true) {
                        final String line = bufferedReader.readLine();
                        String s = null;
                        if (line == null) {
                            break;
                        }
                        final String[] split = line.split(":");
                        final String s2 = split[0];
                        if (s2.startsWith("typeA")) {
                            this.showLog("RECV : " + line + " FOR SCardEstablishContext");
                            try {
                                if (this.isContextVaild) {
                                    s = "RECVOK";
                                }
                                else if (this.gType == 0) {
                                    this.ftReader.readerFind();
                                    this.isContextVaild = true;
                                    s = "RECVOK";
                                }
                                else {
                                    this.arrayForBlueToothDevice.clear();
                                    this.isContextVaild = true;
                                    s = "RECVOK";
                                }
                            }
                            catch (Exception ex) {
                                s = "RECVERR:0x8010002E";
                                str = ex.getMessage();
                                this.isContextVaild = false;
                            }
                        }
                        else if (s2.startsWith("typeB")) {
                            this.showLog("RECV : " + line + " FOR SCardReleaseContext");
                            try {
                                if (this.gType == 0) {
                                    this.ftReader.readerClose();
                                    this.isContextVaild = false;
                                    s = "RECVOK";
                                }
                                else {
                                    this.arrayForBlueToothDevice.clear();
                                    this.isContextVaild = false;
                                    s = "RECVOK";
                                }
                            }
                            catch (Exception ex2) {
                                s = "RECVERR:0x88000006";
                                str = ex2.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeC")) {
                            this.showLog("RECV : " + line + " FOR SCardListReaders");
                            try {
                                if (this.isContextVaild) {
                                    if (this.gType == 0) {
                                        array = this.ftReader.readerOpen(null);
                                        String string = "RECVOK";
                                        for (int i = 0; i < array.length; ++i) {
                                            string = string + ":" + array[i];
                                        }
                                        s = string;
                                    }
                                    else {
                                        this.ftReader.readerFind();
                                        if (this.arrayForBlueToothDevice.isEmpty()) {
                                            s = "RECVERR:0x8010002E";
                                            str = "arrayForBlueToothDevice.isEmpty()";
                                        }
                                        else {
                                            String string2 = "RECVOK";
                                            for (int j = 0; j < this.arrayForBlueToothDevice.size(); ++j) {
                                                string2 = string2 + ":" + this.arrayForBlueToothDevice.get(j).getName();
                                            }
                                            s = string2;
                                        }
                                    }
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex3) {
                                this.showLog("ERROR : " + ex3.getMessage());
                                s = "RECVERR:0x8010002E";
                                str = ex3.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeD")) {
                            try {
                                this.showLog("RECV : " + line + " FOR SCardConnect");
                                if (this.isContextVaild) {
                                    if (split.length != 2) {
                                        s = (str = "RECVERR:0x88000003");
                                    }
                                    else if (this.gType == 0) {
                                        int n;
                                        for (n = 0; n < array.length && !array[n].equals(split[1]); ++n) {}
                                        array2[n] = null;
                                        this.showLog("BBBBBBBBBBBBBBBBBBBBBB" + n);
                                        if ("typeD1".equals(split[0])) {
                                            array2[n] = this.ftReader.readerPowerOn(n);
                                        }
                                        s = "RECVOK:" + n;
                                    }
                                    else {
                                        if (this.arrayForBlueToothDevice.isEmpty()) {
                                            str = "arrayForBlueToothDevice.isEmpty()";
                                        }
                                        Object o = null;
                                        for (int k = 0; k < this.arrayForBlueToothDevice.size(); ++k) {
                                            if (this.arrayForBlueToothDevice.get(k).getName().equals(split[1])) {
                                                o = this.arrayForBlueToothDevice.get(k);
                                                break;
                                            }
                                        }
                                        if (o == null) {
                                            s = "RECVERR:0x88000004";
                                            str = "device = null";
                                        }
                                        else {
                                            int n2;
                                            for (array = this.ftReader.readerOpen(o), n2 = 0; n2 < array.length && !array[n2].substring(3).equals(split[1]); ++n2) {}
                                            array2[n2] = null;
                                            if ("typeD1".equals(split[0])) {
                                                Thread.sleep(500L);
                                                try {
                                                    array2[n2] = this.ftReader.readerPowerOn(n2);
                                                    s = "RECVOK:" + n2;
                                                }
                                                catch (Exception ex4) {
                                                    s = "RECVERR:0x80100010";
                                                    str = ex4.getMessage();
                                                }
                                            }
                                            else {
                                                s = "RECVOK:" + n2;
                                            }
                                        }
                                    }
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex5) {
                                this.showLog("ERROR : " + ex5.getMessage());
                                s = "RECVERR:0x88000005";
                                str = ex5.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeE")) {
                            this.showLog("RECV : " + line + " FOR SCardStatus");
                            try {
                                if (this.isContextVaild) {
                                    final int int1 = Integer.parseInt(split[1]);
                                    s = "RECVOK:" + this.ftReader.readerGetSlotStatus(int1) + ":" + Utility.bytes2HexStr(array2[int1]);
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex6) {
                                this.showLog("ERROR : " + ex6.getMessage());
                                s = "RECVERR:0x88000000";
                                str = ex6.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeF")) {
                            this.showLog("RECV : " + line + " FOR SCardTransmit");
                            try {
                                final int int2 = Integer.parseInt(split[1]);
                                if (this.isContextVaild) {
                                    s = "RECVOK:" + Utility.bytes2HexStr(this.ftReader.readerXfr(int2, Utility.hexStrToBytes(split[2])));
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex7) {
                                this.showLog("ERROR : " + ex7.getMessage());
                                s = "RECVERR:0x88000000";
                                str = ex7.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeG")) {
                            this.showLog("RECV : " + line + " FOR SCardDisconnect");
                            try {
                                final int int3 = Integer.parseInt(split[1]);
                                if (this.isContextVaild) {
                                    this.ftReader.readerPowerOff(int3);
                                    if (this.gType != 0) {
                                        this.ftReader.readerClose();
                                    }
                                    s = "RECVOK";
                                    this.arrayForBlueToothDevice.clear();
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex8) {
                                this.showLog("ERROR : " + ex8.getMessage());
                                s = "RECVERR:0x88000000";
                                str = ex8.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeH")) {
                            this.showLog("RECV : " + line + "FOR SCardControl");
                            try {
                                final int int4 = Integer.parseInt(split[1]);
                                if (this.isContextVaild) {
                                    s = "RECVOK:" + Utility.bytes2HexStr(this.ftReader.readerEscape(int4, Utility.hexStrToBytes(split[2])));
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex9) {
                                this.showLog("ERROR : " + ex9.getMessage());
                                s = "RECVERR:0x88000000";
                                str = ex9.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeI")) {
                            this.showLog("RECV : " + line + "FOR SCardIsValidContext");
                            if (this.isContextVaild) {
                                s = "RECVOK";
                            }
                            else {
                                s = "RECVERR:0x80100003";
                                str = "isContextVaild false";
                            }
                        }
                        else if (s2.startsWith("typeJ")) {
                            this.showLog("RECV : " + line + " FOR SCardGetStatusChange");
                            try {
                                if (this.isContextVaild) {
                                    if (split.length != 2) {
                                        s = (str = "RECVERR:0x88000003");
                                    }
                                    else if (array == null) {
                                        s = "RECVERR:0x8010002E";
                                        str = "readerList is empty";
                                    }
                                    else if (this.gType == 0) {
                                        int l;
                                        for (l = 0; l < array.length; ++l) {
                                            this.showLog("WW " + array[l]);
                                            if (array[l].equals(split[1])) {
                                                break;
                                            }
                                        }
                                        s = "RECVOK:" + this.ftReader.readerGetSlotStatus(l) + ":" + Utility.bytes2HexStr(array2[l]);
                                    }
                                    else {
                                        int n3;
                                        for (n3 = 0; n3 < array.length; ++n3) {
                                            this.showLog("WW " + array[n3]);
                                            if (array[n3].substring(3).equals(split[1])) {
                                                break;
                                            }
                                        }
                                        if (n3 == array.length) {
                                            s = (str = "RECVERR:0x88000004");
                                        }
                                        else {
                                            s = "RECVOK:" + this.ftReader.readerGetSlotStatus(n3) + ":" + Utility.bytes2HexStr(array2[n3]);
                                        }
                                    }
                                }
                                else {
                                    s = "RECVERR:0x80100003";
                                    str = "isContextVaild false";
                                }
                            }
                            catch (Exception ex10) {
                                this.showLog("ERROR : " + ex10.getMessage());
                                s = "RECVERR:0x88000000";
                                str = ex10.getMessage();
                            }
                        }
                        else if (s2.startsWith("typeK")) {
                            this.showLog("RECV : " + line + " FOR SCardGetLastError");
                            s = "RECVOK:" + str;
                        }
                        this.showLog("SEND : " + s);
                        printWriter.println(s);
                    }
                }
                catch (Exception ex12) {
                    accept.close();
                }
            }
        }
        catch (Exception ex11) {
            this.showLog("startServer ERROR and END:" + ex11.getMessage());
        }
    }
    
    private void gHandlerSendMessage(final int n, final Object o) {
        if (this.gHandler != null) {
            this.gHandler.sendMessage(this.gHandler.obtainMessage(n, o));
        }
    }
    
    private void showLog(final String str) {
        if (this.gHandler != null) {
            this.gHandler.sendMessage(this.gHandler.obtainMessage(96, (Object)("[LOG]" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + "--->" + str)));
        }
    }
}
