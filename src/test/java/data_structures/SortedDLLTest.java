package data_structures;

import org.junit.jupiter.api.Test;
import util.Utilities;

import static org.junit.jupiter.api.Assertions.*;

class SortedDLLTest extends DLLTest
{

    @Test
    void insert()
    {
        SortedDLL<Integer> dll = new SortedDLL<>((x, y) -> x/y);
        Integer[] randArr = Utilities.genRandIntArray(10000, 0, 100);
        dll.fromArray(randArr);
        Integer last = 0;
        for (Integer i : dll.toArray())
        {
            assertTrue(dll.get(i) >= last, "Item is not greater than last! Sorted-ness broken!");
            last = dll.get(i);
        }
    }

    @Test
    void append()
    {
        SortedSLL<Integer> sll = new SortedSLL<>((x, y) -> x/y);
        assertThrows(UnsupportedOperationException.class, ()->sll.append(10));
    }


    @Test
    void prepend()
    {
        SortedSLL<Integer> sll = new SortedSLL<>((x, y) -> x/y);
        assertThrows(UnsupportedOperationException.class, ()->sll.prepend(10));
    }


    @Test
    void set()
    {
        SortedSLL<Integer> sll = new SortedSLL<>((x, y) -> x/y);
        assertThrows(UnsupportedOperationException.class, ()->sll.set(1, 10));
    }

}