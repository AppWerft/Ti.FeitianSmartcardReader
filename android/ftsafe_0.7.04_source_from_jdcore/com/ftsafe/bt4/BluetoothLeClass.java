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




















public class BluetoothLeClass
{
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
  


  public void setOnConnectListener(OnConnectListener paramOnConnectListener)
  {
    mOnConnectListener = paramOnConnectListener;
  }
  
  public void setOnDisconnectListener(OnDisconnectListener paramOnDisconnectListener) { mOnDisconnectListener = paramOnDisconnectListener; }
  
  public void setOnServiceDiscoverListener(OnServiceDiscoverListener paramOnServiceDiscoverListener) {
    mOnServiceDiscoverListener = paramOnServiceDiscoverListener;
  }
  
  public void setOnDataAvailableListener(OnDataAvailableListener paramOnDataAvailableListener) { mOnDataAvailableListener = paramOnDataAvailableListener; }
  
  public BluetoothLeClass(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback()
  {
    public void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2) {
      if (paramAnonymousInt2 == 2) {
        if (mOnConnectListener != null) {
          mOnConnectListener.onConnect(paramAnonymousBluetoothGatt);
        }
        boolean bool = mBluetoothGatt.discoverServices();
        if (!bool) {}







      }
      else if ((paramAnonymousInt2 == 0) && 
        (mOnDisconnectListener != null)) {
        mOnDisconnectListener.onDisconnect(paramAnonymousBluetoothGatt);
      }
    }
    

    public void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      notifyDiscovered();
      if ((paramAnonymousInt == 0) && (mOnServiceDiscoverListener != null)) {
        mOnServiceDiscoverListener.onServiceDiscover(paramAnonymousBluetoothGatt);
        bool = setCharacteristicNotification(true);
        if (!bool) {}
      }
      









      boolean bool = setCharacteristicNotification(true);
      if (bool) {}
    }
    










