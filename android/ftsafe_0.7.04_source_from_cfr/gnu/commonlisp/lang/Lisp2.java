/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.bytecode.ClassType;
import gnu.commonlisp.lang.Lisp2ReadTable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.reflect.FieldLocation;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import java.lang.reflect.Field;
import kawa.lang.Syntax;

public abstract class Lisp2
extends LispLanguage {
    public static final LList FALSE = LList.Empty;
    public static final Symbol TRUE = Namespace.getDefault().getSymbol("t");
    public static final Expression nilExpr = new QuoteExp(FALSE);

    @Override
    public boolean isTrue(Object value) {
        return Lisp2.isTrueLisp(value);
    }

    public static boolean isTrueLisp(Object value) {
        return value != FALSE && value != null && (!(value instanceof Boolean) || (Boolean)value != false);
    }

    @Override
    public Object booleanObject(boolean b) {
        return b ? TRUE : FALSE;
    }

    @Override
    public Object noValue() {
        return FALSE;
    }

    @Override
    public boolean hasSeparateFunctionNamespace() {
        return true;
    }

    @Override
    public boolean selfEvaluatingSymbol(Object obj) {
        return obj instanceof Keyword || obj == TRUE || obj == FALSE;
    }

    @Override
    public Object getEnvPropertyFor(Field fld, Object value) {
        if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType()) || value instanceof Syntax) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }

    @Override
    public int getNamespaceOf(Declaration decl) {
        if (decl.isAlias()) {
            return 3;
        }
        return decl.getFlag(32896L) ? 2 : 1;
    }

    public static Object asSymbol(String name) {
        if (name == "nil") {
            return FALSE;
        }
        return Environment.getCurrent().getSymbol(name);
    }

    @Override
    protected Symbol fromLangSymbol(Object obj) {
        if (obj == LList.Empty) {
            return this.environ.getSymbol("nil");
        }
        return super.fromLangSymbol(obj);
    }

    public static Object getString(String name) {
        return new FString(name);
    }

    public static Object getString(Symbol symbol) {
        return Lisp2.getString(symbol.getName());
    }

    protected void defun(String name, Object value) {
        Named n;
        this.environ.define(this.getSymbol(name), EnvironmentKey.FUNCTION, value);
        if (value instanceof Named && (n = (Named)value).getName() == null) {
            n.setName(name);
        }
    }

    protected void defun(Symbol sym, Object value) {
        Procedure n;
        this.environ.define(sym, EnvironmentKey.FUNCTION, value);
        if (value instanceof Procedure && (n = (Procedure)value).getSymbol() == null) {
            n.setSymbol(sym);
        }
    }

    private void defun(Procedure proc) {
        this.defun(proc.getName(), (Object)proc);
    }

    protected void importLocation(Location loc) {
        Symbol name = ((NamedLocation)loc).getKeySymbol();
        if (this.environ.isBound(name, EnvironmentKey.FUNCTION)) {
            return;
        }
        if ((loc = loc.getBase()) instanceof FieldLocation && ((FieldLocation)loc).isProcedureOrSyntax()) {
            this.environ.addLocation(name, EnvironmentKey.FUNCTION, loc);
        } else {
            Object val = loc.get(null);
            if (val != null) {
                if (val instanceof Procedure || val instanceof Syntax) {
                    this.defun(name, val);
                } else if (val instanceof LangObjType) {
                    this.defun(name, (Object)((LangObjType)val).getConstructor());
                } else {
                    this.define(name.getName(), val);
                }
            }
        }
    }

    @Override
    public ReadTable createReadTable() {
        Lisp2ReadTable tab = new Lisp2ReadTable();
        tab.initialize(false);
        tab.setInitialColonIsKeyword(true);
        return tab;
    }

    @Override
    public String getCompilationClass() {
        return "gnu.commonlisp.lang.Lisp2Compilation";
    }
}

