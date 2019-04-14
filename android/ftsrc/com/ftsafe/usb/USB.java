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
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTReaderInf;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;



public class USB
  implements FTReaderInf
{
  private Context tContext;
  private UsbManager mUsbManager;
  private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
  private final int VendorID = 2414;
  public UsbDevice mUsbDevice = null;
  public UsbDeviceConnection mUsbDeviceConnection = null;
  private UsbInterface[] mUsbInterfaceArray = new UsbInterface[16];
  private Handler mHandler = null;
  
  public USB(Context paramContext, Handler paramHandler) throws UsbException
  {
    tContext = paramContext;
    mHandler = paramHandler;
    
    mUsbManager = ((UsbManager)tContext.getSystemService("usb"));
    if (mUsbManager == null) {
      throw new UsbException("create mUsbManager failed!");
    }
    
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.android.example.USB_PERMISSION");
    localIntentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    localIntentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    tContext.registerReceiver(mUsbReceiver, localIntentFilter);
  }
  
  protected void finalize() throws Throwable
  {
    tContext.unregisterReceiver(mUsbReceiver);
    super.finalize();
  }
  
  public Boolean isFtExist()
  {
    if (mUsbDeviceConnection == null) return Boolean.valueOf(false); return Boolean.valueOf(true);
  }
  
  public void ft_find() throws UsbException
  {
    HashMap localHashMap = mUsbManager.getDeviceList();
    if (localHashMap.isEmpty()) {
      throw new UsbException("Device Not Found");
    }
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(tContext.getApplicationContext(), 0, new Intent("com.android.example.USB_PERMISSION"), 0);
    Iterator localIterator = localHashMap.values().iterator();
    while (localIterator.hasNext()) {
      UsbDevice localUsbDevice = (UsbDevice)localIterator.next();
      if (localUsbDevice.getVendorId() == 2414) {
        if (mUsbManager.hasPermission(localUsbDevice)) {
          mUsbDevice = localUsbDevice;
        } else {
          mUsbManager.requestPermission(localUsbDevice, localPendingIntent);
        }
        return;
      }
    }
    throw new UsbException("Device Not Found");
  }
  

  public void ft_open(Object paramObject)
    throws UsbException
  {
    if (paramObject != null) {
      mUsbDevice = ((UsbDevice)paramObject);
    }
    
    if (mUsbDevice == null) {
      throw new UsbException("No USB FIND !!!");
    }
    
    if (mUsbDeviceConnection != null) {
      mUsbDeviceConnection.close();
    }
    mUsbDeviceConnection = mUsbManager.openDevice(mUsbDevice);
    if (mUsbDeviceConnection == null) {
      throw new UsbException("Device Open Failed");
    }
    
    int i = mUsbDevice.getInterfaceCount();
    for (int j = 0; j < i; j++) {
      mUsbInterfaceArray[j] = mUsbDevice.getInterface(j);
      mUsbDeviceConnection.claimInterface(mUsbInterfaceArray[j], true);
    }
  }
  
  public void ft_close()
  {
    if (mUsbDevice == null) {
      return;
    }
    
    if (mUsbDeviceConnection != null) {
      int i = mUsbDevice.getInterfaceCount();
      for (int j = 0; j < i; j++) {
        mUsbDeviceConnection.releaseInterface(mUsbInterfaceArray[j]);
      }
      mUsbDeviceConnection.close();
      mUsbDeviceConnection = null;
    }
    
    mUsbDevice = null;
  }
  
  public byte[] ft_control(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) throws UsbException
  {
    if (mUsbDeviceConnection == null) {
      throw new UsbException("No Device Found");
    }
    byte[] arrayOfByte1 = new byte[paramInt5];
    int i = mUsbDeviceConnection.controlTransfer(paramInt1, paramInt2, paramInt3, paramInt4, arrayOfByte1, paramInt5, paramInt6);
    if (i <= 0) {
      throw new UsbException("mUsbDeviceConnection.controlTransfer error");
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  public void ft_send(int paramInt1, byte[] paramArrayOfByte, int paramInt2) throws UsbException
  {
    if (mUsbDeviceConnection == null) {
      throw new UsbException("No Device Found");
    }
    UsbEndpoint localUsbEndpoint = null;
    for (int i = 0; i < mUsbInterfaceArray.length; i++) {
      if (mUsbInterfaceArray[i] != null) {
        for (int j = 0; j < mUsbInterfaceArray[i].getEndpointCount(); j++) {
          if (mUsbInterfaceArray[i].getEndpoint(j).getAddress() == paramInt1) {
            localUsbEndpoint = mUsbInterfaceArray[i].getEndpoint(j);
            break;
          }
        }
        if (localUsbEndpoint != null) {
          break;
        }
      }
    }
    if (localUsbEndpoint == null) {
      throw new UsbException("usb_send endpoint error:" + paramInt1);
    }
    i = mUsbDeviceConnection.bulkTransfer(localUsbEndpoint, paramArrayOfByte, paramArrayOfByte.length, paramInt2);
    if (i < 0) {
      throw new UsbException("usb_send error:" + i);
    }
  }
  
  public byte[] ft_recv(int paramInt1, int paramInt2) throws UsbException
  {
    if (mUsbDeviceConnection == null) {
      throw new UsbException("No Device Found");
    }
    UsbEndpoint localUsbEndpoint = null;
    for (int i = 0; i < mUsbInterfaceArray.length; i++) {
      if (mUsbInterfaceArray[i] != null) {
        for (j = 0; j < mUsbInterfaceArray[i].getEndpointCount(); j++) {
          if (mUsbInterfaceArray[i].getEndpoint(j).getAddress() == paramInt1) {
            localUsbEndpoint = mUsbInterfaceArray[i].getEndpoint(j);
            break;
          }
        }
        if (localUsbEndpoint != null) {
          break;
        }
      }
    }
    byte[] arrayOfByte1 = new byte['Ѐ'];
    int j = 0;
    j = mUsbDeviceConnection.bulkTransfer(localUsbEndpoint, arrayOfByte1, arrayOfByte1.length, paramInt2);
    if (j < 0) {
      throw new UsbException("usb_recv error len:" + j);
    }
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    showLog(Utility.bytes2HexStr(arrayOfByte2));
    return arrayOfByte2;
  }
  




  private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
      String str = paramAnonymousIntent.getAction();
      USB.this.showLog(str);
      if ("com.android.example.USB_PERMISSION".equals(str)) {
        synchronized (this) {
          UsbDevice localUsbDevice = (UsbDevice)paramAnonymousIntent.getParcelableExtra("device");
          if (paramAnonymousIntent.getBooleanExtra("permission", false)) {
            if (localUsbDevice != null) {
              USB.this.showLog("usb device is null");
              mUsbDevice = localUsbDevice;
            }
          } else {
            USB.this.showLog("permission denied for device");
          }
        }
      } else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        USB.this.showLog("USB DEVICE ATTACHED");
        USB.this.mHandlerSendMessage(17, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
      } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        USB.this.showLog("USB DEVICE DETACHED");
        USB.this.mHandlerSendMessage(18, "android.hardware.usb.action.USB_DEVICE_ATTACHED");
        ft_close();
      }
    }
  };
  
  private void mHandlerSendMessage(int paramInt, Object paramObject) {
    if (mHandler != null) {
      mHandler.sendMessage(mHandler.obtainMessage(paramInt, paramObject));
    }
  }
  
  private void showLog(String paramString) {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    mHandlerSendMessage(16, "[LOG]" + str1 + ":" + str2 + "--->" + paramString);
  }
}
