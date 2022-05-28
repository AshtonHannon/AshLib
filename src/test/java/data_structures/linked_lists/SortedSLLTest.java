package data_structures.linked_lists;

import data_structures.linked_lists.SortedSLL;
import org.junit.jupiter.api.Test;
import util.Utilities;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <b>SortedSLLTest</b>
 * Since every test within the SLLTest should work with SLL, it should
 * also work with SortedSLL simply because of inheritance.
 */
class SortedSLLTest extends SLLTest
{

    @Test
    void insert()
    {
        SortedSLL<Integer> sll = new SortedSLL<>((x, y) -> x/y);
        Integer[] randArr = Utilities.genRandIntArray(10000, 0, 100);
        sll.fromArray(randArr);
        Integer last = 0;
        for (Integer i : sll.toArray())
        {
            assertTrue(sll.get(i) >= last, "Item is not greater than last! Sorted-ness broken!");
            last = sll.get(i);
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