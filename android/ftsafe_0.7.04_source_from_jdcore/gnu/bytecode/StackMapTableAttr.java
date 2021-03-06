package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;


public class StackMapTableAttr
  extends MiscAttr
{
  public static boolean compressStackMapTable = true;
  
  int numEntries;
  
  int prevPosition = -1;
  
  int[] encodedLocals;
  int[] encodedStack;
  int countLocals;
  int countStack;
  
  public StackMapTableAttr()
  {
    super("StackMapTable", null, 0, 0);
    put2(0);
  }
  

  public StackMapTableAttr(byte[] data, CodeAttr code)
  {
    super("StackMapTable", data, 0, data.length);
    addToFrontOf(code);
    numEntries = u2(0);
  }
  
  public Method getMethod() { return ((CodeAttr)container).getMethod(); }
  


  public void write(DataOutputStream dstr)
    throws IOException
  {
    put2(0, numEntries);
    super.write(dstr);
  }
  
  void emitVerificationType(int encoding)
  {
    int tag = encoding & 0xFF;
    put1(tag);
    if (tag >= 7) {
      put2(encoding >> 8);
    }
  }
  
  int encodeVerificationType(Type type, CodeAttr code)
  {
    if (type == null)
      return 0;
    if ((type instanceof UninitializedType))
    {
      UninitializedType utype = (UninitializedType)type;
      Label label = label;
      if (label == null) {
        return 6;
      }
      return position << 8 | 0x8;
    }
    if (type == Type.nullType) {
      return 5;
    }
    
    type = type.getRawType();
    if ((type instanceof PrimType))
    {
      switch (signature.charAt(0)) {
      case 'B': case 'C': case 'I': 
      case 'S': case 'Z': 
        return 1;
      case 'J': 
        return 4;
      case 'F': 
        return 2;
      case 'D': 
        return 3;
      }
      return 0;
    }
    

    return getConstantsaddClassindex << 8 | 0x7;
  }
  





  public void emitStackMapEntry(Label label, CodeAttr code)
  {
    int offset_delta = position - prevPosition - 1;
    int matchingLocals = 0;
    int rawLocalsCount = localTypes.length;
    if (rawLocalsCount > encodedLocals.length)
    {
      int[] tmp = new int[rawLocalsCount + encodedLocals.length];
      System.arraycopy(encodedLocals, 0, tmp, 0, countLocals);
      encodedLocals = tmp;
    }
    int rawStackCount = stackTypes.length;
    if (rawStackCount > encodedStack.length)
    {
      int[] tmp = new int[rawStackCount + encodedStack.length];
      System.arraycopy(encodedStack, 0, tmp, 0, countStack);
      encodedStack = tmp;
    }
    int unchangedLocals = 0;
    int curLocalsCount = 0;
    for (int i = 0; i < rawLocalsCount; i++)
    {
      int prevType = encodedLocals[curLocalsCount];
      int nextType = encodeVerificationType(localTypes[i], code);
      
      if ((prevType == nextType) && (unchangedLocals == curLocalsCount))
        unchangedLocals = curLocalsCount + 1;
      encodedLocals[(curLocalsCount++)] = nextType;
      if ((nextType == 3) || (nextType == 4))
        i++;
    }
    while ((curLocalsCount > 0) && (encodedLocals[(curLocalsCount - 1)] == 0))
      curLocalsCount--;
    int curStackCount = 0;
    for (int i = 0; i < rawStackCount; i++)
    {
      int prevType = encodedStack[curStackCount];
      Type t = stackTypes[i];
      if (t == Type.voidType)
        t = stackTypes[(++i)];
      int nextType = encodeVerificationType(t, code);
      encodedStack[(curStackCount++)] = nextType;
    }
    int localsDelta = curLocalsCount - countLocals;
    if ((compressStackMapTable) && (localsDelta == 0) && (curLocalsCount == unchangedLocals) && (curStackCount <= 1))
    {

      if (curStackCount == 0)
      {
        if (offset_delta <= 63) {
          put1(offset_delta);
        }
        else {
          put1(251);
          put2(offset_delta);
        }
      }
      else
      {
        if (offset_delta <= 63) {
          put1(64 + offset_delta);
        }
        else {
          put1(247);
          put2(offset_delta);
        }
        emitVerificationType(encodedStack[0]);
      }
    }
    else if ((compressStackMapTable) && (curStackCount == 0) && (curLocalsCount < countLocals) && (unchangedLocals == curLocalsCount) && (localsDelta >= -3))
    {



      put1(251 + localsDelta);
      put2(offset_delta);
    }
    else if ((compressStackMapTable) && (curStackCount == 0) && (countLocals == unchangedLocals) && (localsDelta <= 3))
    {


      put1(251 + localsDelta);
      put2(offset_delta);
      for (int i = 0; i < localsDelta; i++) {
        emitVerificationType(encodedLocals[(unchangedLocals + i)]);
      }
    }
    else {
      put1(255);
      put2(offset_delta);
      put2(curLocalsCount);
      for (int i = 0; i < curLocalsCount; i++)
        emitVerificationType(encodedLocals[i]);
      put2(curStackCount);
      for (int i = 0; i < curStackCount; i++)
        emitVerificationType(encodedStack[i]);
    }
    countLocals = curLocalsCount;
    countStack = curStackCount;
    prevPosition = position;
    numEntries += 1;
  }
  
  void printVerificationType(int encoding, ClassTypeWriter dst)
  {
    int tag = encoding & 0xFF;
    switch (tag)
    {
    case 0: 
      dst.print("top/unavailable");
      break;
    case 1: 
      dst.print("integer");
      break;
    case 2: 
      dst.print("float");
      break;
    case 3: 
      dst.print("double");
      break;
    case 4: 
      dst.print("long");
      break;
    case 5: 
      dst.print("null");
      break;
    case 6: 
      dst.print("uninitialized this");
      break;
    case 7: 
      int index = encoding >> 8;
      dst.printOptionalIndex(index);
      dst.printConstantTersely(index, 7);
      break;
    case 8: 
      int offset = encoding >> 8;
      dst.print("uninitialized object created at ");
      dst.print(offset);
      break;
    default: 
      dst.print("<bad verification type tag " + tag + '>');
    }
    
  }
  



  int extractVerificationType(int startOffset, int tag)
  {
    if ((tag == 7) || (tag == 8))
    {
      int value = u2(startOffset + 1);
      tag |= value << 8;
    }
    return tag;
  }
  
  static int[] reallocBuffer(int[] buffer, int needed)
  {
    if (buffer == null) {
      buffer = new int[needed + 10];
    } else if (needed > buffer.length)
    {
      int[] tmp = new int[needed + 10];
      System.arraycopy(buffer, 0, tmp, 0, buffer.length);
      buffer = tmp;
    }
    return buffer;
  }
  

  int extractVerificationTypes(int startOffset, int count, int startIndex, int[] buffer)
  {
    int offset = startOffset;
    for (;;) { count--; if (count < 0) break;
      int encoding;
      int encoding;
      if (offset >= dataLength) {
        encoding = -1;
      }
      else {
        int tag = data[offset];
        encoding = extractVerificationType(offset, tag);
        offset += ((tag == 7) || (tag == 8) ? 3 : 1);
      }
      buffer[(startIndex++)] = encoding;
    }
    return offset;
  }
  





  void printVerificationTypes(int[] encodings, int startIndex, int count, ClassTypeWriter dst)
  {
    int regno = 0;
    for (int i = 0; i < startIndex + count; i++)
    {
      int encoding = encodings[i];
      int tag = encoding & 0xFF;
      if (i >= startIndex)
      {
        dst.print("  ");
        if (regno < 100)
        {


          if (regno < 10)
            dst.print(' ');
          dst.print(' ');
        }
        dst.print(regno);
        dst.print(": ");
        printVerificationType(encoding, dst);
        dst.println();
      }
      regno++;
      if ((tag == 3) || (tag == 4)) {
        regno++;
      }
    }
  }
  
  public void print(ClassTypeWriter dst) {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", number of entries: ");
    dst.println(numEntries);
    int ipos = 2;
    int pc_offset = -1;
    Method method = getMethod();
    int[] encodedTypes = null;
    int curLocals = (method.getStaticFlag() ? 0 : 1) + arg_types.length;
    int curStack = 0;
    for (int i = 0; i < numEntries; i++)
    {
      if (ipos >= dataLength)
      {
        i = -1;
        break;
      }
      int tag = u1(ipos++);
      pc_offset++;
      int delta = -1;
      if (tag <= 127) {
        pc_offset += (tag & 0x3F);
      } else { if (ipos + 1 >= dataLength)
        {
          ipos = -1;
          break;
        }
        

        delta = u2(ipos);
        pc_offset += delta;
        ipos += 2;
      }
      dst.print("  offset: ");
      dst.print(pc_offset);
      if (tag <= 63)
      {
        dst.println(" - same_frame");
        curStack = 0;
      }
      else if ((tag <= 127) || (tag == 247))
      {
        dst.println(tag <= 127 ? " - same_locals_1_stack_item_frame" : " - same_locals_1_stack_item_frame_extended");
        
        encodedTypes = reallocBuffer(encodedTypes, 1);
        ipos = extractVerificationTypes(ipos, 1, 0, encodedTypes);
        printVerificationTypes(encodedTypes, 0, 1, dst);
        curStack = 1;
      } else {
        if (tag <= 246)
        {
          dst.print(" - tag reserved for future use - ");
          dst.println(tag);
          break;
        }
        if (tag <= 250)
        {
          int count = 251 - tag;
          dst.print(" - chop_frame - undefine ");
          dst.print(count);
          dst.println(" locals");
          curLocals -= count;
          curStack = 0;
        }
        else if (tag == 251)
        {
          dst.println(" - same_frame_extended");
          curStack = 0;
        }
        else if (tag <= 254)
        {
          int count = tag - 251;
          dst.print(" - append_frame - define ");
          dst.print(count);
          dst.println(" more locals");
          encodedTypes = reallocBuffer(encodedTypes, curLocals + count);
          ipos = extractVerificationTypes(ipos, count, curLocals, encodedTypes);
          printVerificationTypes(encodedTypes, curLocals, count, dst);
          curLocals += count;
          curStack = 0;
        }
        else
        {
          if (ipos + 1 >= dataLength)
          {
            ipos = -1;
            break;
          }
          int num_locals = u2(ipos);
          ipos += 2;
          dst.print(" - full_frame.  Locals count: ");
          dst.println(num_locals);
          encodedTypes = reallocBuffer(encodedTypes, num_locals);
          ipos = extractVerificationTypes(ipos, num_locals, 0, encodedTypes);
          printVerificationTypes(encodedTypes, 0, num_locals, dst);
          curLocals = num_locals;
          if (ipos + 1 >= dataLength)
          {
            ipos = -1;
            break;
          }
          int num_stack = u2(ipos);
          ipos += 2;
          dst.print("    (end of locals)");
          
          int nspaces = Integer.toString(pc_offset).length();
          for (;;) { nspaces--; if (nspaces < 0) break;
            dst.print(' '); }
          dst.print("       Stack count: ");
          dst.println(num_stack);
          encodedTypes = reallocBuffer(encodedTypes, num_stack);
          ipos = extractVerificationTypes(ipos, num_stack, 0, encodedTypes);
          printVerificationTypes(encodedTypes, 0, num_stack, dst);
          curStack = num_stack;
        } }
      if (ipos < 0)
      {
        dst.println("<ERROR - missing data>");
        return;
      }
    }
  }
}
