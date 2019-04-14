package gnu.bytecode;

public abstract interface Filter<T>
{
  public abstract boolean select(T paramT);
}
