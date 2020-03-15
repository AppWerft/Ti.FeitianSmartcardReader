// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.QuoteExp;
import gnu.mapping.Namespace;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.FieldLocation;
import gnu.mapping.NamedLocation;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Named;
import gnu.lists.FString;
import gnu.mapping.Environment;
import gnu.expr.Declaration;
import gnu.mapping.EnvironmentKey;
import kawa.lang.Syntax;
import gnu.expr.Compilation;
import java.lang.reflect.Field;
import gnu.expr.Keyword;
import gnu.expr.Expression;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.kawa.lispexpr.LispLanguage;

public abstract class Lisp2 extends LispLanguage
{
    public static final LList FALSE;
    public static final Symbol TRUE;
    public static final Expression nilExpr;
    
    @Override
    public boolean isTrue(final Object value) {
        return isTrueLisp(value);
    }
    
    public static boolean isTrueLisp(final Object value) {
        return value != Lisp2.FALSE && value != null && (!(value instanceof Boolean) || (boolean)value);
    }
    
    @Override
    public Object booleanObject(final boolean b) {
        return b ? Lisp2.TRUE : Lisp2.FALSE;
    }
    
    @Override
    public Object noValue() {
        return Lisp2.FALSE;
    }
    
    @Override
    public boolean hasSeparateFunctionNamespace() {
        return true;
    }
    
    @Override
    public boolean selfEvaluatingSymbol(final Object obj) {
        return obj instanceof Keyword || obj == Lisp2.TRUE || obj == Lisp2.FALSE;
    }
    
    @Override
    public Object getEnvPropertyFor(final Field fld, final Object value) {
        if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType()) || value instanceof Syntax) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }
    
    @Override
    public int getNamespaceOf(final Declaration decl) {
        if (decl.isAlias()) {
            return 3;
        }
        return decl.getFlag(32896L) ? 2 : 1;
    }
    
    public static Object asSymbol(final String name) {
        if (name == "nil") {
            return Lisp2.FALSE;
        }
        return Environment.getCurrent().getSymbol(name);
    }
    
    @Override
    protected Symbol fromLangSymbol(final Object obj) {
        if (obj == LList.Empty) {
            return this.environ.getSymbol("nil");
        }
        return super.fromLangSymbol(obj);
    }
    
    public static Object getString(final String name) {
        return new FString(name);
    }
    
    public static Object getString(final Symbol symbol) {
        return getString(symbol.getName());
    }
    
    protected void defun(final String name, final Object value) {
        this.environ.define(this.getSymbol(name), EnvironmentKey.FUNCTION, value);
        if (value instanceof Named) {
            final Named n = (Named)value;
            if (n.getName() == null) {
                n.setName(name);
            }
        }
    }
    
    protected void defun(final Symbol sym, final Object value) {
        this.environ.define(sym, EnvironmentKey.FUNCTION, value);
        if (value instanceof Procedure) {
            final Procedure n = (Procedure)value;
            if (n.getSymbol() == null) {
                n.setSymbol(sym);
            }
        }
    }
    
    private void defun(final Procedure proc) {
        this.defun(proc.getName(), proc);
    }
    
    protected void importLocation(Location loc) {
        final Symbol name = ((NamedLocation)loc).getKeySymbol();
        if (this.environ.isBound(name, EnvironmentKey.FUNCTION)) {
            return;
        }
        loc = loc.getBase();
        if (loc instanceof FieldLocation && ((FieldLocation<Object>)loc).isProcedureOrSyntax()) {
            this.environ.addLocation(name, EnvironmentKey.FUNCTION, loc);
        }
        else {
            final Object val;
            if ((val = loc.get(null)) != null) {
                if (val instanceof Procedure || val instanceof Syntax) {
                    this.defun(name, val);
                }
                else if (val instanceof LangObjType) {
                    this.defun(name, ((LangObjType)val).getConstructor());
                }
                else {
                    this.define(name.getName(), val);
                }
            }
        }
    }
    
    @Override
    public ReadTable createReadTable() {
        final ReadTable tab = new Lisp2ReadTable();
        tab.initialize(false);
        tab.setInitialColonIsKeyword(true);
        return tab;
    }
    
    @Override
    public String getCompilationClass() {
        return "gnu.commonlisp.lang.Lisp2Compilation";
    }
    
    static {
        FALSE = LList.Empty;
        TRUE = Namespace.getDefault().getSymbol("t");
        nilExpr = new QuoteExp(Lisp2.FALSE);
    }
}
