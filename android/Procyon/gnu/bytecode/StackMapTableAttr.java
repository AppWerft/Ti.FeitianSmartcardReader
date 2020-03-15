// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class StackMapTableAttr extends MiscAttr
{
    public static boolean compressStackMapTable;
    int numEntries;
    int prevPosition;
    int[] encodedLocals;
    int[] encodedStack;
    int countLocals;
    int countStack;
    
    public StackMapTableAttr() {
        super("StackMapTable", null, 0, 0);
        this.prevPosition = -1;
        this.put2(0);
    }
    
    public StackMapTableAttr(final byte[] data, final CodeAttr code) {
        super("StackMapTable", data, 0, data.length);
        this.prevPosition = -1;
        this.addToFrontOf(code);
        this.numEntries = this.u2(0);
    }
    
    public Method getMethod() {
        return ((CodeAttr)this.container).getMethod();
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        this.put2(0, this.numEntries);
        super.write(dstr);
    }
    
    void emitVerificationType(final int encoding) {
        final int tag = encoding & 0xFF;
        this.put1(tag);
        if (tag >= 7) {
            this.put2(encoding >> 8);
        }
    }
    
    int encodeVerificationType(Type type, final CodeAttr code) {
        if (type == null) {
            return 0;
        }
        if (type instanceof UninitializedType) {
            final UninitializedType utype = (UninitializedType)type;
            final Label label = utype.label;
            if (label == null) {
                return 6;
            }
            return label.position << 8 | 0x8;
        }
        else {
            if (type == Type.nullType) {
                return 5;
            }
            type = type.getRawType();
            if (!(type instanceof PrimType)) {
                return code.getConstants().addClass((ObjectType)type).index << 8 | 0x7;
            }
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
                default: {
                    return 0;
                }
            }
        }
    }
    
    public void emitStackMapEntry(final Label label, final CodeAttr code) {
        final int offset_delta = label.position - this.prevPosition - 1;
        final int matchingLocals = 0;
        final int rawLocalsCount = label.localTypes.length;
        if (rawLocalsCount > this.encodedLocals.length) {
            final int[] tmp = new int[rawLocalsCount + this.encodedLocals.length];
            System.arraycopy(this.encodedLocals, 0, tmp, 0, this.countLocals);
            this.encodedLocals = tmp;
        }
        final int rawStackCount = label.stackTypes.length;
        if (rawStackCount > this.encodedStack.length) {
            final int[] tmp2 = new int[rawStackCount + this.encodedStack.length];
            System.arraycopy(this.encodedStack, 0, tmp2, 0, this.countStack);
            this.encodedStack = tmp2;
        }
        int unchangedLocals = 0;
        int curLocalsCount = 0;
        for (int i = 0; i < rawLocalsCount; ++i) {
            final int prevType = this.encodedLocals[curLocalsCount];
            final int nextType = this.encodeVerificationType(label.localTypes[i], code);
            if (prevType == nextType && unchangedLocals == curLocalsCount) {
                unchangedLocals = curLocalsCount + 1;
            }
            if ((this.encodedLocals[curLocalsCount++] = nextType) == 3 || nextType == 4) {
                ++i;
            }
        }
        while (curLocalsCount > 0 && this.encodedLocals[curLocalsCount - 1] == 0) {
            --curLocalsCount;
        }
        int curStackCount = 0;
        for (int j = 0; j < rawStackCount; ++j) {
            final int prevType2 = this.encodedStack[curStackCount];
            Type t = label.stackTypes[j];
            if (t == Type.voidType) {
                t = label.stackTypes[++j];
            }
            final int nextType2 = this.encodeVerificationType(t, code);
            this.encodedStack[curStackCount++] = nextType2;
        }
        final int localsDelta = curLocalsCount - this.countLocals;
        if (StackMapTableAttr.compressStackMapTable && localsDelta == 0 && curLocalsCount == unchangedLocals && curStackCount <= 1) {
            if (curStackCount == 0) {
                if (offset_delta <= 63) {
                    this.put1(offset_delta);
                }
                else {
                    this.put1(251);
                    this.put2(offset_delta);
                }
            }
            else {
                if (offset_delta <= 63) {
                    this.put1(64 + offset_delta);
                }
                else {
                    this.put1(247);
                    this.put2(offset_delta);
                }
                this.emitVerificationType(this.encodedStack[0]);
            }
        }
        else if (StackMapTableAttr.compressStackMapTable && curStackCount == 0 && curLocalsCount < this.countLocals && unchangedLocals == curLocalsCount && localsDelta >= -3) {
            this.put1(251 + localsDelta);
            this.put2(offset_delta);
        }
        else if (StackMapTableAttr.compressStackMapTable && curStackCount == 0 && this.countLocals == unchangedLocals && localsDelta <= 3) {
            this.put1(251 + localsDelta);
            this.put2(offset_delta);
            for (int k = 0; k < localsDelta; ++k) {
                this.emitVerificationType(this.encodedLocals[unchangedLocals + k]);
            }
        }
        else {
            this.put1(255);
            this.put2(offset_delta);
            this.put2(curLocalsCount);
            for (int k = 0; k < curLocalsCount; ++k) {
                this.emitVerificationType(this.encodedLocals[k]);
            }
            this.put2(curStackCount);
            for (int k = 0; k < curStackCount; ++k) {
                this.emitVerificationType(this.encodedStack[k]);
            }
        }
        this.countLocals = curLocalsCount;
        this.countStack = curStackCount;
        this.prevPosition = label.position;
        ++this.numEntries;
    }
    
    void printVerificationType(final int encoding, final ClassTypeWriter dst) {
        final int tag = encoding & 0xFF;
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
                final int index = encoding >> 8;
                dst.printOptionalIndex(index);
                dst.printConstantTersely(index, 7);
                break;
            }
            case 8: {
                final int offset = encoding >> 8;
                dst.print("uninitialized object created at ");
                dst.print(offset);
                break;
            }
            default: {
                dst.print("<bad verification type tag " + tag + '>');
                break;
            }
        }
    }
    
    int extractVerificationType(final int startOffset, int tag) {
        if (tag == 7 || tag == 8) {
            final int value = this.u2(startOffset + 1);
            tag |= value << 8;
        }
        return tag;
    }
    
    static int[] reallocBuffer(int[] buffer, final int needed) {
        if (buffer == null) {
            buffer = new int[needed + 10];
        }
        else if (needed > buffer.length) {
            final int[] tmp = new int[needed + 10];
            System.arraycopy(buffer, 0, tmp, 0, buffer.length);
            buffer = tmp;
        }
        return buffer;
    }
    
    int extractVerificationTypes(final int startOffset, int count, int startIndex, final int[] buffer) {
        int offset = startOffset;
        while (--count >= 0) {
            int encoding;
            if (offset >= this.dataLength) {
                encoding = -1;
            }
            else {
                final int tag = this.data[offset];
                encoding = this.extractVerificationType(offset, tag);
                offset += ((tag == 7 || tag == 8) ? 3 : 1);
            }
            buffer[startIndex++] = encoding;
        }
        return offset;
    }
    
    void printVerificationTypes(final int[] encodings, final int startIndex, final int count, final ClassTypeWriter dst) {
        int regno = 0;
        for (int i = 0; i < startIndex + count; ++i) {
            final int encoding = encodings[i];
            final int tag = encoding & 0xFF;
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
            if (tag == 3 || tag == 4) {
                ++regno;
            }
        }
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", number of entries: ");
        dst.println(this.numEntries);
        int ipos = 2;
        int pc_offset = -1;
        final Method method = this.getMethod();
        int[] encodedTypes = null;
        int curLocals = (method.getStaticFlag() ? 0 : 1) + method.arg_types.length;
        int curStack = 0;
        for (int i = 0; i < this.numEntries; ++i) {
            if (ipos >= this.dataLength) {
                i = -1;
                break;
            }
            final int tag = this.u1(ipos++);
            ++pc_offset;
            int delta = -1;
            if (tag <= 127) {
                pc_offset += (tag & 0x3F);
            }
            else {
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
            }
            else if (tag <= 127 || tag == 247) {
                dst.println((tag <= 127) ? " - same_locals_1_stack_item_frame" : " - same_locals_1_stack_item_frame_extended");
                encodedTypes = reallocBuffer(encodedTypes, 1);
                ipos = this.extractVerificationTypes(ipos, 1, 0, encodedTypes);
                this.printVerificationTypes(encodedTypes, 0, 1, dst);
                curStack = 1;
            }
            else {
                if (tag <= 246) {
                    dst.print(" - tag reserved for future use - ");
                    dst.println(tag);
                    break;
                }
                if (tag <= 250) {
                    final int count = 251 - tag;
                    dst.print(" - chop_frame - undefine ");
                    dst.print(count);
                    dst.println(" locals");
                    curLocals -= count;
                    curStack = 0;
                }
                else if (tag == 251) {
                    dst.println(" - same_frame_extended");
                    curStack = 0;
                }
                else if (tag <= 254) {
                    final int count = tag - 251;
                    dst.print(" - append_frame - define ");
                    dst.print(count);
                    dst.println(" more locals");
                    encodedTypes = reallocBuffer(encodedTypes, curLocals + count);
                    ipos = this.extractVerificationTypes(ipos, count, curLocals, encodedTypes);
                    this.printVerificationTypes(encodedTypes, curLocals, count, dst);
                    curLocals += count;
                    curStack = 0;
                }
                else {
                    if (ipos + 1 >= this.dataLength) {
                        ipos = -1;
                        break;
                    }
                    final int num_locals = this.u2(ipos);
                    ipos += 2;
                    dst.print(" - full_frame.  Locals count: ");
                    dst.println(num_locals);
                    encodedTypes = reallocBuffer(encodedTypes, num_locals);
                    ipos = this.extractVerificationTypes(ipos, num_locals, 0, encodedTypes);
                    this.printVerificationTypes(encodedTypes, 0, num_locals, dst);
                    curLocals = num_locals;
                    if (ipos + 1 >= this.dataLength) {
                        ipos = -1;
                        break;
                    }
                    final int num_stack = this.u2(ipos);
                    ipos += 2;
                    dst.print("    (end of locals)");
                    int nspaces = Integer.toString(pc_offset).length();
                    while (--nspaces >= 0) {
                        dst.print(' ');
                    }
                    dst.print("       Stack count: ");
                    dst.println(num_stack);
                    encodedTypes = reallocBuffer(encodedTypes, num_stack);
                    ipos = this.extractVerificationTypes(ipos, num_stack, 0, encodedTypes);
                    this.printVerificationTypes(encodedTypes, 0, num_stack, dst);
                    curStack = num_stack;
                }
            }
            if (ipos < 0) {
                dst.println("<ERROR - missing data>");
                return;
            }
        }
    }
    
    static {
        StackMapTableAttr.compressStackMapTable = true;
    }
}
