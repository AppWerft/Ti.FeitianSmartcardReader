package kawa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;











































public class Telnet
  implements Runnable
{
  boolean isServer;
  static final int SE = 240;
  static final int NOP = 241;
  static final int IP = 244;
  static final int EOF = 236;
  static final int SB = 250;
  public static final int WILL = 251;
  public static final int WONT = 252;
  public static final int DO = 253;
  public static final int DONT = 254;
  static final int IAC = 255;
  public static final int ECHO = 1;
  public static final int SUPPRESS_GO_AHEAD = 3;
  static final int TM = 6;
  static final int TTYPE = 24;
  static final int NAWS = 31;
  static final int LINEMODE = 34;
  public short windowHeight;
  public short windowWidth;
  public byte[] terminalType;
  final byte preferredLineMode = 3;
  
  InputStream sin;
  
  OutputStream sout;
  TelnetInputStream in;
  TelnetOutputStream out;
  
  public TelnetInputStream getInputStream()
  {
    return in;
  }
  
  public TelnetOutputStream getOutputStream()
  {
    return out;
  }
  







  final byte[] optionsState = new byte['Ā'];
  



  static final int OPTION_NO = 0;
  



  static final int OPTION_WANTNO = 1;
  



  static final int OPTION_WANTNO_OPPOSITE = 2;
  



  static final int OPTION_WANTYES = 3;
  



  static final int OPTION_WANTYES_OPPOSITE = 4;
  


  static final int OPTION_YES = 5;
  



  boolean change(int command, int option)
  {
    if (option == 6)
      return true;
    if ((isServer) && (option == 31))
      return true;
    if ((isServer) && (command == 251) && (option == 34))
    {
      byte[] buf = new byte[2];
      buf[0] = 1;
      buf[1] = 3;
      try
      {
        out.writeSubCommand(34, buf);
      }
      catch (IOException ex) {}
      


      return true;
    }
    if ((isServer) && (command == 251) && (option == 24))
    {
      byte[] buf = new byte[1];
      buf[0] = 1;
      try
      {
        out.writeSubCommand(option, buf);
      }
      catch (IOException ex) {}
      


      return true;
    }
    if ((!isServer) && (option == 1))
    {
      if (command == 253)
        return false;
      if (command == 251)
        return true;
    }
    return false;
  }
  


  public void subCommand(byte[] buf, int off, int len)
  {
    int command = buf[off];
    switch (command)
    {
    case 31: 
      if (len == 5)
      {
        windowWidth = ((short)((buf[1] << 8) + (buf[2] & 0xFF)));
        windowHeight = ((short)((buf[3] << 8) + (buf[4] & 0xFF))); return;
      }
      




      break;
    case 24: 
      byte[] type = new byte[len - 1];
      System.arraycopy(buf, 1, type, 0, len - 1);
      terminalType = type;
      System.err.println("terminal type: '" + new String(type) + "'");
      return;
    
    case 34: 
      System.err.println("SBCommand LINEMODE " + buf[1] + " len:" + len);
      if (buf[1] == 3)
      {
        for (int i = 2; i + 2 < len; i += 3)
        {
          System.err.println("  " + buf[i] + "," + buf[(i + 1)] + "," + buf[(i + 2)]);
        }
        
        return;
      }
      
      break;
    }
    
  }
  

  void handle(int command, int option)
    throws IOException
  {
    boolean otherSide = command < 253;
    

    boolean wantOn = (command & 0x1) != 0;
    byte state = optionsState[option];
    
    if (otherSide)
      state = (byte)(state >> 3);
    switch (state >> 3 & 0x7)
    {
    case 5: 
      if (wantOn) {
        return;
      }
      state = 0;
      change(command, option);
      out.writeCommand(otherSide ? 254 : 252, option);
      break;
    case 0: 
      if (!wantOn)
        return;
      if (change(command, option))
      {
        state = 5;
        out.writeCommand(otherSide ? 253 : 251, option);
      }
      else
      {
        out.writeCommand(otherSide ? 254 : 252, option);
      }
      
      break;
    case 1: 
      state = 0;
      break;
    



    case 2: 
      state = 3;
      out.writeCommand(otherSide ? 253 : 251, option);
      
      break;
    case 3: 
      if (wantOn)
      {
        state = 5;
        change(command, option);
      }
      else {
        state = 0; }
      break;
    case 4: 
      if (wantOn)
      {
        state = 1;
        out.writeCommand(otherSide ? 254 : 252, option);
      }
      else
      {
        state = 0;
      }
      break;
    }
    if (otherSide) {
      state = (byte)(optionsState[option] & 0xC7 | state << 3);
    } else
      state = (byte)(optionsState[option] & 0xF8 | state);
    optionsState[option] = state;
  }
  




  public void request(int command, int option)
    throws IOException
  {
    boolean otherSide = command >= 253;
    

    boolean wantOn = (command & 0x1) != 0;
    
    byte state = optionsState[option];
    if (otherSide) {
      state = (byte)(state >> 3);
    }
    switch (state & 0x7)
    {
    case 0: 
      if (wantOn)
      {
        state = 3;
        out.writeCommand(command, option);
      }
      
      break;
    case 5: 
      if (!wantOn)
      {
        state = 1;
        out.writeCommand(command, option);
      }
      
      break;
    case 1: 
      if (wantOn) {
        state = 2;
      }
      break;
    case 2: 
      if (!wantOn) {
        state = 1;
      }
      break;
    case 3: 
      if (!wantOn) {
        state = 4;
      }
    case 4: 
      if (wantOn) {
        state = 3;
      }
      break;
    }
    
    if (otherSide) {
      state = (byte)(optionsState[option] & 0xC7 | state << 3);
    } else
      state = (byte)(optionsState[option] & 0xF8 | state);
    optionsState[option] = state;
  }
  
  static void usage()
  {
    System.err.println("Usage:  [java] kawa.Telnet HOST [PORT#]");
    System.exit(-1);
  }
  
  public static void main(String[] args)
  {
    if (args.length == 0)
      usage();
    String host = args[0];
    int port = 23;
    if (args.length > 1)
    {
      port = Integer.parseInt(args[1]);
    }
    try
    {
      Socket socket = new Socket(host, port);
      Telnet telnet = new Telnet(socket, false);
      TelnetOutputStream tout = telnet.getOutputStream();
      Thread t = new Thread(telnet);
      
      t.setPriority(Thread.currentThread().getPriority() + 1);
      t.start();
      
      byte[] buffer = new byte['Ѐ'];
      for (;;)
      {
        int ch = System.in.read();
        if (ch < 0)
          break;
        buffer[0] = ((byte)ch);
        int avail = System.in.available();
        if (avail > 0)
        {
          if (avail > buffer.length - 1)
            avail = buffer.length - 1;
          avail = System.in.read(buffer, 1, avail);
        }
        tout.write(buffer, 0, avail + 1);
      }
      t.stop();
    }
    catch (Exception ex)
    {
      System.err.println(ex);
    }
  }
  
  public Telnet(Socket socket, boolean isServer)
    throws IOException
  {
    sin = socket.getInputStream();
    sout = socket.getOutputStream();
    out = new TelnetOutputStream(sout);
    in = new TelnetInputStream(sin, this);
    this.isServer = isServer;
  }
  
  public void run()
  {
    try
    {
      TelnetInputStream tin = getInputStream();
      byte[] buffer = new byte['Ѐ'];
      for (;;)
      {
        int ch = tin.read();
        if (ch < 0)
          break;
        buffer[0] = ((byte)ch);
        int avail = tin.available();
        if (avail > 0)
        {
          if (avail > buffer.length - 1)
            avail = buffer.length - 1;
          avail = tin.read(buffer, 1, avail);
        }
        System.out.write(buffer, 0, avail + 1);
      }
    }
    catch (IOException ex)
    {
      System.err.println(ex);
      System.exit(-1);
    }
  }
}
