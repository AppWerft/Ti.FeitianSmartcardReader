// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.usb;

import com.ftsafe.Utility;
import android.hardware.usb.UsbEndpoint;
import java.util.Iterator;
import java.util.HashMap;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.content.Context;
import com.ftsafe.readerScheme.FTReaderInf;

public class USB implements FTReaderInf
{
    private Context tContext;
    private UsbManager mUsbManager;
    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    private final int VendorID = 2414;
    public UsbDevice mUsbDevice;
    public UsbDeviceConnection mUsbDeviceConnection;
    private UsbInterface[] mUsbInterfaceArray;
    private Handler mHandler;
    private final BroadcastReceiver mUsbReceiver;
    
    public USB(final Context tContext, final Handler mHandler) throws UsbException {
        this.mUsbDevice = null;
        this.mUsbDeviceConnection = null;
        this.mUsbInterfaceArray = new UsbInterface[16];
        this.mHandler = null;
        this.mUsbReceiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                final String action = intent.getAction();
                USB.this.showLog(action);
                if ("com.android.example.USB_PERMISSION".equals(action)) {
                    synchronized (this) {
                        final UsbDevice mUsbDevice = (UsbDevice)intent.getParcelableExtra("device");
                        if (intent.getBooleanExtra("permission", false)) {
                            if (mUsbDevice != null) {
                                USB.this.showLog("usb device is null");
                                USB.this.mUsbDevice = mUsbDevice;
                            }
                        }
                        else {
                            USB.this.showLog("permission denied for device");
                        }
                    }
                }
                else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    USB.this.showLog("USB DEVICE ATTACHED");
                    USB.this.mHandlerSendMessage(17, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
                }
                else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    USB.this.showLog("USB DEVICE DETACHED");
                    USB.this.mHandlerSendMessage(18, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
                    USB.this.ft_close();
                }
            }
        };
        this.tContext = tContext;
        this.mHandler = mHandler;
        this.mUsbManager = (UsbManager)this.tContext.getSystemService("usb");
        if (this.mUsbManager == null) {
            throw new UsbException("create mUsbManager failed!");
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.example.USB_PERMISSION");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this.tContext.registerReceiver(this.mUsbReceiver, intentFilter);
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.tContext.unregisterReceiver(this.mUsbReceiver);
        super.finalize();
    }
    
    @Override
    public Boolean isFtExist() {
        if (this.mUsbDeviceConnection == null) {
            return false;
        }
        return true;
    }
    
    @Override
    public void ft_find() throws UsbException {
        final HashMap deviceList = this.mUsbManager.getDeviceList();
        if (deviceList.isEmpty()) {
            throw new UsbException("Device Not Found");
        }
        final PendingIntent broadcast = PendingIntent.getBroadcast(this.tContext.getApplicationContext(), 0, new Intent("com.android.example.USB_PERMISSION"), 0);
        for (final UsbDevice mUsbDevice : deviceList.values()) {
            if (mUsbDevice.getVendorId() == 2414) {
                if (this.mUsbManager.hasPermission(mUsbDevice)) {
                    this.mUsbDevice = mUsbDevice;
                }
                else {
                    this.mUsbManager.requestPermission(mUsbDevice, broadcast);
                }
                return;
            }
        }
        throw new UsbException("Device Not Found");
    }
    
    @Override
    public void ft_open(final Object o) throws UsbException {
        if (o != null) {
            this.mUsbDevice = (UsbDevice)o;
        }
        if (this.mUsbDevice == null) {
            throw new UsbException("No USB FIND !!!");
        }
        if (this.mUsbDeviceConnection != null) {
            this.mUsbDeviceConnection.close();
        }
        this.mUsbDeviceConnection = this.mUsbManager.openDevice(this.mUsbDevice);
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("Device Open Failed");
        }
        for (int interfaceCount = this.mUsbDevice.getInterfaceCount(), i = 0; i < interfaceCount; ++i) {
            this.mUsbInterfaceArray[i] = this.mUsbDevice.getInterface(i);
            this.mUsbDeviceConnection.claimInterface(this.mUsbInterfaceArray[i], true);
        }
    }
    
    @Override
    public void ft_close() {
        if (this.mUsbDevice == null) {
            return;
        }
        if (this.mUsbDeviceConnection != null) {
            for (int interfaceCount = this.mUsbDevice.getInterfaceCount(), i = 0; i < interfaceCount; ++i) {
                this.mUsbDeviceConnection.releaseInterface(this.mUsbInterfaceArray[i]);
            }
            this.mUsbDeviceConnection.close();
            this.mUsbDeviceConnection = null;
        }
        this.mUsbDevice = null;
    }
    
    @Override
    public byte[] ft_control(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) throws UsbException {
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        final byte[] array = new byte[n5];
        final int controlTransfer = this.mUsbDeviceConnection.controlTransfer(n, n2, n3, n4, array, n5, n6);
        if (controlTransfer <= 0) {
            throw new UsbException("mUsbDeviceConnection.controlTransfer error");
        }
        final byte[] array2 = new byte[controlTransfer];
        System.arraycopy(array, 0, array2, 0, controlTransfer);
        return array2;
    }
    
    @Override
    public void ft_send(final int i, final byte[] array, final int n) throws UsbException {
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        UsbEndpoint endpoint = null;
        for (int j = 0; j < this.mUsbInterfaceArray.length; ++j) {
            if (this.mUsbInterfaceArray[j] != null) {
                for (int k = 0; k < this.mUsbInterfaceArray[j].getEndpointCount(); ++k) {
                    if (this.mUsbInterfaceArray[j].getEndpoint(k).getAddress() == i) {
                        endpoint = this.mUsbInterfaceArray[j].getEndpoint(k);
                        break;
                    }
                }
                if (endpoint != null) {
                    break;
                }
            }
        }
        if (endpoint == null) {
            throw new UsbException("usb_send endpoint error:" + i);
        }
        final int bulkTransfer = this.mUsbDeviceConnection.bulkTransfer(endpoint, array, array.length, n);
        if (bulkTransfer < 0) {
            throw new UsbException("usb_send error:" + bulkTransfer);
        }
    }
    
    @Override
    public byte[] ft_recv(final int n, final int n2) throws UsbException {
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        UsbEndpoint endpoint = null;
        for (int i = 0; i < this.mUsbInterfaceArray.length; ++i) {
            if (this.mUsbInterfaceArray[i] != null) {
                for (int j = 0; j < this.mUsbInterfaceArray[i].getEndpointCount(); ++j) {
                    if (this.mUsbInterfaceArray[i].getEndpoint(j).getAddress() == n) {
                        endpoint = this.mUsbInterfaceArray[i].getEndpoint(j);
                        break;
                    }
                }
                if (endpoint != null) {
                    break;
                }
            }
        }
        final byte[] array = new byte[1024];
        final int bulkTransfer = this.mUsbDeviceConnection.bulkTransfer(endpoint, array, array.length, n2);
        if (bulkTransfer < 0) {
            throw new UsbException("usb_recv error len:" + bulkTransfer);
        }
        final byte[] array2 = new byte[bulkTransfer];
        System.arraycopy(array, 0, array2, 0, bulkTransfer);
        this.showLog(Utility.bytes2HexStr(array2));
        return array2;
    }
    
    private void mHandlerSendMessage(final int n, final Object o) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(n, o));
        }
    }
    
    private void showLog(final String str) {
        this.mHandlerSendMessage(16, "[LOG]" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getMethodName() + "--->" + str);
    }
}
