package data_structures;

abstract public class BaseNode<T>
{
    T value;

    @Override
    public String toString()
    {
       return String.format("BaseNode[%s]", value.toString());
    }
}
