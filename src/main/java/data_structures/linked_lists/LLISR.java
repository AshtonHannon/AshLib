package data_structures.linked_lists;

import data_structures.ISR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface LLISR<T> extends ISR<T>
{

    LLNode<T> headNode();

    LLNode<T> tailNode();

    @Override
    default T get(Integer index)
    {
        Iterator<T> itr = this.iterator();
        int i = 0;
        while (itr.hasNext() && i < index)
        {
            itr.next();
            i++;
        }
        return itr.next();
    }

    interface FindExpression<T>
    {
        boolean exp(LLIterator<T> loc, T item);
    }

    default LLIterator<T> find(T item, FindExpression<T> fe)
    {
        LLIterator<T> loc = (LLIterator<T>) this.iterator();
        boolean exp = loc.hasNext() && fe.exp(loc, item);
        while (loc.hasNext() || exp)
        {
            if (fe.exp(loc, item))
            {
                return loc;
            }
            loc.next();
        }
        throw new NoSuchElementException(String.format("Item {%s} to find could not be found in DLL", item));
    }

    default LLIterator<T> find(T item) { return this.findBefore(item); }

    default LLIterator<T> findBefore(T item) { return this.find(item, (x, y)->x.next.value == item); }

    default LLIterator<T> findAfter(T item) { return this.find(item, (x, y)->x.prev.value == item); }

    default String stringify()
    {
        return this.getClass().getSimpleName() + this.toArray().toString();
    }

    default ArrayList<T> toArray()
    {
        ArrayList<T> arr = new ArrayList<>();
        if (this.isEmpty()) { return arr; }
        Iterator<T> itr = this.iterator();
        while (itr.hasNext()) { arr.add(itr.next()); }
        return arr;
    }

}
