/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothSocket
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Parcelable
 */
package com.ftsafe.bt3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.ftsafe.Utility;
import com.ftsafe.bt3.Bt3Exception;
import com.ftsafe.readerScheme.FTReaderInf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class BT3
implements FTReaderInf {
    private Context tContext;
    private Handler mHandler = null;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
    BluetoothAdapter mBlueToothAdapter = null;
    BluetoothDevice mBluetoothDevice = null;
    BluetoothSocket mBlueToothSocket = null;
    PipedInputStream pipeIn = new PipedInputStream();
    PipedOutputStream pipeOut = new PipedOutputStream();
    byte[] readData = null;
    BroadcastReceiver mBt3Receiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.device.action.FOUND".equals(intent.getAction()) && !BT3.this.arrayForBlueToothDevice.contains((Object)(bluetoothDevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"))) && bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("FT_")) {
                BT3.this.arrayForBlueToothDevice.add(bluetoothDevice);
                BT3.this.mHandlerSendMessage(113, (Object)bluetoothDevice);
            }
        }
    };
    private boolean isRecvApdu = false;
    private boolean isDataComing = false;

    public BT3(Context context, Handler handler) throws Bt3Exception {
        this.tContext = context;
        this.mHandler = handler;
        this.mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.mBlueToothAdapter == null) {
            throw new Bt3Exception("BluetoothAdapter.getDefaultAdapter() == null");
        }
        this.tContext.registerReceiver(this.mBt3Receiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    do {
                        if (BT3.this.mBluetoothDevice != null && BT3.this.mBlueToothSocket != null && BT3.this.mBlueToothSocket.isConnected()) {
                            byte[] arrby = new byte[1024];
                            if (BT3.this.mBlueToothSocket.getInputStream().available() == 0) {
                                Thread.sleep(100L);
                                continue;
                            }
                            int n = BT3.this.mBlueToothSocket.getInputStream().read(arrby);
                            if (arrby[0] == 80 && arrby[1] == 2 && n == 2) {
                                BT3.this.mHandlerSendMessage(512, "");
                                continue;
                            }
                            if (arrby[0] == 80 && arrby[1] == 3 && n == 2) {
                                BT3.this.mHandlerSendMessage(256, "");
                                continue;
                            }
                            if (BT3.this.isRecvApdu) {
                                BT3.this.pipeOut.write(arrby, 0, n);
                                BT3.this.notifyDataComing();
                                continue;
                            }
                            BT3.this.showLog("dirty data:" + Utility.bytes2HexStr(arrby, n));
                            continue;
                        }
                        Thread.sleep(1000L);
                    } while (true);
                }
                catch (Exception exception) {
                    return;
                }
            }
        }).start();
        try {
            this.pipeIn.connect(this.pipeOut);
        }
        catch (IOException iOException) {
            throw new Bt3Exception(iOException.getMessage());
        }
    }

    protected void finalize() throws Throwable {
        this.tContext.unregisterReceiver(this.mBt3Receiver);
        super.finalize();
    }

    @Override
    public Boolean isFtExist() {
        if (this.mBluetoothDevice != null && this.mBlueToothSocket != null) {
            return true;
        }
        return false;
    }

    @Override
    public void ft_find() throws Bt3Exception {
        if (this.mBlueToothAdapter != null) {
            this.arrayForBlueToothDevice.clear();
            Set set = this.mBlueToothAdapter.getBondedDevices();
            if (set.size() > 0) {
                for (BluetoothDevice bluetoothDevice : set) {
                    if (this.arrayForBlueToothDevice.contains((Object)bluetoothDevice) || bluetoothDevice.getName() == null || !bluetoothDevice.getName().startsWith("FT_")) continue;
                    this.arrayForBlueToothDevice.add(bluetoothDevice);
                    this.mHandlerSendMessage(113, (Object)bluetoothDevice);
                }
            }
            if (!this.mBlueToothAdapter.isDiscovering()) {
                this.mBlueToothAdapter.startDiscovery();
            }
        } else {
            this.arrayForBlueToothDevice.clear();
            throw new Bt3Exception("mBlueToothAdapter == null");
        }
    }

    @Override
    public void ft_open(Object object2) throws Bt3Exception {
        if (object2 == null) {
            throw new Bt3Exception("device == null");
        }
        this.mBlueToothAdapter.cancelDiscovery();
        try {
            if (this.mBlueToothSocket != null && this.mBlueToothSocket.isConnected() && this.mBluetoothDevice.getAddress().equals(((BluetoothDevice)object2).getAddress())) {
                this.showLog("donaaaaaaaaaaaaaaaaaaaaaa");
                return;
            }
            this.mBluetoothDevice = (BluetoothDevice)object2;
            if (this.mBlueToothSocket != null) {
                this.mBlueToothSocket.close();
            }
            this.mBlueToothSocket = this.mBluetoothDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            this.mBlueToothSocket.connect();
        }
        catch (Exception exception) {
            throw new Bt3Exception(exception.getMessage());
        }
    }

    @Override
    public void ft_close() {
        if (this.mBluetoothDevice == null) {
            return;
        }
        if (this.mBlueToothSocket != null) {
            try {
                this.mBlueToothSocket.close();
            }
            catch (IOException iOException) {
                this.showLog("ft_close::mBlueToothSocket.close()::do-nothing::" + iOException.getMessage());
            }
            this.mBlueToothSocket = null;
        }
        this.mBluetoothDevice = null;
    }

    private byte[] intsToBytes(int[] arrn) {
        byte[] arrby = new byte[arrn.length];
        for (int i = 0; i < arrn.length; ++i) {
            arrby[i] = (byte)arrn[i];
        }
        return arrby;
    }

    @Override
    public byte[] ft_control(int n, int n2, int n3, int n4, int n5, int n6) throws Bt3Exception {
        if (n == 128 && n2 == 6 && n3 == 256 && n4 == 0) {
            return this.intsToBytes(new int[]{18, 1, 16, 1, 0, 0, 0, 32, 110, 9, 26, 6, 69, 1, 1, 2, 0, 1});
        }
        if (n == 128 && n2 == 6 && n3 == 512 && n4 == 0) {
            return this.intsToBytes(new int[]{9, 2, 93, 0, 1, 1, 0, 128, 128, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 0, 1, 0, 7, 3, 0, 0, 0, 116, 14, 0, 0, 116, 14, 0, 0, 0, 218, 38, 0, 0, 72, 219, 4, 0, 53, 16, 1, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 190, 4, 4, 0, 16, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 1, 2, 32, 0, 0, 7, 5, 129, 2, 32, 0, 0});
        }
        if (n == 128 && n2 == 6 && n3 == 769 && n4 == 1033) {
            return this.intsToBytes(new int[]{6, 3, 70, 0, 84, 0});
        }
        if (n == 128 && n2 == 6 && n3 == 770 && n4 == 1033) {
            if (this.mBluetoothDevice != null) {
                char[] arrc = this.mBluetoothDevice.getName().toCharArray();
                int[] arrn = new int[arrc.length * 2 + 2];
                arrn[0] = arrn.length;
                arrn[1] = 3;
                for (int i = 0; i < arrc.length; ++i) {
                    arrn[2 + i * 2] = arrc[i];
                    arrn[2 + i * 2 + 1] = 0;
                }
                return this.intsToBytes(arrn);
            }
            return this.intsToBytes(new int[]{28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 51, 0, 46, 0, 48, 0});
        }
        return null;
    }

    @Override
    public void ft_send(int n, byte[] arrby, int n2) throws Bt3Exception {
        try {
            this.pipeIn = new PipedInputStream();
            this.pipeOut = new PipedOutputStream();
            try {
                this.pipeIn.connect(this.pipeOut);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.mBlueToothSocket.getOutputStream().write(arrby);
            this.mBlueToothSocket.getOutputStream().flush();
        }
        catch (Exception exception) {
            throw new Bt3Exception("bt3:ft_send:" + exception.getMessage());
        }
    }

    @Override
    public byte[] ft_recv(int n, int n2) throws Bt3Exception {
        byte[] arrby = this.BlueToothRead(n2);
        return arrby;
    }

    private byte[] BlueToothRead(int n) throws Bt3Exception {
        try {
            byte[] arrby = null;
            byte[] arrby2 = new byte[4096];
            this.isRecvApdu = true;
            do {
                this.getPipeByte(arrby2, 0, 1, n);
            } while ((arrby2[0] & 128) != 128);
            this.getPipeByte(arrby2, 1, 9, n);
            int n2 = (arrby2[1] & 255) + ((arrby2[2] & 255) << 8) + ((arrby2[3] & 255) << 16) + ((arrby2[4] & 255) << 24);
            if ((n2 += 10) > 10) {
                this.getPipeByte(arrby2, 10, n2 - 10, n);
            }
            arrby = new byte[n2];
            System.arraycopy(arrby2, 0, arrby, 0, n2);
            this.isRecvApdu = false;
            return arrby;
        }
        catch (Exception exception) {
            throw new Bt3Exception("BlueToothRead:" + exception.getMessage());
        }
    }

    private void getPipeByte(byte[] arrby, int n, int n2, int n3) throws Exception {
        try {
            do {
                if (this.pipeIn.available() >= n2) {
                    byte[] arrby2 = new byte[n2];
                    this.pipeIn.read(arrby2, 0, n2);
                    System.arraycopy(arrby2, 0, arrby, n, n2);
                    return;
                }
                this.isDataComing = false;
            } while (this.waitForDataComing(n3));
            throw new Exception("getPipeByte timeout");
        }
        catch (IOException iOException) {
            throw new Exception(iOException.getMessage());
        }
    }

    synchronized boolean waitForDataComing(long l) {
        if (!this.isDataComing) {
            long l2 = System.currentTimeMillis();
            do {
                try {
                    this.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (this.isDataComing) break;
                long l3 = System.currentTimeMillis();
                if (l3 - l2 >= l) {
                    return false;
                }
                l -= l3 - l2;
                l2 = l3;
            } while (true);
        }
        return true;
    }

    synchronized void notifyDataComing() {
        this.isDataComing = true;
        this.notify();
    }

    private void mHandlerSendMessage(int n, Object object2) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(n, object2));
        }
    }

    private void showLog(String string) {
        String string2 = Thread.currentThread().getStackTrace()[3].getClassName();
        String string3 = Thread.currentThread().getStackTrace()[3].getMethodName();
        this.mHandlerSendMessage(112, "[LOG]" + string2 + ":" + string3 + "--->" + string);
    }

}

