/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.mapping.Procedure;
import gnu.xml.NodeTree;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NodeType
extends ObjectType
implements TypeValue,
NodePredicate,
Externalizable {
    public static final int TEXT_OK = 1;
    public static final int ELEMENT_OK = 2;
    public static final int ATTRIBUTE_OK = 4;
    public static final int DOCUMENT_OK = 8;
    public static final int COMMENT_OK = 16;
    public static final int PI_OK = 32;
    int kinds = -1;
    public static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
    public static final ClassType typeNodeType = ClassType.make("gnu.kawa.xml.NodeType");
    public static final NodeType nodeType = new NodeType("gnu.kawa.xml.KNode");
    static final Method coerceMethod = typeNodeType.getDeclaredMethod("coerceForce", 2);
    static final Method coerceOrNullMethod = typeNodeType.getDeclaredMethod("coerceOrNull", 2);
    public static final NodeType documentNodeTest = new NodeType("document-node", 8);
    public static final NodeType textNodeTest = new NodeType("text", 1);
    public static final NodeType commentNodeTest = new NodeType("comment", 16);
    public static final NodeType anyNodeTest = new NodeType("node");

    public NodeType(String name, int kinds) {
        super(name);
        this.kinds = kinds;
    }

    public NodeType(String name) {
        this(name, -1);
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitPushInt(this.kinds);
        code.emitInvokeStatic(coerceMethod);
    }

    @Override
    public Expression convertValue(Expression value) {
        ApplyExp aexp = new ApplyExp(coerceMethod, value);
        aexp.setType(this);
        return aexp;
    }

    @Override
    public Object coerceFromObject(Object obj) {
        return NodeType.coerceForce(obj, this.kinds);
    }

    @Override
    public Type getImplementationType() {
        return typeKNode;
    }

    @Override
    public int compare(Type other) {
        return this.getImplementationType().compare(other);
    }

    @Override
    public boolean isInstance(Object obj) {
        return NodeType.isInstance(obj, this.kinds);
    }

    static boolean isInstance(Object obj, int kinds) {
        if (obj instanceof KNode) {
            KNode pos = (KNode)obj;
            return NodeType.isInstance(pos.sequence, pos.getPos(), kinds);
        }
        return false;
    }

    @Override
    public boolean isInstancePos(AbstractSequence seq, int ipos) {
        return NodeType.isInstance(seq, ipos, this.kinds);
    }

    public static boolean isInstance(AbstractSequence seq, int ipos, int kinds) {
        int kind = seq.getNextKind(ipos);
        if (kinds < 0) {
            return kind != 0;
        }
        switch (kind) {
            case 0: {
                return false;
            }
            case 32: {
                return NodeType.isInstance(seq.getPosNext(ipos), kinds);
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
                return (kinds & 1) != 0;
            }
            case 33: {
                return (kinds & 2) != 0;
            }
            case 35: {
                return (kinds & 4) != 0;
            }
            case 34: {
                return (kinds & 8) != 0;
            }
            case 36: {
                return (kinds & 16) != 0;
            }
            case 37: {
                return (kinds & 32) != 0;
            }
        }
        return true;
    }

    public static KNode coerceForce(Object obj, int kinds) {
        KNode pos = NodeType.coerceOrNull(obj, kinds);
        if (pos == null) {
            throw new ClassCastException("coerce from " + obj.getClass());
        }
        return pos;
    }

    public static KNode coerceOrNull(Object obj, int kinds) {
        KNode pos;
        if (obj instanceof NodeTree) {
            pos = KNode.make((NodeTree)obj);
        } else if (obj instanceof KNode) {
            pos = (KNode)obj;
        } else {
            return null;
        }
        return NodeType.isInstance(pos.sequence, pos.ipos, kinds) ? pos : null;
    }

    protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushInt(this.kinds);
        code.emitInvokeStatic(coerceOrNullMethod);
    }

    @Override
    public void emitTestIf(Variable incoming, Declaration decl, Compilation comp) {
        CodeAttr code = comp.getCode();
        this.emitCoerceOrNullMethod(incoming, comp);
        if (decl != null) {
            code.emitDup();
            decl.compileStore(comp);
        }
        code.emitIfNotNull();
    }

    @Override
    public void emitIsInstance(Variable incoming, Compilation comp, Target target) {
        if (target instanceof ConditionalTarget) {
            ConditionalTarget ctarget = (ConditionalTarget)target;
            this.emitCoerceOrNullMethod(incoming, comp);
            CodeAttr code = comp.getCode();
            if (ctarget.trueBranchComesFirst) {
                code.emitGotoIfCompare1(ctarget.ifFalse, 198);
            } else {
                code.emitGotoIfCompare1(ctarget.ifTrue, 199);
            }
            ctarget.emitGotoFirstBranch(code);
        } else {
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
    public void writeExternal(ObjectOutput out) throws IOException {
        String name = this.getName();
        out.writeUTF(name == null ? "" : name);
        out.writeInt(this.kinds);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String name = in.readUTF();
        if (name.length() > 0) {
            this.setName(name);
        }
        this.kinds = in.readInt();
    }

    @Override
    public String encodeType(Language language) {
        return null;
    }
}

