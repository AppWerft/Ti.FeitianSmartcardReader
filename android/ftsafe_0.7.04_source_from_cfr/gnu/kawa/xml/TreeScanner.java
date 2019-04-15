/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class TreeScanner
extends MethodProc
implements Externalizable {
    public NodePredicate type;

    TreeScanner() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyTreeScanner");
    }

    public NodePredicate getNodePredicate() {
        return this.type;
    }

    public abstract void scan(AbstractSequence var1, int var2, PositionConsumer var3);

    @Override
    public int numArgs() {
        return 4097;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        KNode spos;
        PositionConsumer out = (PositionConsumer)((Object)ctx.consumer);
        Object node = ctx.getNextArg();
        ctx.lastArg();
        try {
            spos = (KNode)node;
        }
        catch (ClassCastException ex) {
            throw new WrongType(this.getDesc(), -4, node, "node()");
        }
        this.scan(spos.sequence, spos.getPos(), out);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.type);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.type = (NodePredicate)in.readObject();
    }

    public String getDesc() {
        String thisName = this.getClass().getName();
        int dot = thisName.lastIndexOf(46);
        if (dot > 0) {
            thisName = thisName.substring(dot + 1);
        }
        return thisName + "::" + this.type;
    }

    @Override
    public String toString() {
        return "#<" + this.getClass().getName() + ' ' + this.type + '>';
    }
}

