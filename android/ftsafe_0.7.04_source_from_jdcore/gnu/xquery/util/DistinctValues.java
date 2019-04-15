package gnu.xquery.util;

import gnu.mapping.CallContext;
import gnu.mapping.Values;



public class DistinctValues
{
  public DistinctValues() {}
  
  public static void distinctValues$X(Object values, NamedCollator coll, CallContext ctx)
  {
    DistinctValuesConsumer out = new DistinctValuesConsumer(coll, consumer);
    
    Values.writeValues(values, out);
  }
}
