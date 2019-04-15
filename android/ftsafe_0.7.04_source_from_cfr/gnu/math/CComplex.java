/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.Complex;
import gnu.math.RealNum;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CComplex
extends Complex
implements Externalizable {
    RealNum real;
    RealNum imag;

    public CComplex() {
    }

    public CComplex(RealNum real, RealNum imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public RealNum re() {
        return this.real;
    }

    @Override
    public RealNum im() {
        return this.imag;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.real);
        out.writeObject(this.imag);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = (RealNum)in.readObject();
        this.imag = (RealNum)in.readObject();
    }
}

