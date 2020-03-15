// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.bt4;

import java.io.IOException;
import com.ftsafe.Utility;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGatt;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.BroadcastReceiver;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import android.os.Handler;
import android.content.Context;
import com.ftsafe.readerScheme.FTReaderInf;

public class BT4 implements FTReaderInf
{
    private Context tContext;
    private Handler mHandler;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice;
    BluetoothAdapter mBlueToothAdapter;
    BluetoothDevice mBluetoothDevice;
    PipedInputStream pipeIn;
    PipedOutputStream pipeOut;
    BluetoothLeClass mBluetoothLeClass;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    BroadcastReceiver mBt4Receiver;
    boolean isRecvApdu;
    private boolean isDataComing;
    
    public BT4(final Context tContext, final Handler mHandler) throws Bt4Exception {
        this.arrayForBlueToothDevice = new ArrayList<BluetoothDevice>();
        this.mBlueToothAdapter = null;
        this.mBluetoothDevice = null;
        this.pipeIn = new PipedInputStream();
        this.pipeOut = new PipedOutputStream();
        this.mBluetoothLeClass = null;
        this.mLeScanCallback = (BluetoothAdapter.LeScanCallback)new BluetoothAdapter.LeScanCallback() {
            public void onLeScan(final BluetoothDevice bluetoothDevice, final int n, final byte[] array) {
                if (!BT4.this.arrayForBlueToothDevice.contains(bluetoothDevice) && bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("FT_")) {
                    BT4.this.showLog("find : " + bluetoothDevice.getName());
                    BT4.this.arrayForBlueToothDevice.add(bluetoothDevice);
                    BT4.this.mHandlerSendMessage(129, bluetoothDevice);
                }
            }
        };
        this.mBt4Receiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction())) {
                    final BluetoothDevice bluetoothDevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getName() != null && BT4.this.mBluetoothDevice != null && bluetoothDevice.getName().equals(BT4.this.mBluetoothDevice.getName())) {
                        BT4.this.showLog("ACTION_ACL_DISCONNECTED " + bluetoothDevice.getAddress());
                        BT4.this.mHandlerSendMessage(130, bluetoothDevice);
                        BT4.this.ft_close();
                    }
                }
            }
        };
        this.isRecvApdu = false;
        this.isDataComing = false;
        this.tContext = tContext;
        this.mHandler = mHandler;
        this.mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.mBlueToothAdapter == null) {
            throw new Bt4Exception("BluetoothAdapter.getDefaultAdapter() == null");
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        this.tContext.registerReceiver(this.mBt4Receiver, intentFilter);
        this.mBluetoothLeClass = new BluetoothLeClass(this.tContext);
        if (!this.mBluetoothLeClass.initialize()) {
            throw new Bt4Exception("mBluetoothLeClass.initialize() error");
        }
        this.mBluetoothLeClass.setOnServiceDiscoverListener(new BluetoothLeClass.OnServiceDiscoverListener() {
            @Override
            public void onServiceDiscover(final BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnConnectListener(new BluetoothLeClass.OnConnectListener() {
            @Override
            public void onConnect(final BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnDisconnectListener(new BluetoothLeClass.OnDisconnectListener() {
            @Override
            public void onDisconnect(final BluetoothGatt bluetoothGatt) {
            }
        });
        this.mBluetoothLeClass.setOnDataAvailableListener(new BluetoothLeClass.OnDataAvailableListener() {
            @Override
            public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int n) {
            }
            
            @Override
            public void onCharacteristicChanged(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                try {
                    final byte[] value = bluetoothGattCharacteristic.getValue();
                    if (value == null && value.length <= 0) {
                        return;
                    }
                    BT4.this.showLog("NEW:" + Utility.bytes2HexStr(value));
                    if (value[0] == 80 && value[1] == 2 && value.length == 2) {
                        BT4.this.mHandlerSendMessage(512, "");
                    }
                    else if (value[0] == 80 && value[1] == 3 && value.length == 2) {
                        BT4.this.mHandlerSendMessage(256, "");
                    }
                    else {
                        BT4.this.pipeOut.write(value, 0, value.length);
                        BT4.this.notifyDataComing();
                    }
                }
                catch (IOException ex) {
                    BT4.this.showLog("OnDataAvailableListener.onCharacteristicChanged:" + ex.getMessage());
                }
            }
        });
        try {
            this.pipeIn.connect(this.pipeOut);
        }
        catch (IOException ex) {
            throw new Bt4Exception(ex.getMessage());
        }
    }
    
    @Override
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
            this.arrayForBlueToothDevice.clear();
            this.mBlueToothAdapter.startLeScan(this.mLeScanCallback);
            return;
        }
        this.arrayForBlueToothDevice.clear();
        throw new Bt4Exception("mBlueToothAdapter == null");
    }
    
    @Override
    public void ft_open(final Object o) throws Bt4Exception {
        try {
            if (o == null) {
                throw new Exception("device == null");
            }
            this.mBlueToothAdapter.stopLeScan(this.mLeScanCallback);
            this.arrayForBlueToothDevice.clear();
            if (this.mBluetoothDevice != null && !this.mBluetoothDevice.equals(o)) {
                this.ft_close();
            }
            this.mBluetoothDevice = (BluetoothDevice)o;
            if (this.mBluetoothLeClass.getBluetoothGatt() == null && !this.mBluetoothLeClass.connect(this.mBluetoothDevice.getAddress())) {
                throw new Exception("mBluetoothLeClass.connect failed");
            }
            Thread.sleep(100L);
        }
        catch (Exception ex) {
            throw new Bt4Exception(ex.getMessage());
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
    
    private byte[] intsToBytes(final int[] array) {
        final byte[] array2 = new byte[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = (byte)array[i];
        }
        return array2;
    }
    
    @Override
    public byte[] ft_control(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) throws Bt4Exception {
        if (n == 128 && n2 == 6 && n3 == 256 && n4 == 0) {
            return this.intsToBytes(new int[] { 18, 1, 16, 1, 0, 0, 0, 8, 110, 9, 35, 6, 16, 1, 1, 2, 0, 1 });
        }
        if (n == 128 && n2 == 6 && n3 == 512 && n4 == 0) {
            return this.intsToBytes(new int[] { 9, 2, 93, 0, 1, 1, 0, 128, 150, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 16, 1, 0, 7, 3, 0, 0, 0, 160, 15, 0, 0, 224, 46, 0, 0, 4, 0, 42, 0, 0, 44, 128, 10, 0, 46, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 186, 4, 4, 0, 15, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 3, 2, 64, 0, 0, 7, 5, 133, 2, 64, 0, 0 });
        }
        if (n == 128 && n2 == 6 && n3 == 769 && n4 == 1033) {
            return this.intsToBytes(new int[] { 6, 3, 70, 0, 84, 0 });
        }
        if (n != 128 || n2 != 6 || n3 != 770 || n4 != 1033) {
            return null;
        }
        if (this.mBluetoothDevice != null) {
            final char[] charArray = this.mBluetoothDevice.getName().toCharArray();
            final int[] array = new int[charArray.length * 2 + 2];
            array[0] = array.length;
            array[1] = 3;
            for (int i = 0; i < charArray.length; ++i) {
                array[2 + i * 2] = charArray[i];
                array[2 + i * 2 + 1] = 0;
            }
            return this.intsToBytes(array);
        }
        return this.intsToBytes(new int[] { 28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 52, 0, 46, 0, 48, 0 });
    }
    
    @Override
    public void ft_send(final int n, final byte[] array, final int n2) throws Bt4Exception {
        try {
            this.pipeIn = new PipedInputStream();
            this.pipeOut = new PipedOutputStream();
            try {
                this.pipeIn.connect(this.pipeOut);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            this.showLog("SSSSSSSSend:" + Utility.bytes2HexStr(array));
            int i = array.length;
            int n3 = 0;
            while (i > 0) {
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                }
                if (i > 20) {
                    final byte[] array2 = new byte[20];
                    System.arraycopy(array, n3, array2, 0, 20);
                    i -= 20;
                    n3 += 20;
                    if (!this.mBluetoothLeClass.writeCharacteristic(array2)) {
                        this.isRecvApdu = false;
                        throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
                    }
                    continue;
                }
                else {
                    final byte[] array3 = new byte[i];
                    System.arraycopy(array, n3, array3, 0, i);
                    if (this.mBluetoothLeClass.writeCharacteristic(array3)) {
                        break;
                    }
                    this.isRecvApdu = false;
                    throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
                }
            }
        }
        catch (Exception ex3) {
            throw new Bt4Exception(ex3.getMessage());
        }
    }
    
    @Override
    public byte[] ft_recv(final int n, final int i) throws Bt4Exception {
        this.showLog("timeout:" + i);
        return this.BlueToothRead(i);
    }
    
    private byte[] BlueToothRead(final int n) throws Bt4Exception {
        try {
            final byte[] array = new byte[4096];
            this.isRecvApdu = true;
            do {
                this.getPipeByte(array, 0, 1, n);
            } while ((array[0] & 0x80) != 0x80);
            this.getPipeByte(array, 1, 9, n);
            final int n2 = (array[1] & 0xFF) + ((array[2] & 0xFF) << 8) + ((array[3] & 0xFF) << 16) + ((array[4] & 0xFF) << 24) + 10;
            if (n2 > 10) {
                this.getPipeByte(array, 10, n2 - 10, n);
            }
            final byte[] array2 = new byte[n2];
            System.arraycopy(array, 0, array2, 0, n2);
            this.isRecvApdu = false;
            return array2;
        }
        catch (Exception ex) {
            throw new Bt4Exception("BlueToothRead:" + ex.getMessage());
        }
    }
    
    private void getPipeByte(final byte[] array, final int n, final int len, final int n2) throws Exception {
        try {
            while (this.pipeIn.available() < len) {
                this.isDataComing = false;
                if (!this.waitForDataComing(n2)) {
                    throw new Exception("getPipeByte timeout");
                }
            }
            final byte[] b = new byte[len];
            this.pipeIn.read(b, 0, len);
            System.arraycopy(b, 0, array, n, len);
        }
        catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    synchronized boolean waitForDataComing(long n) {
        if (!this.isDataComing) {
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                try {
                    this.wait(n);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (this.isDataComing) {
                    break;
                }
                final long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - currentTimeMillis >= n) {
                    return false;
                }
                n -= currentTimeMillis2 - currentTimeMillis;
                currentTimeMillis = currentTimeMillis2;
            }
        }
        return true;
    }
    
    synchronized void notifyDataComing() {
        this.isDataComing = true;
        this.notify();
    }
    
    private void mHandlerSendMessage(final int n, final Object o) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(n, o));
        }
    }
    
    private void showLog(final String str) {
        this.mHandlerSendMessage(128, "[LOG]" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + "--->" + str);
    }
}
