// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.bt4;

import java.util.List;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import java.util.UUID;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;

public class BluetoothLeClass
{
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private boolean isDiscovering;
    public static final UUID UUID_SERVICE_C4;
    public static final UUID UUID_CHAR_WRITE_C4;
    public static final UUID UUID_CHAR_NOTIF_C4;
    public static final UUID UUID_SERVICE_C6;
    public static final UUID UUID_CHAR_WRITE_C6;
    public static final UUID UUID_CHAR_NOTIF_C6;
    public static final UUID UUID_DESC_NOTIF;
    private OnConnectListener mOnConnectListener;
    private OnDisconnectListener mOnDisconnectListener;
    private OnServiceDiscoverListener mOnServiceDiscoverListener;
    private OnDataAvailableListener mOnDataAvailableListener;
    private Context mContext;
    private final BluetoothGattCallback mGattCallback;
    
    public void setOnConnectListener(final OnConnectListener mOnConnectListener) {
        this.mOnConnectListener = mOnConnectListener;
    }
    
    public void setOnDisconnectListener(final OnDisconnectListener mOnDisconnectListener) {
        this.mOnDisconnectListener = mOnDisconnectListener;
    }
    
    public void setOnServiceDiscoverListener(final OnServiceDiscoverListener mOnServiceDiscoverListener) {
        this.mOnServiceDiscoverListener = mOnServiceDiscoverListener;
    }
    
    public void setOnDataAvailableListener(final OnDataAvailableListener mOnDataAvailableListener) {
        this.mOnDataAvailableListener = mOnDataAvailableListener;
    }
    
