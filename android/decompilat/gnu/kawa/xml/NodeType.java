// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.expr.Language;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.Procedure;
import gnu.kawa.reflect.InstanceOf;
import gnu.expr.ConditionalTarget;
import gnu.expr.Target;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import gnu.xml.NodeTree;
import gnu.lists.AbstractSequence;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import java.io.Externalizable;
import gnu.lists.NodePredicate;
import gnu.expr.TypeValue;
import gnu.bytecode.ObjectType;

public class NodeType extends ObjectType implements TypeValue, NodePredicate, Externalizable
{
    public static final int TEXT_OK = 1;
    public static final int ELEMENT_OK = 2;
    public static final int ATTRIBUTE_OK = 4;
    public static final int DOCUMENT_OK = 8;
    public static final int COMMENT_OK = 16;
    public static final int PI_OK = 32;
    int kinds;
    public static final ClassType typeKNode;
    public static final ClassType typeNodeType;
    public static final NodeType nodeType;
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    public static final NodeType documentNodeTest;
    public static final NodeType textNodeTest;
    public static final NodeType commentNodeTest;
    public static final NodeType anyNodeTest;
    
    public NodeType(final String name, final int kinds) {
        super(name);
        this.kinds = -1;
        this.kinds = kinds;
    }
    
    public NodeType(final String name) {
        this(name, -1);
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        code.emitPushInt(this.kinds);
        code.emitInvokeStatic(NodeType.coerceMethod);
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        final ApplyExp aexp = new ApplyExp(NodeType.coerceMethod, new Expression[] { value });
        aexp.setType(this);
        return aexp;
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        return coerceForce(obj, this.kinds);
    }
    
    @Override
    public Type getImplementationType() {
        return NodeType.typeKNode;
    }
    
    @Override
    public int compare(final Type other) {
        return this.getImplementationType().compare(other);
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        return isInstance(obj, this.kinds);
    }
    
    static boolean isInstance(final Object obj, final int kinds) {
        if (obj instanceof KNode) {
            final KNode pos = (KNode)obj;
            return isInstance(pos.sequence, pos.getPos(), kinds);
        }
        return false;
    }
    
    @Override
    public boolean isInstancePos(final AbstractSequence seq, final int ipos) {
        return isInstance(seq, ipos, this.kinds);
    }
    
    public static boolean isInstance(final AbstractSequence seq, final int ipos, final int kinds) {
        final int kind = seq.getNextKind(ipos);
        if (kinds < 0) {
            return kind != 0;
        }
        switch (kind) {
            case 0: {
                return false;
            }
            case 32: {
                return isInstance(seq.getPosNext(ipos), kinds);
            }
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29: {
                return (kinds & 0x1) != 0x0;
            }
            case 33: {
                return (kinds & 0x2) != 0x0;
            }
            case 35: {
                return (kinds & 0x4) != 0x0;
            }
            case 34: {
                return (kinds & 0x8) != 0x0;
            }
            case 36: {
                return (kinds & 0x10) != 0x0;
            }
            case 37: {
                return (kinds & 0x20) != 0x0;
            }
            default: {
                return true;
            }
        }
    }
    
    public static KNode coerceForce(final Object obj, final int kinds) {
        final KNode pos = coerceOrNull(obj, kinds);
        if (pos == null) {
            throw new ClassCastException("coerce from " + obj.getClass());
        }
        return pos;
    }
    
    public static KNode coerceOrNull(final Object obj, final int kinds) {
        KNode pos;
        if (obj instanceof NodeTree) {
            pos = KNode.make((NodeTree)obj);
        }
        else {
            if (!(obj instanceof KNode)) {
                return null;
            }
            pos = (KNode)obj;
        }
        return isInstance(pos.sequence, pos.ipos, kinds) ? pos : null;
    }
    
    protected void emitCoerceOrNullMethod(final Variable incoming, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushInt(this.kinds);
        code.emitInvokeStatic(NodeType.coerceOrNullMethod);
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        this.emitCoerceOrNullMethod(incoming, comp);
        if (decl != null) {
            code.emitDup();
            decl.compileStore(comp);
        }
        code.emitIfNotNull();
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        if (target instanceof ConditionalTarget) {
            final ConditionalTarget ctarget = (ConditionalTarget)target;
            this.emitCoerceOrNullMethod(incoming, comp);
            final CodeAttr code = comp.getCode();
            if (ctarget.trueBranchComesFirst) {
                code.emitGotoIfCompare1(ctarget.ifFalse, 198);
            }
            else {
                code.emitGotoIfCompare1(ctarget.ifTrue, 199);
            }
            ctarget.emitGotoFirstBranch(code);
        }
        else {
            InstanceOf.emitIsInstance(this, incoming, comp, target);
        }
    }
    
    @Override
    public Procedure getConstructor() {
        return null;
    }
    
    @Override
    public String toString() {
        return "NodeType " + this.getName();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        final String name = this.getName();
        out.writeUTF((name == null) ? "" : name);
        out.writeInt(this.kinds);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        final String name = in.readUTF();
        if (name.length() > 0) {
            this.setName(name);
        }
        this.kinds = in.readInt();
    }
    
    @Override
    public String encodeType(final Language language) {
        return null;
    }
    
    static {
        typeKNode = ClassType.make("gnu.kawa.xml.KNode");
        typeNodeType = ClassType.make("gnu.kawa.xml.NodeType");
        nodeType = new NodeType("gnu.kawa.xml.KNode");
        coerceMethod = NodeType.typeNodeType.getDeclaredMethod("coerceForce", 2);
        coerceOrNullMethod = NodeType.typeNodeType.getDeclaredMethod("coerceOrNull", 2);
        documentNodeTest = new NodeType("document-node", 8);
        textNodeTest = new NodeType("text", 1);
        commentNodeTest = new NodeType("comment", 16);
        anyNodeTest = new NodeType("node");
    }
}
