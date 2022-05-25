package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ISR<T>
{

    LLNode<T> headNode();

    LLNode<T> tailNode();

    Iterator<T> iterator();

    Iterator<T> find(T item) throws NoSuchElementException;

    void insertAt(T item, LLIterator<T> loc);

    void insert(T item);

    void append(T item);

    void prepend(T item);

    T get(Integer index);

    T set(Integer index, T item);

    T head();

    T tail();

    T remove(T item) throws NoSuchElementException;

    int size();

    boolean contains(T item);

    boolean isEmpty();

}
