package gnu.kawa.android; import gnu.bytecode.ClassType;

public class ViewBuilder extends gnu.kawa.reflect.CompileBuildObject { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static ClassType activityType;
  public static final Class ViewBuilder;
  static final gnu.mapping.SimpleSymbol Lit0; static { Lit0 = gnu.mapping.Symbol.valueOf("current-activity");ViewBuilder.frame.$instance = new ViewBuilder.frame();ViewBuilder = ViewBuilder.class;activityType = ClassType.make("android.app.Activity");$runBody$(); } static final ClassType Lit1 = ClassType.make("android.app.Activity");
  public boolean hasAddChildMethod() { return true; }
  
  public String getAddChildMethodName() { return "addView"; }
  
  public boolean useBuilder(int numCode, gnu.expr.InlineCalls visitor) { boolean x = getArgCount() < 2; int cmp; if (x) { if (!x) break label121;
    } else { gnu.expr.Expression arg1 = visitor.visit(getArg(1), null);
      gnu.bytecode.Type type1 = arg1.getType();
      cmp = activityType.compare(type1);
      setArg(1, arg1);
    }
    gnu.expr.Declaration activity$Mndecl = getCompilation().getModule().lookup(Lit0);
    



    insertArgument(1, visitor.visit(gnu.expr.Compilation.makeCoercion(new gnu.expr.ApplyExp(new gnu.expr.ReferenceExp(activity$Mndecl), new gnu.expr.Expression[0]), Lit1), null));
    
    label121:
    return cmp < 0 ? true : super.useBuilder(numCode, visitor);
  }
  
  public ViewBuilder() {}
}
