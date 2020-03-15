// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

class BlockExitException extends RuntimeException
{
    ExitExp exit;
    Object result;
    
    public BlockExitException(final ExitExp exit, final Object result) {
        this.exit = exit;
        this.result = result;
    }
}
