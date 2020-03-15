// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.WrongType;
import gnu.mapping.CallContext;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.mapping.Procedure;
import gnu.lists.NodePredicate;
import java.io.Externalizable;
import gnu.mapping.MethodProc;

public abstract class TreeScanner extends MethodProc implements Externalizable
{
    public NodePredicate type;
    
    TreeScanner() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyTreeScanner");
    }
    
    public NodePredicate getNodePredicate() {
        return this.type;
    }
    
    public abstract void scan(final AbstractSequence p0, final int p1, final PositionConsumer p2);
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final PositionConsumer out = (PositionConsumer)ctx.consumer;
        final Object node = ctx.getNextArg();
        ctx.lastArg();
        KNode spos;
        try {
            spos = (KNode)node;
        }
        catch (ClassCastException ex) {
            throw new WrongType(this.getDesc(), -4, node, "node()");
        }
        this.scan(spos.sequence, spos.getPos(), out);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.type);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.type = (NodePredicate)in.readObject();
    }
    
    public String getDesc() {
        String thisName = this.getClass().getName();
        final int dot = thisName.lastIndexOf(46);
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
