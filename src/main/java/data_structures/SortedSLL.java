package data_structures;

import java.util.NoSuchElementException;

public class SortedSLL<T> implements SortedISR<T>
{

    public SortedSLL(SortedKeyComparison keyComparisonFunc)
    {
        this.keyComp = keyComparisonFunc;
    }

    private static class SortedSLLNode<T> extends LLNode<T>
    {

        SortedSLLNode(T nodeValue, SortedSLLNode<T> nextNode) { super(nodeValue, nextNode); }

    }

    private SortedSLLNode<T> head, tail;

    private int size = 0;

    public interface SortedKeyComparison { float compare(float xKey, float yKey); }

    private final SortedKeyComparison keyComp;

    private boolean checkFirst(T item)
    {
        if (this.isEmpty())
        {
            insertFirst(item);
            return true;
        }
        return false;
    }

    private void insertFirst(T item)
    {
        this.tail = new SortedSLLNode<>(item, null);
        this.head = new SortedSLLNode<>(null, this.tail);
        size++;
    }


    @Override
    public LLIterator<T> iterator() { return new LLIterator<>(this.head); }


    @Override
    public void insert(T item)
    {
        if (this.checkFirst(item)) return;
        LLIterator<T> itr = this.iterator();
        while (itr.hasNext())
        {
            float comp = itr.next == null ? 0 : keyComp.compare(itr.next.hashCode(), item.hashCode());
            if (comp >= 1)
            {
                break;
            }
            itr.next();
        }
        insertAt(item, itr);
    }


    private void insertAt(T item, LLIterator<T> loc)
    {
        if (this.checkFirst(item)) return;
        boolean isNewHead = loc.prev.value == null;
        boolean isNewTail = loc.prev.next == null;
        SortedSLLNode<T> node = new SortedSLLNode<>(item, (SortedSLLNode<T>) loc.prev.next);
        if (isNewHead)
        {
            this.head.next = node;
        }
        else if (isNewTail)
        {
            loc.prev.next = this.tail = node;
        }
        else
        {
            loc.prev.next = node;
        }
        size++;
    }


    @Override
    public T head() { return this.headNode().value; }


    @Override
    public T tail() { return this.tailNode().value; }


    @Override
    public T remove(T item)
    {
        LLIterator<T> loc = find(item);
        if (loc.prev.value == null) { this.head.next = loc.next.next; }
        if (loc.next.next == null) { this.tail = (SortedSLLNode<T>) loc.prev; }
        loc.prev.next = loc.next.next;
        size--;
        return item;
    }


    @Override
    public int size() { return size; }


    @Override
    public boolean contains(T item)
    {
        try { if (this.find(item) != null) return true; }
        catch (NoSuchElementException e) { return false; }
        return false;
    }


    @Override
    public boolean isEmpty() { return size == 0; }


    @Override
    public LLNode<T> headNode()
    {
        return this.head.next;
    }


    @Override
    public LLNode<T> tailNode() { return this.tail; }

    @Override
    public String toString() { return this.stringify(); }

}
