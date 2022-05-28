
package data_structures.linked_lists;

public class SortedSLL<T> extends SLL<T> implements SortedLLISR<T>
{

    private final SortedKeyComparison keyComp;

    public SortedSLL(SortedKeyComparison keyComparisonFunc)
    {
        this.keyComp = keyComparisonFunc;
    }

    @Override
    public void insert(T item)
    {
        if (super.checkFirst(item)) return;
        LLIterator<T> itr = this.iterator();
        while (itr.hasNext())
        {
            float comp = itr.next == null ? 0 : keyComp.compare(itr.next.hashCode(), item.hashCode());
            if (comp >= 1) { break; }
            itr.next();
        }
        insertAt(item, itr);
    }


    @Override
    public void append(T item) { throw new UnsupportedOperationException(); }


    @Override
    public void prepend(T item) { throw new UnsupportedOperationException(); }


    @Override
    public T set(Integer index, T item) { throw new UnsupportedOperationException(); }


    @Override
    public void fromArray(T[] arr) { for (T item : arr) { this.insert(item); } }

}