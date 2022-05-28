package data_structures.linked_lists;

public class SortedDLL<T> extends DLL<T> implements SortedLLISR<T>
{

    private final SortedKeyComparison keyComp;


    public SortedDLL(SortedKeyComparison keyComparisonFunc) { this.keyComp = keyComparisonFunc; }


    private static class SortedDLLNode<T> extends LLNode<T>
    {
        SortedDLLNode(SortedDLLNode<T> prevNode, T nodeValue, SortedDLLNode<T> nextNode)
        { super(prevNode, nodeValue, nextNode); }
    }


    @Override
    public void insert(T item)
    {
        if (this.isEmpty()) { super.insertFirst(item); return; }
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
