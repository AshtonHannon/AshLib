package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ISR<T>
{

    Iterator<T> iterator();

    Iterator<T> find(T item) throws NoSuchElementException;

    void insert(T item);

    T get(Integer index);

    T head();

    T tail();

    T remove(T item);

    int size();

    boolean contains(T item);

    boolean isEmpty();

}
