package data_structures;

public interface SortedISR<T> extends LLISR<T>
{

    default void fromArray(T[] arr) { for (T item : arr) { this.insert(item); } }

}
