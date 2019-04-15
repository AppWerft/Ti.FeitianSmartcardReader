package com.ftsafe;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.ftsafe.readerScheme.FTReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;








public class PcscServer
{
  Handler gHandler = null;
  FTReader ftReader = null;
  private boolean isContextVaild = false;
  private int gType;
  
  public PcscServer(final int paramInt1, Context paramContext, Handler paramHandler, int paramInt2) {
    gHandler = paramHandler;
    gType = paramInt2;
    ftReader = new FTReader(paramContext, mHandler, paramInt2);
    new Thread(new Runnable() {
      public void run() {
        PcscServer.this.startServer(paramInt1);
      }
    }).start();
  }
  




  private void startServer(int paramInt)
  {
    try
    {
      String[] arrayOfString1 = null;
      byte[][] arrayOfByte = new byte[16][];
      
      Object localObject1 = null;
      
      ServerSocket localServerSocket = new ServerSocket(paramInt);
      for (;;)
      {
        Socket localSocket = localServerSocket.accept();
        PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream())), true);
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
        try
        {
          for (;;) {
            String str1 = localBufferedReader.readLine();
            Object localObject2 = null;
            
            if (str1 == null) {
              break;
            }
            

            String[] arrayOfString2 = str1.split(":");
            
            String str2 = arrayOfString2[0];
            
            if (str2.startsWith("typeA"))
            {
              showLog("RECV : " + str1 + " FOR SCardEstablishContext");
              try {
                if (isContextVaild == true) {
                  localObject2 = "RECVOK";
                }
                else if (gType == 0) {
                  ftReader.readerFind();
                  isContextVaild = true;
                  localObject2 = "RECVOK";
                } else {
                  arrayForBlueToothDevice.clear();
                  isContextVaild = true;
                  localObject2 = "RECVOK";
                }
              }
              catch (Exception localException3) {
                localObject2 = "RECVERR:0x8010002E";
                localObject1 = localException3.getMessage();
                isContextVaild = false;
              }
            } else if (str2.startsWith("typeB"))
            {
              showLog("RECV : " + str1 + " FOR SCardReleaseContext");
              try {
                if (gType == 0) {
                  ftReader.readerClose();
                  isContextVaild = false;
                  localObject2 = "RECVOK";
                } else {
                  arrayForBlueToothDevice.clear();
                  isContextVaild = false;
                  localObject2 = "RECVOK";
                }
              } catch (Exception localException4) {
                localObject2 = "RECVERR:0x88000006";
                localObject1 = localException4.getMessage();
              } } else { int i2;
              if (str2.startsWith("typeC"))
              {
                showLog("RECV : " + str1 + " FOR SCardListReaders");
                try {
                  if (isContextVaild) { String str3;
                    if (gType == 0) {
                      arrayOfString1 = ftReader.readerOpen(null);
                      str3 = "RECVOK";
                      for (i2 = 0; i2 < arrayOfString1.length; i2++) {
                        str3 = str3 + ":" + arrayOfString1[i2];
                      }
                      localObject2 = str3;
                    } else {
                      ftReader.readerFind();
                      if (arrayForBlueToothDevice.isEmpty()) {
                        localObject2 = "RECVERR:0x8010002E";
                        localObject1 = "arrayForBlueToothDevice.isEmpty()";
                      } else {
                        str3 = "RECVOK";
                        for (i2 = 0; i2 < arrayForBlueToothDevice.size(); i2++) {
                          str3 = str3 + ":" + ((BluetoothDevice)arrayForBlueToothDevice.get(i2)).getName();
                        }
                        localObject2 = str3;
                      }
                    }
                  } else {
                    localObject2 = "RECVERR:0x80100003";
                    localObject1 = "isContextVaild false";
                  }
                } catch (Exception localException5) {
                  showLog("ERROR : " + localException5.getMessage());
                  localObject2 = "RECVERR:0x8010002E";
                  localObject1 = localException5.getMessage();
                }
              } else if (str2.startsWith("typeD"))
              {
                try {
                  showLog("RECV : " + str1 + " FOR SCardConnect");
                  if (isContextVaild) {
                    if (arrayOfString2.length != 2) {
                      localObject2 = "RECVERR:0x88000003";
                      localObject1 = localObject2;

                    }
                    else if (gType == 0)
                    {
                      for (int i = 0; i < arrayOfString1.length; i++) {
                        if (arrayOfString1[i].equals(arrayOfString2[1])) {
                          break;
                        }
                      }
                      arrayOfByte[i] = null;
                      showLog("BBBBBBBBBBBBBBBBBBBBBB" + i);
                      if ("typeD1".equals(arrayOfString2[0])) {
                        arrayOfByte[i] = ftReader.readerPowerOn(i);
                      }
                      

                      localObject2 = "RECVOK:" + i;
                    } else {
                      if (arrayForBlueToothDevice.isEmpty()) {
                        localObject2 = "RECVERR:0x8010002E";
                        localObject1 = "arrayForBlueToothDevice.isEmpty()";
                      }
                      BluetoothDevice localBluetoothDevice = null;
                      for (i2 = 0; i2 < arrayForBlueToothDevice.size(); i2++) {
                        if (((BluetoothDevice)arrayForBlueToothDevice.get(i2)).getName().equals(arrayOfString2[1])) {
                          localBluetoothDevice = (BluetoothDevice)arrayForBlueToothDevice.get(i2);
                          break;
                        }
                      }
                      if (localBluetoothDevice == null) {
                        localObject2 = "RECVERR:0x88000004";
                        localObject1 = "device = null";
                      } else {
                        arrayOfString1 = ftReader.readerOpen(localBluetoothDevice);
                        
                        for (i2 = 0; i2 < arrayOfString1.length; i2++) {
                          if (arrayOfString1[i2].substring(3).equals(arrayOfString2[1])) {
                            break;
                          }
                        }
                        arrayOfByte[i2] = null;
                        if ("typeD1".equals(arrayOfString2[0])) {
                          Thread.sleep(500L);
                          try {
                            arrayOfByte[i2] = ftReader.readerPowerOn(i2);
                            localObject2 = "RECVOK:" + i2;
                          } catch (Exception localException12) {
                            localObject2 = "RECVERR:0x80100010";
                            localObject1 = localException12.getMessage();
                          }
                        }
                        else {
                          localObject2 = "RECVOK:" + i2;
                        }
                      }
                    }
                  }
                  else {
                    localObject2 = "RECVERR:0x80100003";
                    localObject1 = "isContextVaild false";
                  }
                } catch (Exception localException6) {
                  showLog("ERROR : " + localException6.getMessage());
                  localObject2 = "RECVERR:0x88000005";
                  localObject1 = localException6.getMessage();
                }
              } else if (str2.startsWith("typeE"))
              {
                showLog("RECV : " + str1 + " FOR SCardStatus");
                try {
                  if (isContextVaild) {
                    int j = Integer.parseInt(arrayOfString2[1]);
                    i2 = ftReader.readerGetSlotStatus(j);
                    localObject2 = "RECVOK:" + i2 + ":" + Utility.bytes2HexStr(arrayOfByte[j]);
                  } else {
                    localObject2 = "RECVERR:0x80100003";
                    localObject1 = "isContextVaild false";
                  }
                } catch (Exception localException7) {
                  showLog("ERROR : " + localException7.getMessage());
                  localObject2 = "RECVERR:0x88000000";
                  localObject1 = localException7.getMessage();
                } } else { byte[] arrayOfByte1;
                byte[] arrayOfByte2;
                if (str2.startsWith("typeF"))
                {
                  showLog("RECV : " + str1 + " FOR SCardTransmit");
                  try {
                    int k = Integer.parseInt(arrayOfString2[1]);
                    if (isContextVaild) {
                      arrayOfByte1 = Utility.hexStrToBytes(arrayOfString2[2]);
                      arrayOfByte2 = ftReader.readerXfr(k, arrayOfByte1);
                      localObject2 = "RECVOK:" + Utility.bytes2HexStr(arrayOfByte2);
                    } else {
                      localObject2 = "RECVERR:0x80100003";
                      localObject1 = "isContextVaild false";
                    }
                  } catch (Exception localException8) {
                    showLog("ERROR : " + localException8.getMessage());
                    localObject2 = "RECVERR:0x88000000";
                    localObject1 = localException8.getMessage();
                  }
                }
                else if (str2.startsWith("typeG"))
                {
                  showLog("RECV : " + str1 + " FOR SCardDisconnect");
                  try {
                    int m = Integer.parseInt(arrayOfString2[1]);
                    if (isContextVaild) {
                      ftReader.readerPowerOff(m);
                      if (gType != 0) {
                        ftReader.readerClose();
                      }
                      localObject2 = "RECVOK";
                      arrayForBlueToothDevice.clear();
                    } else {
                      localObject2 = "RECVERR:0x80100003";
                      localObject1 = "isContextVaild false";
                    }
                  } catch (Exception localException9) {
                    showLog("ERROR : " + localException9.getMessage());
                    localObject2 = "RECVERR:0x88000000";
                    localObject1 = localException9.getMessage();
                  }
                }
                else if (str2.startsWith("typeH"))
                {
                  showLog("RECV : " + str1 + "FOR SCardControl");
                  try {
                    int n = Integer.parseInt(arrayOfString2[1]);
                    if (isContextVaild) {
                      arrayOfByte1 = Utility.hexStrToBytes(arrayOfString2[2]);
                      arrayOfByte2 = ftReader.readerEscape(n, arrayOfByte1);
                      localObject2 = "RECVOK:" + Utility.bytes2HexStr(arrayOfByte2);
                    } else {
                      localObject2 = "RECVERR:0x80100003";
                      localObject1 = "isContextVaild false";
                    }
                  } catch (Exception localException10) {
                    showLog("ERROR : " + localException10.getMessage());
                    localObject2 = "RECVERR:0x88000000";
                    localObject1 = localException10.getMessage();
                  }
                }
                else if (str2.startsWith("typeI"))
                {
                  showLog("RECV : " + str1 + "FOR SCardIsValidContext");
                  if (isContextVaild) {
                    localObject2 = "RECVOK";
                  } else {
                    localObject2 = "RECVERR:0x80100003";
                    localObject1 = "isContextVaild false";
                  }
                } else if (str2.startsWith("typeJ"))
                {
                  showLog("RECV : " + str1 + " FOR SCardGetStatusChange");
                  try {
                    if (isContextVaild) {
                      if (arrayOfString2.length != 2) {
                        localObject2 = "RECVERR:0x88000003";
                        localObject1 = localObject2;
                      } else if (arrayOfString1 == null) {
                        localObject2 = "RECVERR:0x8010002E";
                        localObject1 = "readerList is empty"; } else { int i1;
                        int i3;
                        if (gType == 0)
                        {
                          for (i1 = 0; i1 < arrayOfString1.length; i1++) {
                            showLog("WW " + arrayOfString1[i1]);
                            if (arrayOfString1[i1].equals(arrayOfString2[1])) {
                              break;
                            }
                          }
                          
                          i3 = ftReader.readerGetSlotStatus(i1);
                          localObject2 = "RECVOK:" + i3 + ":" + Utility.bytes2HexStr(arrayOfByte[i1]);
                        }
                        else
                        {
                          for (i1 = 0; i1 < arrayOfString1.length; i1++) {
                            showLog("WW " + arrayOfString1[i1]);
                            if (arrayOfString1[i1].substring(3).equals(arrayOfString2[1])) {
                              break;
                            }
                          }
                          if (i1 == arrayOfString1.length) {
                            localObject2 = "RECVERR:0x88000004";
                            localObject1 = localObject2;
                          } else {
                            i3 = ftReader.readerGetSlotStatus(i1);
                            localObject2 = "RECVOK:" + i3 + ":" + Utility.bytes2HexStr(arrayOfByte[i1]);
                          }
                        }
                      }
                    }
                    else {
                      localObject2 = "RECVERR:0x80100003";
                      localObject1 = "isContextVaild false";
                    }
                  } catch (Exception localException11) {
                    showLog("ERROR : " + localException11.getMessage());
                    localObject2 = "RECVERR:0x88000000";
                    localObject1 = localException11.getMessage();
                  }
                }
                else if (str2.startsWith("typeK"))
                {
                  showLog("RECV : " + str1 + " FOR SCardGetLastError");
                  localObject2 = "RECVOK:" + (String)localObject1;
                } } }
            showLog("SEND : " + (String)localObject2);
            localPrintWriter.println((String)localObject2);
          }
        } catch (Exception localException2) { localSocket.close();
        }
      }
    }
    catch (Exception localException1)
    {
      showLog("startServer ERROR and END:" + localException1.getMessage());
    }
  }
  

  ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList();
  
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {
      super.handleMessage(paramAnonymousMessage);
      
      switch (what) {
      case 113: 
      case 129: 
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)obj;
        if (!arrayForBlueToothDevice.contains(localBluetoothDevice)) {
          arrayForBlueToothDevice.add(localBluetoothDevice);
        }
        
        break;
      case 130: 
        arrayForBlueToothDevice.clear();
      }
      
      


      PcscServer.this.gHandlerSendMessage(what, obj);
    }
  };
  
  private void gHandlerSendMessage(int paramInt, Object paramObject) {
    if (gHandler != null) {
      gHandler.sendMessage(gHandler.obtainMessage(paramInt, paramObject));
    }
  }
  
  private void showLog(String paramString) {
    if (gHandler != null) {
      String str1 = Thread.currentThread().getStackTrace()[3].getClassName();
      String str2 = Thread.currentThread().getStackTrace()[3].getMethodName();
      gHandler.sendMessage(gHandler.obtainMessage(96, "[LOG]" + str1 + ":" + str2 + "--->" + paramString));
    }
  }
}
