package gnu.expr;

import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.kawa.util.WeakIdentityHashMap;
import gnu.mapping.Environment;
import java.util.List;




public class NameLookup
  extends GeneralHashTable<Object, Declaration>
{
  Language language;
  private static WeakIdentityHashMap<Environment, NameLookup> instanceMap;
  
  public Language getLanguage() { return language; }
  public void setLanguage(Language language) { this.language = language; }
  
  public NameLookup(Language language)
  {
    this.language = language;
  }
  







  public static synchronized NameLookup getInstance(Environment env, Language language)
  {
    if (instanceMap == null)
      instanceMap = new WeakIdentityHashMap();
    NameLookup nl = (NameLookup)instanceMap.get(env);
    if (nl == null) {
      nl = new NameLookup(language);
      instanceMap.put(env, nl);
    }
    else {
      nl.setLanguage(language); }
    return nl;
  }
  
  public static synchronized void setInstance(Environment env, NameLookup instance)
  {
    if (instanceMap == null)
      instanceMap = new WeakIdentityHashMap();
    if (instance == null) {
      instanceMap.remove(env);
    } else {
      instanceMap.put(env, instance);
    }
  }
  






  public boolean doSaveTopLevelRedefs() { return saveToplevelsRedefsCount > 0; }
  public void pushSaveTopLevelRedefs() { saveToplevelsRedefsCount += 1; }
  public void popSaveTopLevelRedefs() { saveToplevelsRedefsCount -= 1; }
  int saveToplevelsRedefsCount = 0;
  
  public void push(Declaration decl)
  {
    Object symbol = decl.getSymbol();
    if (symbol == null)
      return;
    if (++num_bindings >= ((HashNode[])table).length)
      rehash();
    int hash = hash(symbol);
    HashNode<Object, Declaration> node = makeEntry(symbol, hash, decl);
    int index = hashToIndex(hash);
    if (((decl.getContext() instanceof ModuleExp)) && (!doSaveTopLevelRedefs()))
    {

      int dnamespace = language.getNamespaceOf(decl);
      HashNode<Object, Declaration> prevNode = null;
      HashNode<Object, Declaration> oldNode = ((HashNode[])table)[index];
      while (oldNode != null)
      {
        Declaration oldDecl = (Declaration)oldNode.getValue();
        HashNode<Object, Declaration> oldNext = next;
        if ((oldDecl != null) && (decl.getSymbol() == oldDecl.getSymbol()) && ((oldDecl.getContext() instanceof ModuleExp)) && (decl.getContext() != oldDecl.getContext()) && (dnamespace == language.getNamespaceOf(oldDecl)))
        {




          if (prevNode == null) {
            ((HashNode[])table)[index] = oldNext;
          } else
            next = oldNext;
          num_bindings -= 1;
          break;
        }
        prevNode = oldNode;
        oldNode = oldNext;
      }
    }
    next = ((HashNode[])table)[index];
    ((HashNode[])table)[index] = node;
  }
  
  public boolean pop(Declaration decl)
  {
    Object symbol = decl.getSymbol();
    if (symbol == null)
      return false;
    int hash = hash(symbol);
    HashNode prev = null;
    int index = hashToIndex(hash);
    HashNode node = ((HashNode[])table)[index];
    while (node != null)
    {
      HashNode next = next;
      if (node.getValue() == decl)
      {
        if (prev == null) {
          ((HashNode[])table)[index] = next;
        } else
          next = next;
        num_bindings -= 1;
        return true;
      }
      prev = node;
      node = next;
    }
    return false;
  }
  
  public void push(ScopeExp exp)
  {
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      push(decl);
    }
  }
  
  public void pop(ScopeExp exp) {
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      pop(decl);
    }
  }
  


  public void removeSubsumed(Declaration decl)
  {
    Object symbol = decl.getSymbol();
    int hash = hash(symbol);
    int index = hashToIndex(hash);
    HashNode prev = null;
    for (HashNode node = ((HashNode[])table)[index]; node != null;)
    {
      HashNode next = next;
      Declaration ndecl = (Declaration)node.getValue();
      if ((ndecl != decl) && (subsumedBy(decl, ndecl)))
      {
        if (prev == null) {
          ((HashNode[])table)[index] = next;
        } else {
          next = next;
        }
      } else
        prev = node;
      node = next;
    }
  }
  

  protected boolean subsumedBy(Declaration decl, Declaration other)
  {
    return (decl.getSymbol() == other.getSymbol()) && ((language.getNamespaceOf(decl) & language.getNamespaceOf(other)) != 0);
  }
  

  public Declaration lookup(Object symbol, int namespace)
  {
    int hash = hash(symbol);
    int index = hashToIndex(hash);
    for (HashNode node = ((HashNode[])table)[index]; 
        node != null; node = next)
    {
      Declaration decl = (Declaration)node.getValue();
      if ((symbol.equals(decl.getSymbol())) && (language.hasNamespace(decl, namespace)))
      {
        return decl; }
    }
    return null;
  }
  
  public Declaration lookup(Object symbol, boolean function)
  {
    return lookup(symbol, function ? 2 : 1);
  }
  

  public void getCompletingSymbols(String initialPart, int namespace, List<? super String> candidates)
  {
    int index = ((HashNode[])table).length; for (;;) { index--; if (index < 0) break;
      for (HashNode node = ((HashNode[])table)[index]; 
          node != null; node = next) {
        Declaration decl = (Declaration)node.getValue();
        String symbol = decl.getSymbol().toString();
        if ((symbol.startsWith(initialPart)) && (language.hasNamespace(decl, namespace)))
        {
          candidates.add(symbol);
        }
      }
    }
  }
}
