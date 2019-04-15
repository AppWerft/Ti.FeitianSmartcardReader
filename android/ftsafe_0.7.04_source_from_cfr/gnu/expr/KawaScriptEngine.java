/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.AbstractScriptEngineFactory;
import gnu.expr.Compilation;
import gnu.expr.KawaCompiledScript;
import gnu.expr.KawaScriptBindings;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.mapping.Environment;
import gnu.mapping.SimpleEnvironment;
import gnu.text.SourceError;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

public class KawaScriptEngine
extends AbstractScriptEngine
implements Compilable {
    AbstractScriptEngineFactory factory;

    public KawaScriptEngine(AbstractScriptEngineFactory factory) {
        this.factory = factory;
        this.context.setBindings(this.createBindings(), 100);
        this.context.setReader(InPort.inDefault());
        this.context.setWriter(OutPort.outDefault());
        this.context.setErrorWriter(OutPort.errDefault());
    }

    @Override
    public AbstractScriptEngineFactory getFactory() {
        return this.factory;
    }

    @Override
    public Bindings createBindings() {
        SimpleEnvironment env = new SimpleEnvironment();
        KawaScriptBindings bindings = new KawaScriptBindings(env);
        return bindings;
    }

    @Override
    public Object eval(Reader in, ScriptContext context) throws ScriptException {
        return this.eval(in instanceof InPort ? (InPort)in : new InPort(in), context);
    }

    @Override
    public Object eval(String string, ScriptContext context) throws ScriptException {
        return this.eval(new CharArrayInPort(string), context);
    }

    public Object eval(InPort in, ScriptContext context) throws ScriptException {
        KawaCompiledScript compiled = this.compile(in, context);
        return compiled.eval(context);
    }

    @Override
    public KawaCompiledScript compile(String string) throws ScriptException {
        return this.compile(new CharArrayInPort(string), this.getContext());
    }

    @Override
    public KawaCompiledScript compile(Reader in) throws ScriptException {
        return this.compile(in instanceof InPort ? (InPort)in : new InPort(in), this.getContext());
    }

    public KawaCompiledScript compile(InPort port, ScriptContext context) throws ScriptException {
        SourceMessages messages = new SourceMessages();
        try {
            return this.compile(port, context, messages);
        }
        catch (SyntaxException ex) {
            messages = ex.getMessages();
            SourceError err = messages.getErrors();
            if (messages.seenErrors()) {
                while (err.severity == 'w' && err.next != null) {
                    err = err.next;
                }
            }
            throw new ScriptException(err.message, err.filename, err.line, err.column);
        }
        catch (Exception ex) {
            throw new ScriptException(ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public KawaCompiledScript compile(InPort port, ScriptContext context, SourceMessages messages) throws SyntaxException, IOException {
        Language saveLang = Language.setSaveCurrent(this.factory.language);
        Environment env = this.factory.getEnvironment(context);
        Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            Path portpath;
            Compilation comp = this.factory.language.parse(port, messages, 129);
            if (messages.seenErrors()) {
                throw new SyntaxException(messages);
            }
            ModuleExp mexp = comp.getModule();
            String filename = (String)this.get("javax.script.filename");
            Object url = filename != null ? Path.toURL(filename) : (port instanceof CharArrayInPort ? null : ((portpath = port.getPath()) == null ? null : portpath.toURL()));
            Writer errorWriter = context.getErrorWriter();
            OutPort errorPort = errorWriter instanceof OutPort ? (OutPort)errorWriter : new OutPort(errorWriter);
            Object inst = ModuleExp.evalModule1(env, comp, (URL)url, errorPort);
            KawaCompiledScript kawaCompiledScript = new KawaCompiledScript(this, mexp, inst);
            return kawaCompiledScript;
        }
        finally {
            Language.restoreCurrent(saveLang);
            Environment.restoreCurrent(saveEnv);
        }
    }
}

