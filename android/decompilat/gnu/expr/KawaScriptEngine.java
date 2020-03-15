// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import javax.script.CompiledScript;
import javax.script.ScriptEngineFactory;
import java.io.IOException;
import java.net.URL;
import gnu.kawa.io.Path;
import gnu.mapping.Environment;
import gnu.text.SourceError;
import gnu.text.SyntaxException;
import gnu.text.SourceMessages;
import gnu.kawa.io.CharArrayInPort;
import javax.script.ScriptException;
import javax.script.ScriptContext;
import gnu.mapping.SimpleEnvironment;
import javax.script.Bindings;
import java.io.Writer;
import gnu.kawa.io.OutPort;
import java.io.Reader;
import gnu.kawa.io.InPort;
import javax.script.Compilable;
import javax.script.AbstractScriptEngine;

public class KawaScriptEngine extends AbstractScriptEngine implements Compilable
{
    AbstractScriptEngineFactory factory;
    
    public KawaScriptEngine(final AbstractScriptEngineFactory factory) {
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
        final SimpleEnvironment env = new SimpleEnvironment();
        final Bindings bindings = new KawaScriptBindings(env);
        return bindings;
    }
    
    @Override
    public Object eval(final Reader in, final ScriptContext context) throws ScriptException {
        return this.eval((in instanceof InPort) ? ((InPort)in) : new InPort(in), context);
    }
    
    @Override
    public Object eval(final String string, final ScriptContext context) throws ScriptException {
        return this.eval(new CharArrayInPort(string), context);
    }
    
    public Object eval(final InPort in, final ScriptContext context) throws ScriptException {
        final KawaCompiledScript compiled = this.compile(in, context);
        return compiled.eval(context);
    }
    
    @Override
    public KawaCompiledScript compile(final String string) throws ScriptException {
        return this.compile(new CharArrayInPort(string), this.getContext());
    }
    
    @Override
    public KawaCompiledScript compile(final Reader in) throws ScriptException {
        return this.compile((in instanceof InPort) ? ((InPort)in) : new InPort(in), this.getContext());
    }
    
    public KawaCompiledScript compile(final InPort port, final ScriptContext context) throws ScriptException {
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
        catch (Exception ex2) {
            throw new ScriptException(ex2);
        }
    }
    
    public KawaCompiledScript compile(final InPort port, final ScriptContext context, final SourceMessages messages) throws SyntaxException, IOException {
        final Language saveLang = Language.setSaveCurrent(this.factory.language);
        final Environment env = this.factory.getEnvironment(context);
        final Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            final Compilation comp = this.factory.language.parse(port, messages, 129);
            if (messages.seenErrors()) {
                throw new SyntaxException(messages);
            }
            final ModuleExp mexp = comp.getModule();
            final String filename = (String)this.get("javax.script.filename");
            URL url;
            if (filename != null) {
                url = Path.toURL(filename);
            }
            else if (port instanceof CharArrayInPort) {
                url = null;
            }
            else {
                final Path portpath = port.getPath();
                url = ((portpath == null) ? null : portpath.toURL());
            }
            final Writer errorWriter = context.getErrorWriter();
            final OutPort errorPort = (OutPort)((errorWriter instanceof OutPort) ? errorWriter : new OutPort(errorWriter));
            final Object inst = ModuleExp.evalModule1(env, comp, url, errorPort);
            return new KawaCompiledScript(this, mexp, inst);
        }
        finally {
            Language.restoreCurrent(saveLang);
            Environment.restoreCurrent(saveEnv);
        }
    }
}