    public void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      if (mOnDataAvailableListener != null) {
        mOnDataAvailableListener.onCharacteristicRead(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattCharacteristic, paramAnonymousInt);
      }
    }
    
    public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      if (mOnDataAvailableListener != null)
        mOnDataAvailableListener.onCharacteristicChanged(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattCharacteristic);
      byte[] arrayOfByte1 = paramAnonymousBluetoothGattCharacteristic.getValue();
      if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0)) {
        StringBuilder localStringBuilder = new StringBuilder(arrayOfByte1.length);
        for (byte b : arrayOfByte1) {
          localStringBuilder.append(String.format("%02X ", new Object[] { Byte.valueOf(b) }));
        }
      }
    }
  };
  


  public boolean initialize()
  {
    if (mBluetoothManager == null) {
      mBluetoothManager = ((BluetoothManager)mContext.getSystemService("bluetooth"));
      if (mBluetoothManager == null)
      {
        return false;
      }
    }
    
    mBluetoothAdapter = mBluetoothManager.getAdapter();
    if (mBluetoothAdapter == null)
    {
      return false;
    }
    
    return true;
  }
  
  public boolean connect(String paramString) {
    if ((mBluetoothAdapter == null) || (paramString == null)) {
      return false;
    }
    
    if ((mBluetoothDeviceAddress != null) && (paramString.equals(mBluetoothDeviceAddress)) && (mBluetoothGatt != null))
    {
      isDiscovering = true;
      if (mBluetoothGatt.connect()) {
        boolean bool1 = waitForDiscovering(6000L);
        if (!bool1)
        {
          disconnect();
          return false;
        }
        return true;
      }
      return false;
    }
    

    BluetoothDevice localBluetoothDevice = mBluetoothAdapter.getRemoteDevice(paramString);
    if (localBluetoothDevice == null) {
      return false;
    }
    isDiscovering = true;
    mBluetoothGatt = localBluetoothDevice.connectGatt(mContext, false, mGattCallback);
    if (mBluetoothGatt.connect()) {
      boolean bool2 = waitForDiscovering(6000L);
      if (!bool2)
      {
        disconnect();
        mBluetoothGatt = null;
        return false;
      }
      mBluetoothDeviceAddress = paramString;
      return true;
    }
    mBluetoothDeviceAddress = paramString;
    return false;
  }
  
  public void disconnect() {
    if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
      return;
    }
    mBluetoothGatt.disconnect();
  }
  
  public void close() {
    if (mBluetoothGatt == null) {
      return;
    }
    mBluetoothGatt.close();
    mBluetoothGatt = null;
  }
  
  public void readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {
    if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
      return;
    }
    mBluetoothGatt.readCharacteristic(paramBluetoothGattCharacteristic);
  }
  
  public boolean setCharacteristicNotification(boolean paramBoolean) {
    if ((mBluetoothAdapter == null) || (mBluetoothGatt == null)) {
      return false;
    }
    
    BluetoothGattService localBluetoothGattService = mBluetoothGatt.getService(UUID_SERVICE_C4);
    if (localBluetoothGattService == null) {
      localBluetoothGattService = mBluetoothGatt.getService(UUID_SERVICE_C6);
      if (localBluetoothGattService == null) {
        return false;
      }
    }
    
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = localBluetoothGattService.getCharacteristic(UUID_CHAR_NOTIF_C4);
    if (localBluetoothGattCharacteristic == null) {
      localBluetoothGattCharacteristic = localBluetoothGattService.getCharacteristic(UUID_CHAR_NOTIF_C6);
      if (localBluetoothGattCharacteristic == null) {
        return false;
      }
    }
    
    boolean bool = mBluetoothGatt.setCharacteristicNotification(localBluetoothGattCharacteristic, paramBoolean);
    
    if (!bool) {
      return false;
    }
    
    BluetoothGattDescriptor localBluetoothGattDescriptor = localBluetoothGattCharacteristic.getDescriptor(UUID_DESC_NOTIF);
    if (localBluetoothGattDescriptor == null) {
      return false;
    }
    
    bool = localBluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    if (!bool) {
      return false;
    }
    
    bool = mBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor);
    return bool;
  }
  
  public void writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic) { mBluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic); }
  
  public List<BluetoothGattService> getSupportedGattServices() {
    if (mBluetoothGatt == null) { return null;
    }
    return mBluetoothGatt.getServices();
  }
  
  public BluetoothGatt getBluetoothGatt() { return mBluetoothGatt; }
  

  public boolean writeCharacteristic(byte[] paramArrayOfByte)
  {
    List localList = mBluetoothGatt.getServices();
    if ((localList == null) || (localList.size() == 0)) {
      return false;
    }
    BluetoothGattService localBluetoothGattService = mBluetoothGatt.getService(UUID_SERVICE_C4);
    if (localBluetoothGattService == null) {
      localBluetoothGattService = mBluetoothGatt.getService(UUID_SERVICE_C6);
      if (localBluetoothGattService == null) {
        return false;
      }
    }
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = localBluetoothGattService.getCharacteristic(UUID_CHAR_WRITE_C4);
    if (localBluetoothGattCharacteristic == null) {
      localBluetoothGattCharacteristic = localBluetoothGattService.getCharacteristic(UUID_CHAR_WRITE_C6);
      if (localBluetoothGattCharacteristic == null) {
        return false;
      }
    }
    boolean bool = localBluetoothGattCharacteristic.setValue(paramArrayOfByte);
    if (!bool) {
      return false;
    }
    bool = mBluetoothGatt.writeCharacteristic(localBluetoothGattCharacteristic);
    
    return bool;
  }
  
  synchronized boolean waitForDiscovering(long paramLong) {
    if (isDiscovering) {
      long l1 = System.currentTimeMillis();
      for (;;) {
        try {
          wait(paramLong);
        } catch (InterruptedException localInterruptedException) {
          localInterruptedException.printStackTrace();
        }
        if (!isDiscovering) {
          break;
        }
        long l2 = System.currentTimeMillis();
        
        if (l2 - l1 >= paramLong) {
          return false;
        }
        
        paramLong -= l2 - l1;
        l1 = l2;
      }
    }
    
    return true;
  }
  
  synchronized void notifyDiscovered() {
    isDiscovering = false;
    notify();
  }
  
  public static abstract interface OnDataAvailableListener
  {
    public abstract void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt);
    
    public abstract void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic);
  }
  
  public static abstract interface OnServiceDiscoverListener
  {
    public abstract void onServiceDiscover(BluetoothGatt paramBluetoothGatt);
  }
  
  public static abstract interface OnDisconnectListener
  {
    public abstract void onDisconnect(BluetoothGatt paramBluetoothGatt);
  }
  
  public static abstract interface OnConnectListener
  {
    public abstract void onConnect(BluetoothGatt paramBluetoothGatt);
  }
}
