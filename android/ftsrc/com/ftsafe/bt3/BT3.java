package com.ftsafe.bt3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTReaderInf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class BT3
  implements FTReaderInf
{
  private Context tContext;
  private Handler mHandler = null;
  
  ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
  
  BluetoothAdapter mBlueToothAdapter = null;
  BluetoothDevice mBluetoothDevice = null;
  BluetoothSocket mBlueToothSocket = null;
  
  PipedInputStream pipeIn = new PipedInputStream();
  PipedOutputStream pipeOut = new PipedOutputStream();
  
  byte[] readData = null;
  
  public BT3(Context paramContext, Handler paramHandler) throws Bt3Exception
  {
    tContext = paramContext;
    mHandler = paramHandler;
    mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
    
    if (mBlueToothAdapter == null) {
      throw new Bt3Exception("BluetoothAdapter.getDefaultAdapter() == null");
    }
    
    tContext.registerReceiver(mBt3Receiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
    
    new Thread(new Runnable()
    {
      public void run() {
        try {
          for (;;) {
            if ((mBluetoothDevice != null) && (mBlueToothSocket != null) && (mBlueToothSocket.isConnected()))
            {
              byte[] arrayOfByte = new byte['Ѐ'];
              if (mBlueToothSocket.getInputStream().available() == 0) {
                Thread.sleep(100L);
              }
              else {
                int i = mBlueToothSocket.getInputStream().read(arrayOfByte);
                if ((arrayOfByte[0] == 80) && (arrayOfByte[1] == 2) && (i == 2)) {
                  BT3.this.mHandlerSendMessage(512, "");
                } else if ((arrayOfByte[0] == 80) && (arrayOfByte[1] == 3) && (i == 2)) {
                  BT3.this.mHandlerSendMessage(256, "");
                } else if (isRecvApdu) {
                  pipeOut.write(arrayOfByte, 0, i);
                  notifyDataComing();
                } else {
                  BT3.this.showLog("dirty data:" + Utility.bytes2HexStr(arrayOfByte, i));
                }
              }
            } else { Thread.sleep(1000L);
            }
          }
          


          return;
        } catch (Exception localException) {}
      }
    }).start();
    try { pipeIn.connect(pipeOut);
    } catch (IOException localIOException) {
      throw new Bt3Exception(localIOException.getMessage());
    }
  }
  
  protected void finalize() throws Throwable
  {
    tContext.unregisterReceiver(mBt3Receiver);
    super.finalize();
  }
  
  public Boolean isFtExist()
  {
    if ((mBluetoothDevice != null) && (mBlueToothSocket != null)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  


  public void ft_find()
    throws Bt3Exception
  {
    if (mBlueToothAdapter != null) {
      arrayForBlueToothDevice.clear();
      
      Set localSet = mBlueToothAdapter.getBondedDevices();
      if (localSet.size() > 0) {
        for (BluetoothDevice localBluetoothDevice : localSet) {
          if ((!arrayForBlueToothDevice.contains(localBluetoothDevice)) && (localBluetoothDevice.getName() != null) && (localBluetoothDevice.getName().startsWith("FT_")))
          {


            arrayForBlueToothDevice.add(localBluetoothDevice);
            mHandlerSendMessage(113, localBluetoothDevice);
          }
        }
      }
      
      if (!mBlueToothAdapter.isDiscovering()) {
        mBlueToothAdapter.startDiscovery();
      }
    } else {
      arrayForBlueToothDevice.clear();
      throw new Bt3Exception("mBlueToothAdapter == null");
    }
  }
  

  public void ft_open(Object paramObject)
    throws Bt3Exception
  {
    if (paramObject == null) {
      throw new Bt3Exception("device == null");
    }
    
    mBlueToothAdapter.cancelDiscovery();
    
    try
    {
      if ((mBlueToothSocket != null) && (mBlueToothSocket.isConnected()) && (mBluetoothDevice.getAddress().equals(((BluetoothDevice)paramObject).getAddress())))
      {

        showLog("donaaaaaaaaaaaaaaaaaaaaaa");
        return;
      }
      mBluetoothDevice = ((BluetoothDevice)paramObject);
      if (mBlueToothSocket != null) {
        mBlueToothSocket.close();
      }
      mBlueToothSocket = mBluetoothDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
      mBlueToothSocket.connect();
    }
    catch (Exception localException) {
      throw new Bt3Exception(localException.getMessage());
    }
  }
  

  public void ft_close()
  {
    if (mBluetoothDevice == null) {
      return;
    }
    if (mBlueToothSocket != null) {
      try {
        mBlueToothSocket.close();
      } catch (IOException localIOException) {
        showLog("ft_close::mBlueToothSocket.close()::do-nothing::" + localIOException.getMessage());
      }
      mBlueToothSocket = null;
    }
    mBluetoothDevice = null;
  }
  


  private byte[] intsToBytes(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      arrayOfByte[i] = ((byte)paramArrayOfInt[i]);
    }
    return arrayOfByte;
  }
  









  public byte[] ft_control(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws Bt3Exception
  {
    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 256) && (paramInt4 == 0))
    {


      return intsToBytes(new int[] { 18, 1, 16, 1, 0, 0, 0, 32, 110, 9, 26, 6, 69, 1, 1, 2, 0, 1 });
    }
    

    if ((paramInt1 == 128) && (paramInt2 == 6) && (paramInt3 == 512) && (paramInt4 == 0))
    {


      return intsToBytes(new int[] { 9, 2, 93, 0, 1, 1, 0, 128, 128, 9, 4, 0, 0, 3, 11, 0, 0, 0, 54, 33, 0, 1, 0, 7, 3, 0, 0, 0, 116, 14, 0, 0, 116, 14, 0, 0, 0, 218, 38, 0, 0, 72, 219, 4, 0, 53, 16, 1, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 190, 4, 4, 0, 16, 1, 0, 0, 255, 255, 0, 0, 0, 1, 7, 5, 1, 2, 32, 0, 0, 7, 5, 129, 2, 32, 0, 0 });
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
      return intsToBytes(new int[] { 28, 3, 66, 0, 76, 0, 85, 0, 69, 0, 84, 0, 79, 0, 79, 0, 84, 0, 72, 0, 32, 0, 51, 0, 46, 0, 48, 0 });
    }
    



    return null;
  }
  

  public void ft_send(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws Bt3Exception
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
      
      mBlueToothSocket.getOutputStream().write(paramArrayOfByte);
      mBlueToothSocket.getOutputStream().flush();
    } catch (Exception localException) {
      throw new Bt3Exception("bt3:ft_send:" + localException.getMessage());
    }
  }
  
  public byte[] ft_recv(int paramInt1, int paramInt2) throws Bt3Exception
  {
    byte[] arrayOfByte = BlueToothRead(paramInt2);
    
    return arrayOfByte;
  }
  



  BroadcastReceiver mBt3Receiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
      if ("android.bluetooth.device.action.FOUND".equals(paramAnonymousIntent.getAction())) {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if ((!arrayForBlueToothDevice.contains(localBluetoothDevice)) && (localBluetoothDevice.getName() != null) && (localBluetoothDevice.getName().startsWith("FT_")))
        {


          arrayForBlueToothDevice.add(localBluetoothDevice);
          BT3.this.mHandlerSendMessage(113, localBluetoothDevice);
        }
      }
    }
  };
  
  private byte[] BlueToothRead(int paramInt) throws Bt3Exception {
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
      throw new Bt3Exception("BlueToothRead:" + localException.getMessage());
    }
  }
  
  private boolean isRecvApdu = false;
  private boolean isDataComing = false;
  
  /* Error */
  private void getPipeByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/ftsafe/bt3/BT3:pipeIn	Ljava/io/PipedInputStream;
    //   4: invokevirtual 87	java/io/PipedInputStream:available	()I
    //   7: iload_3
    //   8: if_icmplt +30 -> 38
    //   11: iload_3
    //   12: newarray byte
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 14	com/ftsafe/bt3/BT3:pipeIn	Ljava/io/PipedInputStream;
    //   20: aload 5
    //   22: iconst_0
    //   23: iload_3
    //   24: invokevirtual 88	java/io/PipedInputStream:read	([BII)I
    //   27: pop
    //   28: aload 5
    //   30: iconst_0
    //   31: aload_1
    //   32: iload_2
    //   33: iload_3
    //   34: invokestatic 85	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   37: return
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 22	com/ftsafe/bt3/BT3:isDataComing	Z
    //   43: aload_0
    //   44: iload 4
    //   46: i2l
    //   47: invokevirtual 89	com/ftsafe/bt3/BT3:waitForDataComing	(J)Z
    //   50: ifne +13 -> 63
    //   53: new 69	java/lang/Exception
    //   56: dup
    //   57: ldc 90
    //   59: invokespecial 91	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: goto -63 -> 0
    //   66: astore 5
    //   68: new 69	java/lang/Exception
    //   71: dup
    //   72: aload 5
    //   74: invokevirtual 39	java/io/IOException:getMessage	()Ljava/lang/String;
    //   77: invokespecial 91	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   80: athrow
    // Line number table:
    //   Java source line #340	-> byte code offset #0
    //   Java source line #341	-> byte code offset #11
    //   Java source line #342	-> byte code offset #16
    //   Java source line #344	-> byte code offset #28
    //   Java source line #345	-> byte code offset #37
    //   Java source line #347	-> byte code offset #38
    //   Java source line #348	-> byte code offset #43
    //   Java source line #349	-> byte code offset #53
    //   Java source line #354	-> byte code offset #63
    //   Java source line #352	-> byte code offset #66
    //   Java source line #353	-> byte code offset #68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	BT3
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
  
  synchronized void notifyDataComing() {
    isDataComing = true;
    notify();
  }
  
  private void mHandlerSendMessage(int paramInt, Object paramObject) {
    if (mHandler != null) {
      mHandler.sendMessage(mHandler.obtainMessage(paramInt, paramObject));
    }
  }
  
  private void showLog(String paramString) {
    String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
    String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
    mHandlerSendMessage(112, "[LOG]" + str1 + ":" + str2 + "--->" + paramString);
  }
}
