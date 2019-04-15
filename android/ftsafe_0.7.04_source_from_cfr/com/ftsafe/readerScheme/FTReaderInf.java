/*
 * Decompiled with CFR 0.139.
 */
package com.ftsafe.readerScheme;

public interface FTReaderInf {
    public Boolean isFtExist();

    public void ft_find() throws Exception;

    public void ft_open(Object var1) throws Exception;

    public void ft_close();

    public byte[] ft_control(int var1, int var2, int var3, int var4, int var5, int var6) throws Exception;

    public void ft_send(int var1, byte[] var2, int var3) throws Exception;

    public byte[] ft_recv(int var1, int var2) throws Exception;
}

