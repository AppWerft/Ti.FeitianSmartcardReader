package com.ftsafe.bt4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTReaderInf;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;








public class BT4
  implements FTReaderInf
{
  private Context tContext;
  private Handler mHandler;
  ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
  
  BluetoothAdapter mBlueToothAdapter = null;
  BluetoothDevice mBluetoothDevice = null;
  
  PipedInputStream pipeIn = new PipedInputStream();
  PipedOutputStream pipeOut = new PipedOutputStream();
  
  BluetoothLeClass mBluetoothLeClass = null;
  
  public BT4(Context paramContext, Handler paramHandler)
    throws Bt4Exception
  {
    tContext = paramContext;
    mHandler = paramHandler;
    mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
    
    if (mBlueToothAdapter == null) {
      throw new Bt4Exception("BluetoothAdapter.getDefaultAdapter() == null");
    }
    
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    
    tContext.registerReceiver(mBt4Receiver, localIntentFilter);
    

    mBluetoothLeClass = new BluetoothLeClass(tContext);
    
    if (!mBluetoothLeClass.initialize()) {
      throw new Bt4Exception("mBluetoothLeClass.initialize() error");
    }
    
    mBluetoothLeClass.setOnServiceDiscoverListener(new BluetoothLeClass.OnServiceDiscoverListener()
    {

      public void onServiceDiscover(BluetoothGatt paramAnonymousBluetoothGatt) {}


    });
    mBluetoothLeClass.setOnConnectListener(new BluetoothLeClass.OnConnectListener()
    {

      public void onConnect(BluetoothGatt paramAnonymousBluetoothGatt) {}


    });
    mBluetoothLeClass.setOnDisconnectListener(new BluetoothLeClass.OnDisconnectListener()
    {

      public void onDisconnect(BluetoothGatt paramAnonymousBluetoothGatt) {}


    });
    mBluetoothLeClass.setOnDataAvailableListener(new BluetoothLeClass.OnDataAvailableListener()
    {
      public void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt) {}
      


      public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        try
        {
          byte[] arrayOfByte = paramAnonymousBluetoothGattCharacteristic.getValue();
          if ((arrayOfByte == null) && (arrayOfByte.length <= 0)) return;
          BT4.this.showLog("NEW:" + Utility.bytes2HexStr(arrayOfByte));
          if ((arrayOfByte[0] == 80) && (arrayOfByte[1] == 2) && (arrayOfByte.length == 2)) {
            BT4.this.mHandlerSendMessage(512, "");
          } else if ((arrayOfByte[0] == 80) && (arrayOfByte[1] == 3) && (arrayOfByte.length == 2)) {
            BT4.this.mHandlerSendMessage(256, "");
          } else {
            pipeOut.write(arrayOfByte, 0, arrayOfByte.length);
            notifyDataComing();
          }
        }
        catch (IOException localIOException)
        {
          BT4.this.showLog("OnDataAvailableListener.onCharacteristicChanged:" + localIOException.getMessage());
        }
      }
    });
    try
    {
      pipeIn.connect(pipeOut);
    } catch (IOException localIOException) {
      throw new Bt4Exception(localIOException.getMessage());
    }
  }
  
  protected void finalize() throws Throwable
  {
    tContext.unregisterReceiver(mBt4Receiver);
    super.finalize();
  }
  



  public Boolean isFtExist()
  {
    if ((mBluetoothDevice != null) && (mBluetoothLeClass.getBluetoothGatt() != null)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  


  public void ft_find()
    throws Bt4Exception
  {
    if (mBlueToothAdapter != null)
    {
      if ((mBluetoothLeClass.getBluetoothGatt() != null) && (mBluetoothLeClass.getBluetoothGatt().connect() == true)) {
        ft_close();
      }
      
      arrayForBlueToothDevice.clear();
      mBlueToothAdapter.startLeScan(mLeScanCallback);
    }
    else {
      arrayForBlueToothDevice.clear();
      throw new Bt4Exception("mBlueToothAdapter == null");
    }
  }
  
  public void ft_open(Object paramObject) throws Bt4Exception
  {
    try {
      if (paramObject == null) {
        throw new Exception("device == null");
      }
      
      mBlueToothAdapter.stopLeScan(mLeScanCallback);
      
      arrayForBlueToothDevice.clear();
      
      if ((mBluetoothDevice != null) && (!mBluetoothDevice.equals(paramObject))) {
        ft_close();
      }
      
      mBluetoothDevice = ((BluetoothDevice)paramObject);
      
      if ((mBluetoothLeClass.getBluetoothGatt() == null) && (!mBluetoothLeClass.connect(mBluetoothDevice.getAddress()))) {
        throw new Exception("mBluetoothLeClass.connect failed");
      }
      Thread.sleep(100L);
    }
    catch (Exception localException)
    {
      throw new Bt4Exception(localException.getMessage());
    }
  }
  
  public void ft_close()
  {
    if (mBluetoothDevice == null) {
      return;
    }
    mBluetoothLeClass.disconnect();
    mBluetoothLeClass.close();
    mBluetoothDevice = null;
  }
  
  private byte[] intsToBytes(int[] paramArrayOfInt) {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      arrayOfByte[i] = ((byte)paramArrayOfInt[i]);
    }
    return arrayOfByte;
  }
  





  public byte[] ft_control(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws Bt4Exception
  {
    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 256) && (paramInt4 == 0))
    {


      return intsToBytes(new int[] { 18, 1, 16, 1, 0, 0, 0, 8, 110, 9, 35, 6, 16, 1, 1, 2, 0, 1 });
    }
    

    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 512) && (paramInt4 == 0))
    {


      return intsToBytes(new int[] { 9, 2, 93, 0, 1, 1, 0, 128, 150, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 16, 1, 0, 7, 3, 0, 0, 0, 160, 15, 0, 0, 224, 46, 0, 0, 4, 0, 42, 0, 0, 44, 128, 10, 0, 46, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 186, 4, 4, 0, 15, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 3, 2, 64, 0, 0, 7, 5, 133, 2, 64, 0, 0 });
    }
    





    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 769) && (paramInt4 == 1033))
    {


      return intsToBytes(new int[] { 6, 3, 70, 0, 84, 0 });
    }
    
    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 770) && (paramInt4 == 1033))
    {




      if (mBluetoothDevice != null) {
        char[] arrayOfChar = mBluetoothDevice.getName().toCharArray();
        int[] arrayOfInt = new int[arrayOfChar.length * 2 + 2];
        arrayOfInt[0] = arrayOfInt.length;
        arrayOfInt[1] = 3;
        for (int i = 0; i < arrayOfChar.length; i++) {
          arrayOfInt[(2 + i * 2)] = arrayOfChar[i];
          arrayOfInt[(2 + i * 2 + 1)] = 0;
        }
        return intsToBytes(arrayOfInt);
      }
      return intsToBytes(new int[] { 28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 52, 0, 46, 0, 48, 0 });
    }
    



    return null;
  }
  
  public void ft_send(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws Bt4Exception
  {
    try
    {
      pipeIn = new PipedInputStream();
      pipeOut = new PipedOutputStream();
      try {
        pipeIn.connect(pipeOut);
      } catch (IOException localIOException) {
        localIOException.printStackTrace();
      }
      
      showLog("SSSSSSSSend:" + Utility.bytes2HexStr(paramArrayOfByte));
      int i = paramArrayOfByte.length;
      int j = 0;
      while (i > 0) {
        try {
          Thread.sleep(10L);
        } catch (InterruptedException localInterruptedException) {
          localInterruptedException.printStackTrace(); }
        byte[] arrayOfByte;
        if (i > 20) {
          arrayOfByte = new byte[20];
          System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 20);
          i -= 20;
          j += 20;
          if (!mBluetoothLeClass.writeCharacteristic(arrayOfByte)) {
            isRecvApdu = false;
            throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
          }
        } else {
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
          i -= i;
          j += i;
          if (!mBluetoothLeClass.writeCharacteristic(arrayOfByte))
          {

            isRecvApdu = false;
            throw new Exception("ft_send:mBluetoothLeClass.writeCharacteristic(data1)");
          }
        }
      }
    } catch (Exception localException) {
      throw new Bt4Exception(localException.getMessage());
    }
  }
  
  public byte[] ft_recv(int paramInt1, int paramInt2) throws Bt4Exception
  {
    showLog("timeout:" + paramInt2);
    return BlueToothRead(paramInt2);
  }
  













  private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback()
  {
    public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte) {
      if ((!arrayForBlueToothDevice.contains(paramAnonymousBluetoothDevice)) && (paramAnonymousBluetoothDevice.getName() != null) && (paramAnonymousBluetoothDevice.getName().startsWith("FT_")))
      {


        BT4.this.showLog("find : " + paramAnonymousBluetoothDevice.getName());
        arrayForBlueToothDevice.add(paramAnonymousBluetoothDevice);
        BT4.this.mHandlerSendMessage(129, paramAnonymousBluetoothDevice);
      }
    }
  };
  
  BroadcastReceiver mBt4Receiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
      if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramAnonymousIntent.getAction())) {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if ((localBluetoothDevice.getName() != null) && (mBluetoothDevice != null) && (localBluetoothDevice.getName().equals(mBluetoothDevice.getName())))
        {

          BT4.this.showLog("ACTION_ACL_DISCONNECTED " + localBluetoothDevice.getAddress());
          BT4.this.mHandlerSendMessage(130, localBluetoothDevice);
          ft_close();
        }
      }
    }
  };
  
  private byte[] BlueToothRead(int paramInt) throws Bt4Exception {
    try {
      byte[] arrayOfByte1 = null;
      byte[] arrayOfByte2 = new byte['က'];
      isRecvApdu = true;
      do {
        getPipeByte(arrayOfByte2, 0, 1, paramInt);
      } while ((arrayOfByte2[0] & 0x80) != 128);
      getPipeByte(arrayOfByte2, 1, 9, paramInt);
      int i = (arrayOfByte2[1] & 0xFF) + ((arrayOfByte2[2] & 0xFF) << 8) + ((arrayOfByte2[3] & 0xFF) << 16) + ((arrayOfByte2[4] & 0xFF) << 24);
      


      i += 10;
      
      if (i > 10) {
        getPipeByte(arrayOfByte2, 10, i - 10, paramInt);
      }
      arrayOfByte1 = new byte[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
      


      isRecvApdu = false;
      return arrayOfByte1;
    } catch (Exception localException) {
      throw new Bt4Exception("BlueToothRead:" + localException.getMessage());
    }
  }
  


  boolean isRecvApdu = false;
  private boolean isDataComing = false;
  
  /* Error */
  private void getPipeByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 11	com/ftsafe/bt4/BT4:pipeIn	Ljava/io/PipedInputStream;
    //   4: invokevirtual 100	java/io/PipedInputStream:available	()I
    //   7: iload_3
    //   8: if_icmplt +30 -> 38
    //   11: iload_3
    //   12: newarray byte
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 11	com/ftsafe/bt4/BT4:pipeIn	Ljava/io/PipedInputStream;
    //   20: aload 5
    //   22: iconst_0
    //   23: iload_3
    //   24: invokevirtual 101	java/io/PipedInputStream:read	([BII)I
    //   27: pop
    //   28: aload 5
    //   30: iconst_0
    //   31: aload_1
    //   32: iload_2
    //   33: iload_3
    //   34: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   37: return
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 23	com/ftsafe/bt4/BT4:isDataComing	Z
    //   43: aload_0
    //   44: iload 4
    //   46: i2l
    //   47: invokevirtual 102	com/ftsafe/bt4/BT4:waitForDataComing	(J)Z
    //   50: ifne +13 -> 63
    //   53: new 63	java/lang/Exception
    //   56: dup
    //   57: ldc 103
    //   59: invokespecial 65	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: goto -63 -> 0
    //   66: astore 5
    //   68: new 63	java/lang/Exception
    //   71: dup
    //   72: aload 5
    //   74: invokevirtual 53	java/io/IOException:getMessage	()Ljava/lang/String;
    //   77: invokespecial 65	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   80: athrow
    // Line number table:
    //   Java source line #402	-> byte code offset #0
    //   Java source line #403	-> byte code offset #11
    //   Java source line #404	-> byte code offset #16
    //   Java source line #405	-> byte code offset #28
    //   Java source line #406	-> byte code offset #37
    //   Java source line #408	-> byte code offset #38
    //   Java source line #409	-> byte code offset #43
    //   Java source line #410	-> byte code offset #53
    //   Java source line #415	-> byte code offset #63
    //   Java source line #413	-> byte code offset #66
    //   Java source line #414	-> byte code offset #68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	BT4
    //   0	81	1	paramArrayOfByte	byte[]
    //   0	81	2	paramInt1	int
    //   0	81	3	paramInt2	int
    //   0	81	4	paramInt3	int
    //   14	15	5	arrayOfByte	byte[]
    //   66	7	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	37	66	java/io/IOException
    //   38	63	66	java/io/IOException
  }
  
  synchronized boolean waitForDataComing(long paramLong)
  {
    if (!isDataComing) {
      long l1 = System.currentTimeMillis();
      for (;;) {
        try {
          wait(paramLong);
        } catch (InterruptedException localInterruptedException) {
          localInterruptedException.printStackTrace();
        }
        if (isDataComing) {
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
  
  synchronized void notifyDataComing()
  {
    isDataComing = true;
    notify();
  }
  

  private void mHandlerSendMessage(int paramInt, Object paramObject)
  {
    if (mHandler != null) {
      mHandler.sendMessage(mHandler.obtainMessage(paramInt, paramObject));
    }
  }
  
  private void showLog(String paramString)
  {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    mHandlerSendMessage(128, "[LOG]" + str1 + ":" + str2 + "--->" + paramString);
  }
}
