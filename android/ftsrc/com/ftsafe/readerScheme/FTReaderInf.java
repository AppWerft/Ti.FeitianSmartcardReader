package com.ftsafe.readerScheme;

public abstract interface FTReaderInf
{
  public abstract Boolean isFtExist();
  
  public abstract void ft_find()
    throws Exception;
  
  public abstract void ft_open(Object paramObject)
    throws Exception;
  
  public abstract void ft_close();
  
  public abstract byte[] ft_control(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws Exception;
  
  public abstract void ft_send(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws Exception;
  
  public abstract byte[] ft_recv(int paramInt1, int paramInt2)
    throws Exception;
}
