/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.hardware.usb.UsbDevice
 *  android.hardware.usb.UsbDeviceConnection
 *  android.hardware.usb.UsbEndpoint
 *  android.hardware.usb.UsbInterface
 *  android.hardware.usb.UsbManager
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Parcelable
 */
package com.ftsafe.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTReaderInf;
import com.ftsafe.usb.UsbException;
import java.util.Collection;
import java.util.HashMap;

public class USB
implements FTReaderInf {
    private Context tContext;
    private UsbManager mUsbManager;
    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    private final int VendorID = 2414;
    public UsbDevice mUsbDevice = null;
    public UsbDeviceConnection mUsbDeviceConnection = null;
    private UsbInterface[] mUsbInterfaceArray = new UsbInterface[16];
    private Handler mHandler = null;
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onReceive(Context context, Intent intent) {
            String string = intent.getAction();
            USB.this.showLog(string);
            if (USB.ACTION_USB_PERMISSION.equals(string)) {
                1 var4_4 = this;
                synchronized (var4_4) {
                    UsbDevice usbDevice = (UsbDevice)intent.getParcelableExtra("device");
                    if (intent.getBooleanExtra("permission", false)) {
                        if (usbDevice != null) {
                            USB.this.showLog("usb device is null");
                            USB.this.mUsbDevice = usbDevice;
                        }
                    } else {
                        USB.this.showLog("permission denied for device");
                    }
                }
            } else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(string)) {
                USB.this.showLog("USB DEVICE ATTACHED");
                USB.this.mHandlerSendMessage(17, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(string)) {
                USB.this.showLog("USB DEVICE DETACHED");
                USB.this.mHandlerSendMessage(18, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
                USB.this.ft_close();
            }
        }
    };

    public USB(Context context, Handler handler) throws UsbException {
        this.tContext = context;
        this.mHandler = handler;
        this.mUsbManager = (UsbManager)this.tContext.getSystemService("usb");
        if (this.mUsbManager == null) {
            throw new UsbException("create mUsbManager failed!");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_USB_PERMISSION);
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this.tContext.registerReceiver(this.mUsbReceiver, intentFilter);
    }

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
        HashMap hashMap = this.mUsbManager.getDeviceList();
        if (hashMap.isEmpty()) {
            throw new UsbException("Device Not Found");
        }
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this.tContext.getApplicationContext(), (int)0, (Intent)new Intent(ACTION_USB_PERMISSION), (int)0);
        for (UsbDevice usbDevice : hashMap.values()) {
            if (usbDevice.getVendorId() != 2414) continue;
            if (this.mUsbManager.hasPermission(usbDevice)) {
                this.mUsbDevice = usbDevice;
            } else {
                this.mUsbManager.requestPermission(usbDevice, pendingIntent);
            }
            return;
        }
        throw new UsbException("Device Not Found");
    }

    @Override
    public void ft_open(Object object2) throws UsbException {
        if (object2 != null) {
            this.mUsbDevice = (UsbDevice)object2;
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
        int n = this.mUsbDevice.getInterfaceCount();
        for (int i = 0; i < n; ++i) {
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
            int n = this.mUsbDevice.getInterfaceCount();
            for (int i = 0; i < n; ++i) {
                this.mUsbDeviceConnection.releaseInterface(this.mUsbInterfaceArray[i]);
            }
            this.mUsbDeviceConnection.close();
            this.mUsbDeviceConnection = null;
        }
        this.mUsbDevice = null;
    }

    @Override
    public byte[] ft_control(int n, int n2, int n3, int n4, int n5, int n6) throws UsbException {
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        byte[] arrby = new byte[n5];
        int n7 = this.mUsbDeviceConnection.controlTransfer(n, n2, n3, n4, arrby, n5, n6);
        if (n7 <= 0) {
            throw new UsbException("mUsbDeviceConnection.controlTransfer error");
        }
        byte[] arrby2 = new byte[n7];
        System.arraycopy(arrby, 0, arrby2, 0, n7);
        return arrby2;
    }

    @Override
    public void ft_send(int n, byte[] arrby, int n2) throws UsbException {
        int n3;
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        UsbEndpoint usbEndpoint = null;
        for (n3 = 0; n3 < this.mUsbInterfaceArray.length; ++n3) {
            if (this.mUsbInterfaceArray[n3] == null) continue;
            for (int i = 0; i < this.mUsbInterfaceArray[n3].getEndpointCount(); ++i) {
                if (this.mUsbInterfaceArray[n3].getEndpoint(i).getAddress() != n) continue;
                usbEndpoint = this.mUsbInterfaceArray[n3].getEndpoint(i);
                break;
            }
            if (usbEndpoint != null) break;
        }
        if (usbEndpoint == null) {
            throw new UsbException("usb_send endpoint error:" + n);
        }
        n3 = this.mUsbDeviceConnection.bulkTransfer(usbEndpoint, arrby, arrby.length, n2);
        if (n3 < 0) {
            throw new UsbException("usb_send error:" + n3);
        }
    }

    @Override
    public byte[] ft_recv(int n, int n2) throws UsbException {
        int n3;
        if (this.mUsbDeviceConnection == null) {
            throw new UsbException("No Device Found");
        }
        UsbEndpoint usbEndpoint = null;
        for (int i = 0; i < this.mUsbInterfaceArray.length; ++i) {
            if (this.mUsbInterfaceArray[i] == null) continue;
            for (n3 = 0; n3 < this.mUsbInterfaceArray[i].getEndpointCount(); ++n3) {
                if (this.mUsbInterfaceArray[i].getEndpoint(n3).getAddress() != n) continue;
                usbEndpoint = this.mUsbInterfaceArray[i].getEndpoint(n3);
                break;
            }
            if (usbEndpoint != null) break;
        }
        byte[] arrby = new byte[1024];
        n3 = 0;
        n3 = this.mUsbDeviceConnection.bulkTransfer(usbEndpoint, arrby, arrby.length, n2);
        if (n3 < 0) {
            throw new UsbException("usb_recv error len:" + n3);
        }
        byte[] arrby2 = new byte[n3];
        System.arraycopy(arrby, 0, arrby2, 0, n3);
        this.showLog(Utility.bytes2HexStr(arrby2));
        return arrby2;
    }

    private void mHandlerSendMessage(int n, Object object2) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(n, object2));
        }
    }

    private void showLog(String string) {
        String string2 = Thread.currentThread().getStackTrace()[3].getClassName();
        String string3 = Thread.currentThread().getStackTrace()[3].getMethodName();
        this.mHandlerSendMessage(16, "[LOG]" + string2 + ":" + string3 + "--->" + string);
    }

}

