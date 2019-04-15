/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 *  android.bluetooth.BluetoothGattService
 *  android.bluetooth.BluetoothManager
 *  android.content.Context
 */
package com.ftsafe.bt4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import java.util.List;
import java.util.UUID;

public class BluetoothLeClass {
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private boolean isDiscovering = false;
    public static final UUID UUID_SERVICE_C4 = UUID.fromString("46540001-0002-00c4-0000-465453414645");
    public static final UUID UUID_CHAR_WRITE_C4 = UUID.fromString("46540002-0002-00c4-0000-465453414645");
    public static final UUID UUID_CHAR_NOTIF_C4 = UUID.fromString("46540003-0002-00c4-0000-465453414645");
    public static final UUID UUID_SERVICE_C6 = UUID.fromString("46540001-0002-00c6-0000-465453414645");
    public static final UUID UUID_CHAR_WRITE_C6 = UUID.fromString("46540002-0002-00c6-0000-465453414645");
    public static final UUID UUID_CHAR_NOTIF_C6 = UUID.fromString("46540003-0002-00c6-0000-465453414645");
    public static final UUID UUID_DESC_NOTIF = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private OnConnectListener mOnConnectListener;
    private OnDisconnectListener mOnDisconnectListener;
    private OnServiceDiscoverListener mOnServiceDiscoverListener;
    private OnDataAvailableListener mOnDataAvailableListener;
    private Context mContext;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int n, int n2) {
            if (n2 == 2) {
                boolean bl;
                if (BluetoothLeClass.this.mOnConnectListener != null) {
                    BluetoothLeClass.this.mOnConnectListener.onConnect(bluetoothGatt);
                }
                if (!(bl = BluetoothLeClass.this.mBluetoothGatt.discoverServices())) return;
            }
            if (n2 != 0 || BluetoothLeClass.this.mOnDisconnectListener == null) return;
            BluetoothLeClass.this.mOnDisconnectListener.onDisconnect(bluetoothGatt);
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int n) {
            boolean bl;
            BluetoothLeClass.this.notifyDiscovered();
            if (n == 0 && BluetoothLeClass.this.mOnServiceDiscoverListener != null) {
                BluetoothLeClass.this.mOnServiceDiscoverListener.onServiceDiscover(bluetoothGatt);
                bl = BluetoothLeClass.this.setCharacteristicNotification(true);
                if (bl) {
                    // empty if block
                }
            }
            if (bl = BluetoothLeClass.this.setCharacteristicNotification(true)) {
                // empty if block
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n) {
            if (BluetoothLeClass.this.mOnDataAvailableListener != null) {
                BluetoothLeClass.this.mOnDataAvailableListener.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, n);
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] arrby;
            if (BluetoothLeClass.this.mOnDataAvailableListener != null) {
                BluetoothLeClass.this.mOnDataAvailableListener.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
            if ((arrby = bluetoothGattCharacteristic.getValue()) != null && arrby.length > 0) {
                StringBuilder stringBuilder = new StringBuilder(arrby.length);
                for (byte by : arrby) {
                    stringBuilder.append(String.format("%02X ", by));
                }
            }
        }
    };

    public void setOnConnectListener(OnConnectListener onConnectListener) {
        this.mOnConnectListener = onConnectListener;
    }

    public void setOnDisconnectListener(OnDisconnectListener onDisconnectListener) {
        this.mOnDisconnectListener = onDisconnectListener;
    }

    public void setOnServiceDiscoverListener(OnServiceDiscoverListener onServiceDiscoverListener) {
        this.mOnServiceDiscoverListener = onServiceDiscoverListener;
    }

    public void setOnDataAvailableListener(OnDataAvailableListener onDataAvailableListener) {
        this.mOnDataAvailableListener = onDataAvailableListener;
    }

    public BluetoothLeClass(Context context) {
        this.mContext = context;
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

    public boolean connect(String string) {
        if (this.mBluetoothAdapter == null || string == null) {
            return false;
        }
        if (this.mBluetoothDeviceAddress != null && string.equals(this.mBluetoothDeviceAddress) && this.mBluetoothGatt != null) {
            this.isDiscovering = true;
            if (this.mBluetoothGatt.connect()) {
                boolean bl = this.waitForDiscovering(6000L);
                if (!bl) {
                    this.disconnect();
                    return false;
                }
                return true;
            }
            return false;
        }
        BluetoothDevice bluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(string);
        if (bluetoothDevice == null) {
            return false;
        }
        this.isDiscovering = true;
        this.mBluetoothGatt = bluetoothDevice.connectGatt(this.mContext, false, this.mGattCallback);
        if (this.mBluetoothGatt.connect()) {
            boolean bl = this.waitForDiscovering(6000L);
            if (!bl) {
                this.disconnect();
                this.mBluetoothGatt = null;
                return false;
            }
            this.mBluetoothDeviceAddress = string;
            return true;
        }
        this.mBluetoothDeviceAddress = string;
        return false;
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

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public boolean setCharacteristicNotification(boolean bl) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGatt == null) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.mBluetoothGatt.getService(UUID_SERVICE_C4);
        if (bluetoothGattService == null && (bluetoothGattService = this.mBluetoothGatt.getService(UUID_SERVICE_C6)) == null) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(UUID_CHAR_NOTIF_C4);
        if (bluetoothGattCharacteristic == null && (bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(UUID_CHAR_NOTIF_C6)) == null) {
            return false;
        }
        boolean bl2 = this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, bl);
        if (!bl2) {
            return false;
        }
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(UUID_DESC_NOTIF);
        if (bluetoothGattDescriptor == null) {
            return false;
        }
        bl2 = bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        if (!bl2) {
            return false;
        }
        bl2 = this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        return bl2;
    }

    public void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        if (this.mBluetoothGatt == null) {
            return null;
        }
        return this.mBluetoothGatt.getServices();
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public boolean writeCharacteristic(byte[] arrby) {
        List list = this.mBluetoothGatt.getServices();
        if (list == null || list.size() == 0) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.mBluetoothGatt.getService(UUID_SERVICE_C4);
        if (bluetoothGattService == null && (bluetoothGattService = this.mBluetoothGatt.getService(UUID_SERVICE_C6)) == null) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(UUID_CHAR_WRITE_C4);
        if (bluetoothGattCharacteristic == null && (bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(UUID_CHAR_WRITE_C6)) == null) {
            return false;
        }
        boolean bl = bluetoothGattCharacteristic.setValue(arrby);
        if (!bl) {
            return false;
        }
        bl = this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        return bl;
    }

    synchronized boolean waitForDiscovering(long l) {
        if (this.isDiscovering) {
            long l2 = System.currentTimeMillis();
            do {
                try {
                    this.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if (!this.isDiscovering) break;
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

    synchronized void notifyDiscovered() {
        this.isDiscovering = false;
        this.notify();
    }

    public static interface OnDataAvailableListener {
        public void onCharacteristicRead(BluetoothGatt var1, BluetoothGattCharacteristic var2, int var3);

        public void onCharacteristicChanged(BluetoothGatt var1, BluetoothGattCharacteristic var2);
    }

    public static interface OnServiceDiscoverListener {
        public void onServiceDiscover(BluetoothGatt var1);
    }

    public static interface OnDisconnectListener {
        public void onDisconnect(BluetoothGatt var1);
    }

    public static interface OnConnectListener {
        public void onConnect(BluetoothGatt var1);
    }

}

