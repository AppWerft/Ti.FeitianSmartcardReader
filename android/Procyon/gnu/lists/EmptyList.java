// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class EmptyList extends LList
{
    public static final EmptyList emptyList;
    
    private EmptyList() {
    }
    
    static {
        emptyList = new EmptyList();
    }
}
