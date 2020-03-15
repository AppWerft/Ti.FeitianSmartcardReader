// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Procedure;
import gnu.bytecode.Variable;
import java.lang.reflect.Type;

public interface TypeValue extends Type
{
    gnu.bytecode.Type getImplementationType();
    
    void emitTestIf(final Variable p0, final Declaration p1, final Compilation p2);
    
    void emitIsInstance(final Variable p0, final Compilation p1, final Target p2);
    
    Procedure getConstructor();
    
    Expression convertValue(final Expression p0);
    
    String encodeType(final Language p0);
}
