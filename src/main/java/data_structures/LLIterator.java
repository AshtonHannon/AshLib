package data_structures;

import java.util.Iterator;

public class LLIterator<T> implements Iterator<T>
{
    /*
     * prev - Node prev/before current cursor position
     * next - Node next/after current cursor position
     * last - Node that was last returned by the iterator
     */
    LLNode<T> prev, next;


    LLIterator(LLNode<T> startingNode)
    {
        this.prev = startingNode;
        this.next = this.prev.next;
    }


    @Override
    public boolean hasNext() { return next != null && next.value != null; }


    @Override
    public T next()
    {
        prev = next;
        next = prev.next;
        return prev.value;
    }


    @Override
    public String toString()
    {
        String strPrev = prev.value == null ? null : prev.value.toString();
        String strNext = next.value == null ? null : next.value.toString();
        return ("LLItr[" + strPrev + " | " + strNext + "]");
    }
}
