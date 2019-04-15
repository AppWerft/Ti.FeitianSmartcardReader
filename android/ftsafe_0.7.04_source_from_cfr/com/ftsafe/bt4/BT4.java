/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Parcelable
 */
package com.ftsafe.bt4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.ftsafe.Utility;
import com.ftsafe.bt4.BluetoothLeClass;
import com.ftsafe.bt4.Bt4Exception;
import com.ftsafe.readerScheme.FTReaderInf;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;

public class BT4
implements FTReaderInf {
    private Context tContext;
    private Handler mHandler;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
    BluetoothAdapter mBlueToothAdapter = null;
    BluetoothDevice mBluetoothDevice = null;
    PipedInputStream pipeIn = new PipedInputStream();
    PipedOutputStream pipeOut = new PipedOutputStream();
    BluetoothLeClass mBluetoothLeClass = null;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback(){

        public void onLeScan(BluetoothDevice bluetoothDevice, int n, byte[] arrby) {
            if (!BT4.this.arrayForBlueToothDevice.contains((Object)bluetoothDevice) && bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("FT_")) {
                BT4.this.showLog("find : " + bluetoothDevice.getName());
                BT4.this.arrayForBlueToothDevice.add(bluetoothDevice);
                BT4.this.mHandlerSendMessage(129, (Object)bluetoothDevice);
            }
        }
    };
    BroadcastReceiver mBt4Receiver = new BroadcastReceiver(){

        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction()) && (bluetoothDevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getName() != null && BT4.this.mBluetoothDevice != null && bluetoothDevice.getName().equals(BT4.this.mBluetoothDevice.getName())) {
                BT4.this.showLog("ACTION_ACL_DISCONNECTED " + bluetoothDevice.getAddress());
                BT4.this.mHandlerSendMessage(130, (Object)bluetoothDevice);
                BT4.this.ft_close();
            }
        }
    };
    boolean isRecvApdu = false;
    private boolean isDataComing = false;

    public BT4(Context context, Handler handler) throws Bt4Exception {
        this.tContext = context;
        this.mHandler = handler;
        this.mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.mBlueToothAdapter == null) {
            throw new Bt4Exception("BluetoothAdapter.getDefaultAdapter() == null");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        this.tContext.registerReceiver(this.mBt4Receiver, intentFilter);
        this.mBluetoothLeClass = new BluetoothLeClass(this.tContext);
        if (!this.mBluetoothLeClass.initialize()) {
            throw new Bt4Exception("mBluetoothLeClass.initialize() error");
        }
        this.mBluetoothLeClass.setOnServiceDiscoverListener(new BluetoothLeClass.OnServiceDiscoverListener(){

            @Override
            public void onServiceDiscover(BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnConnectListener(new BluetoothLeClass.OnConnectListener(){

            @Override
            public void onConnect(BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnDisconnectListener(new BluetoothLeClass.OnDisconnectListener(){

            @Override
            public void onDisconnect(BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnDataAvailableListener(new BluetoothLeClass.OnDataAvailableListener(){

            @Override
            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n) {
            }

            @Override
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                try {
                    byte[] arrby = bluetoothGattCharacteristic.getValue();
                    if (arrby == null && arrby.length <= 0) {
                        return;
                    }
                    BT4.this.showLog("NEW:" + Utility.bytes2HexStr(arrby));
                    if (arrby[0] == 80 && arrby[1] == 2 && arrby.length == 2) {
                        BT4.this.mHandlerSendMessage(512, "");
                    } else if (arrby[0] == 80 && arrby[1] == 3 && arrby.length == 2) {
                        BT4.this.mHandlerSendMessage(256, "");
                    } else {
                        BT4.this.pipeOut.write(arrby, 0, arrby.length);
                        BT4.this.notifyDataComing();
                    }
                }
                catch (IOException iOException) {
                    BT4.this.showLog("OnDataAvailableListener.onCharacteristicChanged:" + iOException.getMessage());
                }
            }
        });
        try {
            this.pipeIn.connect(this.pipeOut);
        }
        catch (IOException iOException) {
            throw new Bt4Exception(iOException.getMessage());
        }
    }

    protected void finalize() throws Throwable {
        this.tContext.unregisterReceiver(this.mBt4Receiver);
        super.finalize();
    }

    @Override
    public Boolean isFtExist() {
        if (this.mBluetoothDevice != null && this.mBluetoothLeClass.getBluetoothGatt() != null) {
            return true;
        }
        return false;
    }

    @Override
    public void ft_find() throws Bt4Exception {
        if (this.mBlueToothAdapter != null) {
            if (this.mBluetoothLeClass.getBluetoothGatt() != null && this.mBluetoothLeClass.getBluetoothGatt().connect()) {
                this.ft_close();
            }
        } else {
            this.arrayForBlueToothDevice.clear();
            throw new Bt4Exception("mBlueToothAdapter == null");
        }
        this.arrayForBlueToothDevice.clear();
        this.mBlueToothAdapter.startLeScan(this.mLeScanCallback);
    }

    @Override
    public void ft_open(Object object2) throws Bt4Exception {
        try {
            if (object2 == null) {
                throw new Exception("device == null");
            }
            this.mBlueToothAdapter.stopLeScan(this.mLeScanCallback);
            this.arrayForBlueToothDevice.clear();
            if (this.mBluetoothDevice != null && !this.mBluetoothDevice.equals(object2)) {
                this.ft_close();
            }
            this.mBluetoothDevice = (BluetoothDevice)object2;
            if (this.mBluetoothLeClass.getBluetoothGatt() == null && !this.mBluetoothLeClass.connect(this.mBluetoothDevice.getAddress())) {
                throw new Exception("mBluetoothLeClass.connect failed");
            }
            Thread.sleep(100L);
        }
        catch (Exception exception) {
            throw new Bt4Exception(exception.getMessage());
        }
    }

    @Override
    public void ft_close() {
        if (this.mBluetoothDevice == null) {
            return;
        }
        this.mBluetoothLeClass.disconnect();
        this.mBluetoothLeClass.close();
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
    public byte[] ft_control(int n, int n2, int n3, int n4, int n5, int n6) throws Bt4Exception {
        if (n == 128 && n2 == 6 && n3 == 256 && n4 == 0) {
            return this.intsToBytes(new int[]{18, 1, 16, 1, 0, 0, 0, 8, 110, 9, 35, 6, 16, 1, 1, 2, 0, 1});
        }
        if (n == 128 && n2 == 6 && n3 == 512 && n4 == 0) {
            return this.intsToBytes(new int[]{9, 2, 93, 0, 1, 1, 0, 128, 150, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 16, 1, 0, 7, 3, 0, 0, 0, 160, 15, 0, 0, 224, 46, 0, 0, 4, 0, 42, 0, 0, 44, 128, 10, 0, 46, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 186, 4, 4, 0, 15, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 3, 2, 64, 0, 0, 7, 5, 133, 2, 64, 0, 0});
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
            return this.intsToBytes(new int[]{28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 52, 0, 46, 0, 48, 0});
        }
        return null;
    }

    @Override
    public void ft_send(int n, byte[] arrby, int n2) throws Bt4Exception {
        try {
            this.pipeIn = new PipedInputStream();
            this.pipeOut = new PipedOutputStream();
            try {
                this.pipeIn.connect(this.pipeOut);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.showLog("SSSSSSSSend:" + Utility.bytes2HexStr(arrby));
            int n3 = arrby.length;
            int n4 = 0;
            while (n3 > 0) {
                byte[] arrby2;
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (n3 > 20) {
                    arrby2 = new byte[20];
                    System.arraycopy(arrby, n4, arrby2, 0, 20);
                    n3 -= 20;
                    n4 += 20;
                    if (this.mBluetoothLeClass.writeCharacteristic(arrby2)) continue;
                    this.isRecvApdu = false;
                    throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
                }
                arrby2 = new byte[n3];
                System.arraycopy(arrby, n4, arrby2, 0, n3);
                n3 -= n3;
                n4 += n3;
                if (this.mBluetoothLeClass.writeCharacteristic(arrby2)) break;
                this.isRecvApdu = false;
                throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
            }
        }
        catch (Exception exception) {
            throw new Bt4Exception(exception.getMessage());
        }
    }

    @Override
    public byte[] ft_recv(int n, int n2) throws Bt4Exception {
        this.showLog("timeout:" + n2);
        return this.BlueToothRead(n2);
    }

    private byte[] BlueToothRead(int n) throws Bt4Exception {
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
            throw new Bt4Exception("BlueToothRead:" + exception.getMessage());
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
        this.mHandlerSendMessage(128, "[LOG]" + string2 + ":" + string3 + "--->" + string);
    }

}

