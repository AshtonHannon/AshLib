package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLL<T> implements LinkedListISR<T>, Iterable<T>
{

    private static class SLLNode<T> extends LLNode<T>
    {
        SLLNode(T nodeValue, SLLNode<T> nextNode)
        {
            super(nodeValue, nextNode);
        }
    }


    /* Head and tail node that is maintained so prepend/append is constant time.
     * head is a node that proceeds the actual first node in the list, while
     * tail points to the last actual node in the list.
     */
    private SLLNode<T> head, tail;

    /* Size of the list */
    private int size = 0;


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
        this.tail = new SLLNode<>(item, null);
        this.head = new SLLNode<>(null, this.tail);
        size++;
    }


    @Override
    public SLLNode<T> headNode() { return (SLLNode<T>) this.head.next; }


    @Override
    public SLLNode<T> tailNode() { return this.tail; }


    @Override
    public LLIterator<T> iterator() { return new LLIterator<>(this.head); }


    public LLIterator<T> tailIterator() { return this.isEmpty() ? null : new LLIterator<>(this.tail); }


    @Override
    public void insertAt(T item, LLIterator<T> loc)
    {
        if (this.checkFirst(item)) return;
        boolean isNewHead = loc.prev.value == null;
        boolean isNewTail = loc.prev.next == null;
        SLLNode<T> node = new SLLNode<>(item, (SLLNode<T>) loc.prev.next);
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
    public void insert(T item)
    {
        if (this.checkFirst(item)) return;
        insertAt(item, this.iterator());
    }


    @Override
    public void append(T item)
    {
        if (this.checkFirst(item)) return;
        this.insertAt(item, this.tailIterator());
    }


    @Override
    public void prepend(T item) { this.insert(item); }


    @Override
    public T head() { return this.headNode().value; }


    @Override
    public T tail() { return this.tailNode().value; }


    @Override
    public T remove(T item) throws NoSuchElementException
    {
        LLIterator<T> loc = find(item);
        if (loc.prev.value == null) { this.head.next = loc.next.next; }
        if (loc.next.next == null) { this.tail = (SLLNode<T>) loc.prev; }
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
    public String toString() { return this.stringify(); }

}