    public BluetoothLeClass(final Context mContext) {
        this.isDiscovering = false;
        this.mGattCallback = new BluetoothGattCallback() {
            public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int n, final int n2) {
                if (n2 == 2) {
                    if (BluetoothLeClass.this.mOnConnectListener != null) {
                        BluetoothLeClass.this.mOnConnectListener.onConnect(bluetoothGatt);
                    }
                    if (BluetoothLeClass.this.mBluetoothGatt.discoverServices()) {}
                }
                else if (n2 == 0 && BluetoothLeClass.this.mOnDisconnectListener != null) {
                    BluetoothLeClass.this.mOnDisconnectListener.onDisconnect(bluetoothGatt);
                }
            }
            
            public void onServicesDiscovered(final BluetoothGatt bluetoothGatt, final int n) {
                BluetoothLeClass.this.notifyDiscovered();
                if (n == 0 && BluetoothLeClass.this.mOnServiceDiscoverListener != null) {
                    BluetoothLeClass.this.mOnServiceDiscoverListener.onServiceDiscover(bluetoothGatt);
                    if (BluetoothLeClass.this.setCharacteristicNotification(true)) {}
                }
                if (BluetoothLeClass.this.setCharacteristicNotification(true)) {}
            }
            
            public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int n) {
                if (BluetoothLeClass.this.mOnDataAvailableListener != null) {
                    BluetoothLeClass.this.mOnDataAvailableListener.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, n);
                }
            }
            
            public void onCharacteristicChanged(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                if (BluetoothLeClass.this.mOnDataAvailableListener != null) {
                    BluetoothLeClass.this.mOnDataAvailableListener.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
                final byte[] value = bluetoothGattCharacteristic.getValue();
                if (value != null && value.length > 0) {
                    final StringBuilder sb = new StringBuilder(value.length);
                    final byte[] array = value;
                    for (int length = array.length, i = 0; i < length; ++i) {
                        sb.append(String.format("%02X ", array[i]));
                    }
                }
            }
        };
        this.mContext = mContext;
    }
    
    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            this.mBluetoothManager = (BluetoothManager)this.mContext.getSystemService("bluetooth");
            if (this.mBluetoothManager == null) {
                return false;
            }
        }
        this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
        return this.mBluetoothAdapter != null;
    }
    
    public boolean connect(final String s) {
        if (this.mBluetoothAdapter == null || s == null) {
            return false;
        }
        if (this.mBluetoothDeviceAddress != null && s.equals(this.mBluetoothDeviceAddress) && this.mBluetoothGatt != null) {
            this.isDiscovering = true;
            if (!this.mBluetoothGatt.connect()) {
                return false;
            }
            if (!this.waitForDiscovering(6000L)) {
                this.disconnect();
                return false;
            }
            return true;
        }
        else {
            final BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(s);
            if (remoteDevice == null) {
                return false;
            }
            this.isDiscovering = true;
            this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mGattCallback);
            if (!this.mBluetoothGatt.connect()) {
                this.mBluetoothDeviceAddress = s;
                return false;
            }
            if (!this.waitForDiscovering(6000L)) {
                this.disconnect();
                this.mBluetoothGatt = null;
                return false;
            }
            this.mBluetoothDeviceAddress = s;
            return true;
        }
    }
    
    public void disconnect() {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.disconnect();
    }
    
    public void close() {
        if (this.mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.close();
        this.mBluetoothGatt = null;
    }
    
    public void readCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }
    
    public boolean setCharacteristicNotification(final boolean b) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.mBluetoothGatt.getService(BluetoothLeClass.UUID_SERVICE_C4);
        if (bluetoothGattService == null) {
            bluetoothGattService = this.mBluetoothGatt.getService(BluetoothLeClass.UUID_SERVICE_C6);
            if (bluetoothGattService == null) {
                return false;
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BluetoothLeClass.UUID_CHAR_NOTIF_C4);
        if (bluetoothGattCharacteristic == null) {
            bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BluetoothLeClass.UUID_CHAR_NOTIF_C6);
            if (bluetoothGattCharacteristic == null) {
                return false;
            }
        }
        if (!this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, b)) {
            return false;
        }
        final BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(BluetoothLeClass.UUID_DESC_NOTIF);
        return descriptor != null && descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) && this.mBluetoothGatt.writeDescriptor(descriptor);
    }
    
    public void writeCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }
    
    public List<BluetoothGattService> getSupportedGattServices() {
        if (this.mBluetoothGatt == null) {
            return null;
        }
        return (List<BluetoothGattService>)this.mBluetoothGatt.getServices();
    }
    
    public BluetoothGatt getBluetoothGatt() {
        return this.mBluetoothGatt;
    }
    
    public boolean writeCharacteristic(final byte[] value) {
        final List services = this.mBluetoothGatt.getServices();
        if (services == null || services.size() == 0) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.mBluetoothGatt.getService(BluetoothLeClass.UUID_SERVICE_C4);
        if (bluetoothGattService == null) {
            bluetoothGattService = this.mBluetoothGatt.getService(BluetoothLeClass.UUID_SERVICE_C6);
            if (bluetoothGattService == null) {
                return false;
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BluetoothLeClass.UUID_CHAR_WRITE_C4);
        if (bluetoothGattCharacteristic == null) {
            bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BluetoothLeClass.UUID_CHAR_WRITE_C6);
            if (bluetoothGattCharacteristic == null) {
                return false;
            }
        }
        return bluetoothGattCharacteristic.setValue(value) && this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }
    
    synchronized boolean waitForDiscovering(long n) {
        if (this.isDiscovering) {
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                try {
                    this.wait(n);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (!this.isDiscovering) {
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
    
    synchronized void notifyDiscovered() {
        this.isDiscovering = false;
        this.notify();
    }
    
    static {
        UUID_SERVICE_C4 = UUID.fromString("46540001-0002-00c4-0000-465453414645");
        UUID_CHAR_WRITE_C4 = UUID.fromString("46540002-0002-00c4-0000-465453414645");
        UUID_CHAR_NOTIF_C4 = UUID.fromString("46540003-0002-00c4-0000-465453414645");
        UUID_SERVICE_C6 = UUID.fromString("46540001-0002-00c6-0000-465453414645");
        UUID_CHAR_WRITE_C6 = UUID.fromString("46540002-0002-00c6-0000-465453414645");
        UUID_CHAR_NOTIF_C6 = UUID.fromString("46540003-0002-00c6-0000-465453414645");
        UUID_DESC_NOTIF = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }
    
    public interface OnDataAvailableListener
    {
        void onCharacteristicRead(final BluetoothGatt p0, final BluetoothGattCharacteristic p1, final int p2);
        
        void onCharacteristicChanged(final BluetoothGatt p0, final BluetoothGattCharacteristic p1);
    }
    
    public interface OnServiceDiscoverListener
    {
        void onServiceDiscover(final BluetoothGatt p0);
    }
    
    public interface OnDisconnectListener
    {
        void onDisconnect(final BluetoothGatt p0);
    }
    
    public interface OnConnectListener
    {
        void onConnect(final BluetoothGatt p0);
    }
}
