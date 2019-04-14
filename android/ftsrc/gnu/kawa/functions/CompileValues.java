package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;

public class CompileValues
{
  public CompileValues() {}
  
  public static Expression validateCallWithValues(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    if (args.length == 2) {
      Expression arg0 = args[0];
      Expression apply = visitor.getCompilation().applyFunction(arg0);
      Expression produce = apply != null ? new ApplyExp(apply, new Expression[] { arg0 }) : new ApplyExp(arg0, Expression.noExpressions);
      
      ApplyExp ae = new ApplyExp(ApplyWithValues.applyWithValues, new Expression[] { produce, args[1] });
      
      ae.setLine(exp);
      return visitor.visit(ae, required);
    }
    exp.visitArgs(visitor);
    return exp;
  }
  
  public static Expression validateApplyWithValues(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    if (args.length == 2) {
      Expression producer = args[0];
      Expression consumer = args[1];
      Type prequired = null;
      boolean singleArgConsumer = false;
      Expression cvalue = consumer;
      if ((cvalue instanceof gnu.expr.ReferenceExp)) {
        gnu.expr.Declaration d = ((gnu.expr.ReferenceExp)cvalue).getBinding();
        cvalue = gnu.expr.Declaration.followAliases(d).getValue();
      }
      if ((cvalue instanceof gnu.expr.LambdaExp)) {
        gnu.expr.LambdaExp lconsumer = (gnu.expr.LambdaExp)cvalue;
        if (min_args == max_args) {
          Type[] types = new Type[min_args];
          int i = 0;
          for (gnu.expr.Declaration param = lconsumer.firstDecl(); 
              param != null; param = param.nextDecl()) {
            boolean typeSpecified = param.getFlag(8192L);
            Type type = param.getFlag(8192L) ? param.getType() : null;
            


            types[(i++)] = type;
          }
          prequired = gnu.kawa.reflect.MultValuesType.create(types);
          singleArgConsumer = min_args == 1;
        }
      } else if ((cvalue instanceof gnu.expr.QuoteExp)) {
        Object rconsumer = cvalue.valueIfConstant();
        if ((rconsumer instanceof gnu.mapping.Procedure)) {
          gnu.mapping.Procedure pconsumer = (gnu.mapping.Procedure)rconsumer;
          if (pconsumer.minArgs() == pconsumer.maxArgs()) {
            Type[] types = new Type[pconsumer.minArgs()];
            if ((pconsumer instanceof gnu.mapping.MethodProc)) {
              gnu.mapping.MethodProc mpconsumer = (gnu.mapping.MethodProc)pconsumer;
              for (int i = 0; i < types.length; i++) {
                types[i] = mpconsumer.getParameterType(i);
              }
            } else {
              for (int i = 0; i < types.length; i++) {
                types[i] = Type.objectType;
              }
            }
            prequired = gnu.kawa.reflect.MultValuesType.create(types);
            singleArgConsumer = pconsumer.minArgs() == 1;
          }
        }
      }
      producer = visitor.visit(producer, prequired);
      if (singleArgConsumer) {
        ApplyExp ae = new ApplyExp(consumer, new Expression[] { producer });
        ae.setLine(exp);
        return visitor.visit(ae, required);
      }
      if (prequired == null) {
        prequired = producer.getType();
      }
      if ((prequired instanceof gnu.kawa.reflect.MultValuesType)) {
        gnu.kawa.reflect.MultValuesType mprequired = (gnu.kawa.reflect.MultValuesType)prequired;
        int nvalues = mprequired.getValueCount();
        Compilation comp = visitor.getCompilation();
        comp.letStart();
        gnu.expr.PrimProcedure incrPosProc = new gnu.expr.PrimProcedure(Compilation.typeValues.getDeclaredMethod("incrPos", 2));
        

        gnu.expr.PrimProcedure getFromPosProc = new gnu.expr.PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPos", 2));
        

        Expression apply = visitor.getCompilation().applyFunction(consumer);
        
        int applyAdjust = apply == null ? 0 : 1;
        Expression[] cargs = new Expression[applyAdjust + nvalues];
        gnu.expr.Declaration valsDecl = comp.letVariable(null, Type.objectType, producer);
        gnu.expr.QuoteExp zero = new gnu.expr.QuoteExp(Integer.valueOf(0), Type.intType);
        gnu.expr.Declaration iposDecl = nvalues == 0 ? null : comp.letVariable(null, Type.intType, zero);
        


        comp.letEnter();
        for (int i = 0; i < nvalues; i++) {
          gnu.expr.SetExp incr = new gnu.expr.SetExp(iposDecl, new ApplyExp(incrPosProc, new Expression[] { new gnu.expr.ReferenceExp(valsDecl), new gnu.expr.ReferenceExp(iposDecl) }));
          



          iposDecl.noteValueFromSet(incr);
          if (i + 1 == nvalues) {
            getFromPosProc = new gnu.expr.PrimProcedure(Compilation.typeValues.getDeclaredMethod("getFromPosFinal", 2));
          }
          
          cargs[(applyAdjust + i)] = new gnu.expr.BeginExp(incr, new ApplyExp(getFromPosProc, new Expression[] { new gnu.expr.ReferenceExp(valsDecl), new gnu.expr.ReferenceExp(iposDecl) }));
        }
        
        Expression callCons;
        
        Expression callCons;
        
        if (applyAdjust == 0) {
          callCons = new ApplyExp(consumer, cargs);
        } else {
          cargs[0] = consumer;
          callCons = new ApplyExp(apply, cargs);
        }
        if (nvalues == 0) {
          gnu.bytecode.Method checkFinalPosMethod = Compilation.typeValues.getDeclaredMethod("checkFinalPos", 2);
          
          callCons = new gnu.expr.BeginExp(new ApplyExp(checkFinalPosMethod, new Expression[] { new gnu.expr.ReferenceExp(valsDecl), zero }), callCons);
        }
        

        return visitor.visit(comp.letDone(callCons), required);
      }
      args[0] = producer;
    }
    exp.visitArgs(visitor);
    return exp;
  }
}
