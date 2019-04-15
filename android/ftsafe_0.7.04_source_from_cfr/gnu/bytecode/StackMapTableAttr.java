/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.MiscAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.UninitializedType;
import java.io.DataOutputStream;
import java.io.IOException;

public class StackMapTableAttr
extends MiscAttr {
    public static boolean compressStackMapTable = true;
    int numEntries;
    int prevPosition = -1;
    int[] encodedLocals;
    int[] encodedStack;
    int countLocals;
    int countStack;

    public StackMapTableAttr() {
        super("StackMapTable", null, 0, 0);
        this.put2(0);
    }

    public StackMapTableAttr(byte[] data, CodeAttr code) {
        super("StackMapTable", data, 0, data.length);
        this.addToFrontOf(code);
        this.numEntries = this.u2(0);
    }

    public Method getMethod() {
        return ((CodeAttr)this.container).getMethod();
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        this.put2(0, this.numEntries);
        super.write(dstr);
    }

    void emitVerificationType(int encoding) {
        int tag = encoding & 255;
        this.put1(tag);
        if (tag >= 7) {
            this.put2(encoding >> 8);
        }
    }

    int encodeVerificationType(Type type, CodeAttr code) {
        if (type == null) {
            return 0;
        }
        if (type instanceof UninitializedType) {
            UninitializedType utype = (UninitializedType)type;
            Label label = utype.label;
            if (label == null) {
                return 6;
            }
            return label.position << 8 | 8;
        }
        if (type == Type.nullType) {
            return 5;
        }
        if ((type = type.getRawType()) instanceof PrimType) {
            switch (type.signature.charAt(0)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    return 1;
                }
                case 'J': {
                    return 4;
                }
                case 'F': {
                    return 2;
                }
                case 'D': {
                    return 3;
                }
            }
            return 0;
        }
        return code.getConstants().addClass((ObjectType)((ObjectType)type)).index << 8 | 7;
    }

    public void emitStackMapEntry(Label label, CodeAttr code) {
        int i;
        int rawStackCount;
        int offset_delta = label.position - this.prevPosition - 1;
        boolean matchingLocals = false;
        int rawLocalsCount = label.localTypes.length;
        if (rawLocalsCount > this.encodedLocals.length) {
            int[] tmp = new int[rawLocalsCount + this.encodedLocals.length];
            System.arraycopy(this.encodedLocals, 0, tmp, 0, this.countLocals);
            this.encodedLocals = tmp;
        }
        if ((rawStackCount = label.stackTypes.length) > this.encodedStack.length) {
            int[] tmp = new int[rawStackCount + this.encodedStack.length];
            System.arraycopy(this.encodedStack, 0, tmp, 0, this.countStack);
            this.encodedStack = tmp;
        }
        int unchangedLocals = 0;
        int curLocalsCount = 0;
        for (int i2 = 0; i2 < rawLocalsCount; ++i2) {
            int prevType = this.encodedLocals[curLocalsCount];
            int nextType = this.encodeVerificationType(label.localTypes[i2], code);
            if (prevType == nextType && unchangedLocals == curLocalsCount) {
                unchangedLocals = curLocalsCount + 1;
            }
            this.encodedLocals[curLocalsCount++] = nextType;
            if (nextType != 3 && nextType != 4) continue;
            ++i2;
        }
        while (curLocalsCount > 0 && this.encodedLocals[curLocalsCount - 1] == 0) {
            --curLocalsCount;
        }
        int curStackCount = 0;
        for (int i3 = 0; i3 < rawStackCount; ++i3) {
            int prevType = this.encodedStack[curStackCount];
            Type t = label.stackTypes[i3];
            if (t == Type.voidType) {
                t = label.stackTypes[++i3];
            }
            int nextType = this.encodeVerificationType(t, code);
            this.encodedStack[curStackCount++] = nextType;
        }
        int localsDelta = curLocalsCount - this.countLocals;
        if (compressStackMapTable && localsDelta == 0 && curLocalsCount == unchangedLocals && curStackCount <= 1) {
            if (curStackCount == 0) {
                if (offset_delta <= 63) {
                    this.put1(offset_delta);
                } else {
                    this.put1(251);
                    this.put2(offset_delta);
                }
            } else {
                if (offset_delta <= 63) {
                    this.put1(64 + offset_delta);
                } else {
                    this.put1(247);
                    this.put2(offset_delta);
                }
                this.emitVerificationType(this.encodedStack[0]);
            }
        } else if (compressStackMapTable && curStackCount == 0 && curLocalsCount < this.countLocals && unchangedLocals == curLocalsCount && localsDelta >= -3) {
            this.put1(251 + localsDelta);
            this.put2(offset_delta);
        } else if (compressStackMapTable && curStackCount == 0 && this.countLocals == unchangedLocals && localsDelta <= 3) {
            this.put1(251 + localsDelta);
            this.put2(offset_delta);
            for (i = 0; i < localsDelta; ++i) {
                this.emitVerificationType(this.encodedLocals[unchangedLocals + i]);
            }
        } else {
            this.put1(255);
            this.put2(offset_delta);
            this.put2(curLocalsCount);
            for (i = 0; i < curLocalsCount; ++i) {
                this.emitVerificationType(this.encodedLocals[i]);
            }
            this.put2(curStackCount);
            for (i = 0; i < curStackCount; ++i) {
                this.emitVerificationType(this.encodedStack[i]);
            }
        }
        this.countLocals = curLocalsCount;
        this.countStack = curStackCount;
        this.prevPosition = label.position;
        ++this.numEntries;
    }

    void printVerificationType(int encoding, ClassTypeWriter dst) {
        int tag = encoding & 255;
        switch (tag) {
            case 0: {
                dst.print("top/unavailable");
                break;
            }
            case 1: {
                dst.print("integer");
                break;
            }
            case 2: {
                dst.print("float");
                break;
            }
            case 3: {
                dst.print("double");
                break;
            }
            case 4: {
                dst.print("long");
                break;
            }
            case 5: {
                dst.print("null");
                break;
            }
            case 6: {
                dst.print("uninitialized this");
                break;
            }
            case 7: {
                int index = encoding >> 8;
                dst.printOptionalIndex(index);
                dst.printConstantTersely(index, 7);
                break;
            }
            case 8: {
                int offset = encoding >> 8;
                dst.print("uninitialized object created at ");
                dst.print(offset);
                break;
            }
            default: {
                dst.print("<bad verification type tag " + tag + '>');
            }
        }
    }

    int extractVerificationType(int startOffset, int tag) {
        if (tag == 7 || tag == 8) {
            int value = this.u2(startOffset + 1);
            tag |= value << 8;
        }
        return tag;
    }

    static int[] reallocBuffer(int[] buffer, int needed) {
        if (buffer == null) {
            buffer = new int[needed + 10];
        } else if (needed > buffer.length) {
            int[] tmp = new int[needed + 10];
            System.arraycopy(buffer, 0, tmp, 0, buffer.length);
            buffer = tmp;
        }
        return buffer;
    }

    int extractVerificationTypes(int startOffset, int count, int startIndex, int[] buffer) {
        int offset = startOffset;
        while (--count >= 0) {
            int encoding;
            if (offset >= this.dataLength) {
                encoding = -1;
            } else {
                byte tag = this.data[offset];
                encoding = this.extractVerificationType(offset, tag);
                offset += tag == 7 || tag == 8 ? 3 : 1;
            }
            buffer[startIndex++] = encoding;
        }
        return offset;
    }

    void printVerificationTypes(int[] encodings, int startIndex, int count, ClassTypeWriter dst) {
        int regno = 0;
        for (int i = 0; i < startIndex + count; ++i) {
            int encoding = encodings[i];
            int tag = encoding & 255;
            if (i >= startIndex) {
                dst.print("  ");
                if (regno < 100) {
                    if (regno < 10) {
                        dst.print(' ');
                    }
                    dst.print(' ');
                }
                dst.print(regno);
                dst.print(": ");
                this.printVerificationType(encoding, dst);
                dst.println();
            }
            ++regno;
            if (tag != 3 && tag != 4) continue;
            ++regno;
        }
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", number of entries: ");
        dst.println(this.numEntries);
        int ipos = 2;
        int pc_offset = -1;
        Method method = this.getMethod();
        int[] encodedTypes = null;
        int curLocals = (method.getStaticFlag() ? 0 : 1) + method.arg_types.length;
        int curStack = 0;
        for (int i = 0; i < this.numEntries; ++i) {
            if (ipos >= this.dataLength) {
                i = -1;
                break;
            }
            int tag = this.u1(ipos++);
            ++pc_offset;
            int delta = -1;
            if (tag <= 127) {
                pc_offset += tag & 63;
            } else {
                if (ipos + 1 >= this.dataLength) {
                    ipos = -1;
                    break;
                }
                delta = this.u2(ipos);
                pc_offset += delta;
                ipos += 2;
            }
            dst.print("  offset: ");
            dst.print(pc_offset);
            if (tag <= 63) {
                dst.println(" - same_frame");
                curStack = 0;
            } else if (tag <= 127 || tag == 247) {
                dst.println(tag <= 127 ? " - same_locals_1_stack_item_frame" : " - same_locals_1_stack_item_frame_extended");
                encodedTypes = StackMapTableAttr.reallocBuffer(encodedTypes, 1);
                ipos = this.extractVerificationTypes(ipos, 1, 0, encodedTypes);
                this.printVerificationTypes(encodedTypes, 0, 1, dst);
                curStack = 1;
            } else {
                int count;
                if (tag <= 246) {
                    dst.print(" - tag reserved for future use - ");
                    dst.println(tag);
                    break;
                }
                if (tag <= 250) {
                    count = 251 - tag;
                    dst.print(" - chop_frame - undefine ");
                    dst.print(count);
                    dst.println(" locals");
                    curLocals -= count;
                    curStack = 0;
                } else if (tag == 251) {
                    dst.println(" - same_frame_extended");
                    curStack = 0;
                } else if (tag <= 254) {
                    count = tag - 251;
                    dst.print(" - append_frame - define ");
                    dst.print(count);
                    dst.println(" more locals");
                    encodedTypes = StackMapTableAttr.reallocBuffer(encodedTypes, curLocals + count);
                    ipos = this.extractVerificationTypes(ipos, count, curLocals, encodedTypes);
                    this.printVerificationTypes(encodedTypes, curLocals, count, dst);
                    curLocals += count;
                    curStack = 0;
                } else {
                    if (ipos + 1 >= this.dataLength) {
                        ipos = -1;
                        break;
                    }
                    int num_locals = this.u2(ipos);
                    ipos += 2;
                    dst.print(" - full_frame.  Locals count: ");
                    dst.println(num_locals);
                    encodedTypes = StackMapTableAttr.reallocBuffer(encodedTypes, num_locals);
                    ipos = this.extractVerificationTypes(ipos, num_locals, 0, encodedTypes);
                    this.printVerificationTypes(encodedTypes, 0, num_locals, dst);
                    curLocals = num_locals;
                    if (ipos + 1 >= this.dataLength) {
                        ipos = -1;
                        break;
                    }
                    int num_stack = this.u2(ipos);
                    ipos += 2;
                    dst.print("    (end of locals)");
                    int nspaces = Integer.toString(pc_offset).length();
                    while (--nspaces >= 0) {
                        dst.print(' ');
                    }
                    dst.print("       Stack count: ");
                    dst.println(num_stack);
                    encodedTypes = StackMapTableAttr.reallocBuffer(encodedTypes, num_stack);
                    ipos = this.extractVerificationTypes(ipos, num_stack, 0, encodedTypes);
                    this.printVerificationTypes(encodedTypes, 0, num_stack, dst);
                    curStack = num_stack;
                }
            }
            if (ipos >= 0) continue;
            dst.println("<ERROR - missing data>");
            return;
        }
    }
}

