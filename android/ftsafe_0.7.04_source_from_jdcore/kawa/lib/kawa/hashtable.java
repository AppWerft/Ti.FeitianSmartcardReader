package kawa.lib.kawa; import gnu.kawa.util.HashNode;

public class hashtable extends gnu.expr.ModuleBody { public static final Class hashtable; public static final gnu.expr.ModuleMethod hashtable$Mncheck$Mnmutable; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let$St; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$do; public static final Class $Prvt$hashnode; public static hashtable $instance;
  static { $Prvt$hashnode = HashNode.class;$instance = new hashtable();$Prvt$let$St = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");$Prvt$do = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "do");hashtable = HashTable.class;hashtable localHashtable = $instance;hashtable$Mncheck$Mnmutable = new gnu.expr.ModuleMethod(localHashtable, 1, Lit0, 4097);$runBody$(); } static final gnu.mapping.SimpleSymbol Lit0 = gnu.mapping.Symbol.valueOf("hashtable-check-mutable");
  





  public class HashTable
    extends gnu.kawa.util.GeneralHashTable
  {
    public gnu.mapping.Procedure hashFunction;
    




    public boolean mutable;
    



    private void $finit$() { mutable = true; }
    
    public HashTable(gnu.mapping.Procedure h, int sz) { super();$finit$();
      
      hashFunction = h; }
    public HashTable(gnu.mapping.Procedure arg2) { $finit$();
      
      hashFunction = h;
    }
    
    public HashTable(boolean mutable)
    {
      this(hashFunction, mutable ? size() + 100 : size());
      putAll(hashtable.this);this.mutable = mutable;
    }
    
    public int hash(Object key) { return ((Number)gnu.mapping.Promise.force(hashFunction.apply1(key))).intValue(); }
    
    public boolean matches(Object value1, Object value2) { return gnu.expr.KawaConvert.isTrue(gnu.mapping.Promise.force(apply2(value1, value2))); }
    
    public void walk(gnu.mapping.Procedure proc) { try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            





























            i >= 0; i--)
        {
          node = table[i];
          



























          proc.apply2(node.getKey(), node.getValue()); } return; } catch (ClassCastException localClassCastException) { int length; throw new gnu.mapping.WrongType(localClassCastException, "table", -2, length); } }
    
    public Object fold(gnu.mapping.Procedure proc, Object acc) { try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            































            i >= 0; i--)
        {
          node = table[i];
          






























          acc = proc.apply3(node.getKey(), node.getValue(), acc); }
        return acc;
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        
          localClassCastException, "table", -2, length); } }
    
    public gnu.lists.FVector keysVector() { gnu.lists.FVector v = new gnu.lists.FVector();
      try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            




































            i >= 0; i--)
        {
          node = table[i];
          



































          v.add(node.getKey()); }
        return v;
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        
          localClassCastException, "table", -2, length); } }
    
    public gnu.lists.Pair entriesVectorPair() { gnu.lists.FVector localFVector1 = new gnu.lists.FVector();
      gnu.lists.FVector vals = new gnu.lists.FVector();
      try { gnu.lists.FVector keys; java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            










































            i >= 0; i--)
        {
          node = table[i];
          









































          keys.add(node.getKey());
          vals.add(node.getValue()); }
        return kawa.lib.lists.cons(keys, vals);
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        

          localClassCastException, "table", -2, length); } }
    
    public Object toAlist() { Object result = gnu.lists.LList.Empty;
      try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            
















































            i >= 0; i--)
        {
          node = table[i];
          

















































          result = kawa.lib.lists.cons(kawa.lib.lists.cons(node.getKey(), node.getValue()), result); }
        return result;
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        


          localClassCastException, "table", -2, length); } }
    
    public gnu.lists.LList toNodeList() { Object result = gnu.lists.LList.Empty;
      try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            























































            i >= 0; i--)
        {
          node = table[i];
          






















































          result = kawa.lib.lists.cons(node, result); }
        return (gnu.lists.LList)gnu.mapping.Promise.force(result, gnu.lists.LList.class);
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        
          localClassCastException, "table", -2, length); } }
    
    public HashNode[] toNodeArray() { int n = size();HashNode[] result = new HashNode[n];int i = 0;
      try {
        java.util.Map.Entry[] arrayOfEntry;
        HashNode[] table = (HashNode[])(arrayOfEntry = this.table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            






























































            i >= 0; i--)
        {
          node = table[i];
          





























































          result[i] = node;
          i++; }
        return result;
      }
      catch (ClassCastException localClassCastException)
      {
        int length;
        throw new gnu.mapping.WrongType(
        

          localClassCastException, "table", -2, length); } }
    
    public void putAll(HashTable other) { try { java.util.Map.Entry[] arrayOfEntry; HashNode[] table = (HashNode[])(arrayOfEntry = table);length = table.length;
        HashNode node;
        HashNode localHashNode1;
        for (int i = length - 1; 
            



































































            i >= 0; i--)
        {
          node = table[i];
          


































































          put(node.getKey(), node.getValue());
        }
        return; } catch (ClassCastException localClassCastException) { int length; throw new gnu.mapping.WrongType(localClassCastException, "table", -2, length); } }
    
    public Object clone() { return new HashTable(this, true); }
  }
  
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { Object tmp18_15 = gnu.mapping.Promise.force(paramObject, HashTable.class);
      






















































































      if (!(tmp18_15 instanceof HashTable)) return -786431; value1 = tmp18_15;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject) { if (selector != 1) {} try { hashtableCheckMutable((HashTable)gnu.mapping.Promise.force(paramObject, HashTable.class));return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "hashtable-check-mutable", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static void hashtableCheckMutable(HashTable ht) { if (!mutable) {
      throw gnu.expr.Special.reachedUnexpected;
    }
  }
  
  public hashtable()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
