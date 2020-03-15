// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe.readerScheme;

public interface FTReaderInf
{
    Boolean isFtExist();
    
    void ft_find() throws Exception;
    
    void ft_open(final Object p0) throws Exception;
    
    void ft_close();
    
    byte[] ft_control(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5) throws Exception;
    
    void ft_send(final int p0, final byte[] p1, final int p2) throws Exception;
    
    byte[] ft_recv(final int p0, final int p1) throws Exception;
}
