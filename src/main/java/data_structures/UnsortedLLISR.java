package data_structures;

public interface UnsortedLLISR<T> extends LLISR<T>
{

    void append(T item);

    void prepend(T item);

    void insertAt(T item, LLIterator<T> loc);

    default T set(Integer index, T item)
    {
        LLIterator<T> itr = (LLIterator<T>) this.iterator();
        int i = 0;
        while (itr.hasNext() && i < index)
        {
            itr.next();
            i++;
        }
        T oldValue = itr.next.value;
        itr.next.value = item;
        return oldValue;
    }

    default void fromArray(T[] arr) { for (T item : arr) { this.append(item); } }

}
