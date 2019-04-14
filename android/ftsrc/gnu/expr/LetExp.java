package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;



public class LetExp
  extends ScopeExp
{
  Expression body;
  public static final int IS_BODY_SCOPE = 2;
  
  public LetExp() {}
  
  public Expression getBody() { return body; }
  public void setBody(Expression body) { this.body = body; }
  
  protected boolean mustCompile() { return false; }
  
  protected Object evalVariable(Declaration decl, CallContext ctx) throws Throwable
  {
    return decl.getInitValue().eval(ctx);
  }
  
  /* Error */
  public void apply(CallContext ctx)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 5	gnu/expr/LetExp:setIndexes	()V
    //   4: aload_0
    //   5: invokestatic 6	gnu/expr/ScopeExp:nesting	(Lgnu/expr/ScopeExp;)I
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 7	gnu/expr/LetExp:frameSize	I
    //   13: istore_3
    //   14: iload_3
    //   15: anewarray 8	java/lang/Object
    //   18: astore 4
    //   20: aload_1
    //   21: getfield 9	gnu/mapping/CallContext:evalFrames	[[Ljava/lang/Object;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnonnull +21 -> 49
    //   31: iload_2
    //   32: bipush 10
    //   34: iadd
    //   35: anewarray 10	[Ljava/lang/Object;
    //   38: astore 5
    //   40: aload_1
    //   41: aload 5
    //   43: putfield 9	gnu/mapping/CallContext:evalFrames	[[Ljava/lang/Object;
    //   46: goto +40 -> 86
    //   49: iload_2
    //   50: aload 5
    //   52: arraylength
    //   53: if_icmplt +33 -> 86
    //   56: iload_2
    //   57: bipush 10
    //   59: iadd
    //   60: anewarray 10	[Ljava/lang/Object;
    //   63: astore 6
    //   65: aload 5
    //   67: iconst_0
    //   68: aload 6
    //   70: iconst_0
    //   71: aload 5
    //   73: arraylength
    //   74: invokestatic 11	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   77: aload_1
    //   78: aload 6
    //   80: dup
    //   81: astore 5
    //   83: putfield 9	gnu/mapping/CallContext:evalFrames	[[Ljava/lang/Object;
    //   86: aload 5
    //   88: iload_2
    //   89: aaload
    //   90: astore 6
    //   92: aload 5
    //   94: iload_2
    //   95: aload 4
    //   97: aastore
    //   98: iconst_0
    //   99: istore_3
    //   100: aload_0
    //   101: invokevirtual 12	gnu/expr/LetExp:firstDecl	()Lgnu/expr/Declaration;
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull +100 -> 208
    //   111: aload 7
    //   113: invokevirtual 3	gnu/expr/Declaration:getInitValue	()Lgnu/expr/Expression;
    //   116: getstatic 13	gnu/expr/QuoteExp:undefined_exp	Lgnu/expr/QuoteExp;
    //   119: if_acmpne +6 -> 125
    //   122: goto +73 -> 195
    //   125: aload_0
    //   126: aload 7
    //   128: aload_1
    //   129: invokevirtual 14	gnu/expr/LetExp:evalVariable	(Lgnu/expr/Declaration;Lgnu/mapping/CallContext;)Ljava/lang/Object;
    //   132: astore 8
    //   134: aload 7
    //   136: getfield 15	gnu/expr/Declaration:type	Lgnu/bytecode/Type;
    //   139: astore 9
    //   141: aload 9
    //   143: ifnull +20 -> 163
    //   146: aload 9
    //   148: getstatic 16	gnu/bytecode/Type:pointer_type	Lgnu/bytecode/ClassType;
    //   151: if_acmpeq +12 -> 163
    //   154: aload 9
    //   156: aload 8
    //   158: invokevirtual 17	gnu/bytecode/Type:coerceFromObject	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore 8
    //   163: aload 7
    //   165: invokevirtual 18	gnu/expr/Declaration:isIndirectBinding	()Z
    //   168: ifeq +21 -> 189
    //   171: aload 7
    //   173: invokevirtual 19	gnu/expr/Declaration:makeIndirectLocationFor	()Lgnu/mapping/Location;
    //   176: astore 10
    //   178: aload 10
    //   180: aload 8
    //   182: invokevirtual 20	gnu/mapping/Location:set	(Ljava/lang/Object;)V
    //   185: aload 10
    //   187: astore 8
    //   189: aload 4
    //   191: iload_3
    //   192: aload 8
    //   194: aastore
    //   195: aload 7
    //   197: invokevirtual 21	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   200: astore 7
    //   202: iinc 3 1
    //   205: goto -99 -> 106
    //   208: aload_0
    //   209: getfield 2	gnu/expr/LetExp:body	Lgnu/expr/Expression;
    //   212: aload_1
    //   213: invokevirtual 22	gnu/expr/Expression:apply	(Lgnu/mapping/CallContext;)V
    //   216: aload 5
    //   218: iload_2
    //   219: aload 6
    //   221: aastore
    //   222: goto +14 -> 236
    //   225: astore 11
    //   227: aload 5
    //   229: iload_2
    //   230: aload 6
    //   232: aastore
    //   233: aload 11
    //   235: athrow
    //   236: return
    // Line number table:
    //   Java source line #31	-> byte code offset #0
    //   Java source line #32	-> byte code offset #4
    //   Java source line #33	-> byte code offset #9
    //   Java source line #35	-> byte code offset #14
    //   Java source line #36	-> byte code offset #20
    //   Java source line #37	-> byte code offset #26
    //   Java source line #39	-> byte code offset #31
    //   Java source line #40	-> byte code offset #40
    //   Java source line #42	-> byte code offset #49
    //   Java source line #44	-> byte code offset #56
    //   Java source line #45	-> byte code offset #65
    //   Java source line #46	-> byte code offset #77
    //   Java source line #48	-> byte code offset #86
    //   Java source line #49	-> byte code offset #92
    //   Java source line #53	-> byte code offset #98
    //   Java source line #54	-> byte code offset #100
    //   Java source line #57	-> byte code offset #111
    //   Java source line #58	-> byte code offset #122
    //   Java source line #59	-> byte code offset #125
    //   Java source line #60	-> byte code offset #134
    //   Java source line #61	-> byte code offset #141
    //   Java source line #62	-> byte code offset #154
    //   Java source line #63	-> byte code offset #163
    //   Java source line #65	-> byte code offset #171
    //   Java source line #66	-> byte code offset #178
    //   Java source line #67	-> byte code offset #185
    //   Java source line #69	-> byte code offset #189
    //   Java source line #55	-> byte code offset #195
    //   Java source line #71	-> byte code offset #208
    //   Java source line #75	-> byte code offset #216
    //   Java source line #76	-> byte code offset #222
    //   Java source line #75	-> byte code offset #225
    //   Java source line #77	-> byte code offset #236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	LetExp
    //   0	237	1	ctx	CallContext
    //   8	222	2	level	int
    //   13	190	3	i	int
    //   18	172	4	evalFrame	Object[]
    //   24	204	5	evalFrames	Object[][]
    //   63	16	6	newFrames	Object[][]
    //   90	141	6	oldFrame	Object[]
    //   104	97	7	decl	Declaration
    //   132	61	8	value	Object
    //   139	16	9	type	Type
    //   176	10	10	loc	gnu.mapping.Location
    //   225	9	11	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   98	216	225	finally
    //   225	227	225	finally
  }
  
  public void compile(Compilation comp, Target target)
  {
    CodeAttr code = comp.getCode();
    












    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl())
    {

      Expression init = decl.getInitValue();
      boolean initialized = init != QuoteExp.undefined_exp;
      
      boolean needsInit = (!decl.ignorable()) && ((initialized) || (decl.mayBeAccessedUninitialized()));
      

      if ((needsInit) && (decl.isSimple()))
        decl.allocateVariable(code);
      Target varTarget;
      Target varTarget; if ((!needsInit) || ((!initialized) && ((decl.isIndirectBinding()) || (!decl.mayBeAccessedUninitialized()))))
      {

        varTarget = Target.Ignore;
      }
      else {
        Type varType = decl.getType();
        varTarget = CheckedTarget.getInstance(decl);
        if (init == QuoteExp.undefined_exp)
        {

          if ((varType instanceof PrimType)) {
            init = new QuoteExp(new Byte((byte)0));
          } else if ((varType != null) && (varType != Type.pointer_type))
            init = QuoteExp.nullExp;
        }
      }
      init.compileWithPosition(comp, varTarget);
      
      if (needsInit)
      {
        if (decl.isIndirectBinding())
        {
          if (!initialized)
          {
            Object name = decl.getSymbol();
            comp.compileConstant(name, Target.pushObject);
            code.emitInvokeStatic(BindingInitializer.makeLocationMethod(name));
          }
          else
          {
            decl.pushIndirectBinding(comp);
          }
        }
        if (decl.getFlag(549755813888L))
        {
          evalIndex = code.getSP();
        }
        else if ((initialized) || (decl.isIndirectBinding()) || (decl.mayBeAccessedUninitialized()))
        {

          decl.compileStore(comp);
        }
      }
    }
    code.enterScope(getVarScope());
    
    body.compileWithPosition(comp, target);
    popScope(code);
  }
  
  protected final Type calculateType()
  {
    return body.getType();
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitLetExp(this, d);
  }
  
  public <R, D> void visitInitializers(ExpVisitor<R, D> visitor, D d)
  {
    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl())
    {
      decl.setInitValue(visitor.visitAndUpdate(decl.getInitValue(), d));
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    visitInitializers(visitor, d);
    if (exitValue == null) {
      body = visitor.visitAndUpdate(body, d);
    }
  }
  
  public void print(OutPort out) {
    print(out, "(Let", ")");
  }
  
  public void print(OutPort out, String startTag, String endTag)
  {
    out.startLogicalBlock(startTag + "#" + id, endTag, 2);
    out.writeSpaceFill();
    printLineColumn(out);
    out.startLogicalBlock("(", false, ")");
    Declaration decl = firstDecl();
    int i = 0;
    for (; 
        decl != null; decl = decl.nextDecl())
    {
      if (i > 0)
        out.writeSpaceFill();
      out.startLogicalBlock("(", false, ")");
      decl.printInfo(out);
      Expression init = decl.getInitValue();
      if (init != null)
      {
        out.writeSpaceFill();
        out.print('=');
        out.writeSpaceFill();
        



        if (init == null) {
          out.print("<null>");
        } else
          init.print(out);
        i++;
      }
      
      out.endLogicalBlock(")");
    }
    out.endLogicalBlock(")");
    out.writeSpaceLinear();
    if (body == null) {
      out.print("<null body>");
    } else
      body.print(out);
    out.endLogicalBlock(endTag);
  }
}
