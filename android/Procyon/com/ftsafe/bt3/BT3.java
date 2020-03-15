// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.bt3;

import java.util.UUID;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import com.ftsafe.Utility;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.BroadcastReceiver;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import android.os.Handler;
import android.content.Context;
import com.ftsafe.readerScheme.FTReaderInf;

public class BT3 implements FTReaderInf
{
    private Context tContext;
    private Handler mHandler;
    ArrayList<BluetoothDevice> arrayForBlueToothDevice;
    BluetoothAdapter mBlueToothAdapter;
    BluetoothDevice mBluetoothDevice;
    BluetoothSocket mBlueToothSocket;
    PipedInputStream pipeIn;
    PipedOutputStream pipeOut;
    byte[] readData;
    BroadcastReceiver mBt3Receiver;
    private boolean isRecvApdu;
    private boolean isDataComing;
    
    public BT3(final Context tContext, final Handler mHandler) throws Bt3Exception {
        this.mHandler = null;
        this.arrayForBlueToothDevice = new ArrayList<BluetoothDevice>();
        this.mBlueToothAdapter = null;
        this.mBluetoothDevice = null;
        this.mBlueToothSocket = null;
        this.pipeIn = new PipedInputStream();
        this.pipeOut = new PipedOutputStream();
        this.readData = null;
        this.mBt3Receiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                if ("android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
                    final BluetoothDevice bluetoothDevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (!BT3.this.arrayForBlueToothDevice.contains(bluetoothDevice) && bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("FT_")) {
                        BT3.this.arrayForBlueToothDevice.add(bluetoothDevice);
                        BT3.this.mHandlerSendMessage(113, bluetoothDevice);
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
            throw new Bt3Exception("BluetoothAdapter.getDefaultAdapter() == null");
        }
        this.tContext.registerReceiver(this.mBt3Receiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (BT3.this.mBluetoothDevice != null && BT3.this.mBlueToothSocket != null && BT3.this.mBlueToothSocket.isConnected()) {
                            final byte[] array = new byte[1024];
                            if (BT3.this.mBlueToothSocket.getInputStream().available() == 0) {
                                Thread.sleep(100L);
                            }
                            else {
                                final int read = BT3.this.mBlueToothSocket.getInputStream().read(array);
                                if (array[0] == 80 && array[1] == 2 && read == 2) {
                                    BT3.this.mHandlerSendMessage(512, "");
                                }
                                else if (array[0] == 80 && array[1] == 3 && read == 2) {
                                    BT3.this.mHandlerSendMessage(256, "");
                                }
                                else if (BT3.this.isRecvApdu) {
                                    BT3.this.pipeOut.write(array, 0, read);
                                    BT3.this.notifyDataComing();
                                }
                                else {
                                    BT3.this.showLog("dirty data:" + Utility.bytes2HexStr(array, read));
                                }
                            }
                        }
                        else {
                            Thread.sleep(1000L);
                        }
                    }
                }
                catch (Exception ex) {}
            }
        }).start();
        try {
            this.pipeIn.connect(this.pipeOut);
        }
        catch (IOException ex) {
            throw new Bt3Exception(ex.getMessage());
        }
    }
    
    @Override
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
            final Set bondedDevices = this.mBlueToothAdapter.getBondedDevices();
            if (bondedDevices.size() > 0) {
                for (final BluetoothDevice bluetoothDevice : bondedDevices) {
                    if (!this.arrayForBlueToothDevice.contains(bluetoothDevice) && bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("FT_")) {
                        this.arrayForBlueToothDevice.add(bluetoothDevice);
                        this.mHandlerSendMessage(113, bluetoothDevice);
                    }
                }
            }
            if (!this.mBlueToothAdapter.isDiscovering()) {
                this.mBlueToothAdapter.startDiscovery();
            }
            return;
        }
        this.arrayForBlueToothDevice.clear();
        throw new Bt3Exception("mBlueToothAdapter == null");
    }
    
    @Override
    public void ft_open(final Object o) throws Bt3Exception {
        if (o == null) {
            throw new Bt3Exception("device == null");
        }
        this.mBlueToothAdapter.cancelDiscovery();
        try {
            if (this.mBlueToothSocket != null && this.mBlueToothSocket.isConnected() && this.mBluetoothDevice.getAddress().equals(((BluetoothDevice)o).getAddress())) {
                this.showLog("donaaaaaaaaaaaaaaaaaaaaaa");
                return;
            }
            this.mBluetoothDevice = (BluetoothDevice)o;
            if (this.mBlueToothSocket != null) {
                this.mBlueToothSocket.close();
            }
            (this.mBlueToothSocket = this.mBluetoothDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))).connect();
        }
        catch (Exception ex) {
            throw new Bt3Exception(ex.getMessage());
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
            catch (IOException ex) {
                this.showLog("ft_close::mBlueToothSocket.close()::do-nothing::" + ex.getMessage());
            }
            this.mBlueToothSocket = null;
        }
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
    public byte[] ft_control(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) throws Bt3Exception {
        if (n == 128 && n2 == 6 && n3 == 256 && n4 == 0) {
            return this.intsToBytes(new int[] { 18, 1, 16, 1, 0, 0, 0, 32, 110, 9, 26, 6, 69, 1, 1, 2, 0, 1 });
        }
        if (n == 128 && n2 == 6 && n3 == 512 && n4 == 0) {
            return this.intsToBytes(new int[] { 9, 2, 93, 0, 1, 1, 0, 128, 128, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 0, 1, 0, 7, 3, 0, 0, 0, 116, 14, 0, 0, 116, 14, 0, 0, 0, 218, 38, 0, 0, 72, 219, 4, 0, 53, 16, 1, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 190, 4, 4, 0, 16, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 1, 2, 32, 0, 0, 7, 5, 129, 2, 32, 0, 0 });
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
        return this.intsToBytes(new int[] { 28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 51, 0, 46, 0, 48, 0 });
    }
    
    @Override
    public void ft_send(final int n, final byte[] b, final int n2) throws Bt3Exception {
        try {
            this.pipeIn = new PipedInputStream();
            this.pipeOut = new PipedOutputStream();
            try {
                this.pipeIn.connect(this.pipeOut);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            this.mBlueToothSocket.getOutputStream().write(b);
            this.mBlueToothSocket.getOutputStream().flush();
        }
        catch (Exception ex2) {
            throw new Bt3Exception("bt3:ft_send:" + ex2.getMessage());
        }
    }
    
    @Override
    public byte[] ft_recv(final int n, final int n2) throws Bt3Exception {
        return this.BlueToothRead(n2);
    }
    
    private byte[] BlueToothRead(final int n) throws Bt3Exception {
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
            throw new Bt3Exception("BlueToothRead:" + ex.getMessage());
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
        this.mHandlerSendMessage(112, "[LOG]" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + "--->" + str);
    }
}
