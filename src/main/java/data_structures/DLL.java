package data_structures;

import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;

public class DLL<T> implements Iterable<T>, UnsortedLLISR<T>
{

    private static class DLLNode<T> extends LLNode<T>
    {

        DLLNode(DLLNode<T> prevNode, T nodeValue, DLLNode<T> nextNode) { super(prevNode, nodeValue, nextNode); }

    }


    /* Head and tail node that is maintained so prepend/append is constant time.
     * head is a node that proceeds the actual first node in the list, while
     * tail points to the last actual node in the list.
     */
    private DLLNode<T> head, tail;

    /* Size of the list */
    private int size = 0;


    private boolean isNewHead(LLIterator<T> loc) { return (this.head.next == loc.next); }


    private boolean isNewTail(LLIterator<T> loc) { return (this.tail.prev == loc.prev); }


    private void insertFirst(T item)
    {
        this.tail = new DLLNode<>(null, null, null);
        this.head = new DLLNode<>(null, null, null);
        DLLNode<T> newNode = new DLLNode<>(null, item, null);
        this.tail.prev = newNode;
        newNode.next = this.tail;
        newNode.prev = this.head;
        this.head.next = newNode;
        this.size++;
    }


    @Override
    public DLLNode<T> headNode() { return this.head; }


    @Override
    public DLLNode<T> tailNode() { return (DLLNode<T>) this.tail.prev; }


    @Override
    public LLIterator<T> iterator() { return new LLIterator<>(this.headNode()); }


    public LLIterator<T> tailIterator() { return new LLIterator<>(this.tailNode()); }


    @Override
    public void insertAt(T item, @NotNull LLIterator<T> loc)
    {
        if (this.isEmpty())
        {
            insertFirst(item);
            return;
        }
        boolean isNewHead = isNewHead(loc);
        boolean isNewTail = isNewTail(loc);
        DLLNode<T> newNode = new DLLNode<>(null, item, null);
        if (isNewHead)
        {
            newNode.prev = this.head;
            newNode.next = this.head.next;
            this.head.next = newNode;
        }
        else if (isNewTail)
        {
            newNode.prev = this.tail.prev;
            newNode.next = this.tail;
            this.tail.prev.next = newNode;
            this.tail.prev = newNode;
        }
        else
        {
            DLLNode<T> prevNode = (DLLNode<T>) loc.prev;
            DLLNode<T> nextNode = (DLLNode<T>) loc.next;
            DLLNode<T> node = new DLLNode<>(prevNode, item, nextNode);
            prevNode.next = node;
            nextNode.prev = node;
        }
        size++;
    }


    @Override
    public void insert(T item)
    {
        if (this.isEmpty())
        {
            insertFirst(item);
            return;
        }
        insertAt(item, this.iterator());
    }


    public void append(T item)
    {
        if (this.isEmpty())
        {
            insertFirst(item);
            return;
        }
        insertAt(item, this.tailIterator());
    }


    public void prepend(T item) { this.insert(item); }


    @Override
    public T head() { return this.headNode().next.value; }


    @Override
    public T tail() { return this.tailNode().value; }


    @Override
    public T remove(T item) throws NoSuchElementException
    {
        LLIterator<T> loc = this.find(item); // Placed just 'behind' item.
        loc.prev.next = loc.next.next; /* Link loc.prev.next = loc.next.next */
        loc.next.next.prev = loc.prev; /* link loc.next.next.prev = loc.prev */
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
    public boolean isEmpty() { return this.size() == 0; }


    @Override
    public String toString() { return this.stringify(); }

}
