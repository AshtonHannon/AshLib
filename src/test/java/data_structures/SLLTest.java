package data_structures;

import org.junit.jupiter.api.Test;
import util.Utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SLLTest
{

    @Test
    void remove()
    {
        /* Create an SLL with values from 1 to 25 */
        SLL<Integer> sll = new SLL<>();
        sll.fromArray(Utilities.genIntArray(25, true));

        /* Remove all the even numbers */
        for (int i = 1; i <= 25; i++)
        {
            if (i % 2 == 0)
            {
                sll.remove(i);
            }
        }
        assertEquals(13, sll.size(), "Took away all even numbers in SLL, but size is not 13 as expected");

        /* Check to see if there are any even numbers in the SLL */
        for (Integer integer : sll)
        {
            assertEquals(1, integer % 2, "Removed all even numbers, but at least one even number was not removed");
        }
    }


    @Test
    void size()
    {
        SLL<Integer> sll = new SLL<>();
        sll.fromArray(Utilities.genIntArray(100));
        assertEquals(100, sll.size(), "Returned size of SLL.size() is not as expected");
    }


    @Test
    void find()
    {
        SLL<Integer> sll = new SLL<>();
        sll.fromArray(Utilities.genIntArray(100));

        Iterator<Integer> itr15 = sll.find(15);
        assertEquals(15, itr15.next(), "Tried to find 15, but value of resulting iterator is not as expected");

        Iterator<Integer> itr49 = sll.find(49);
        assertEquals(49, itr49.next(), "Tried to find 49, but value of resulting iterator is not as expected");
    }


    @Test
    void findBefore()
    {
        var sll = new SLL<>();
        sll.fromArray(new String[]{"A", "B", "C", "D"});
        var loc1 = sll.findBefore("A");
        var loc2 = sll.findBefore("B");
        var loc3 = sll.findBefore("C");
        var loc4 = sll.findBefore("D");
        assertNull(loc1.prev.value, "Expected 'null' to be loc.prev 'null|A' after findBefore(), but wasn't.");
        assertEquals("A", loc2.prev.value, "Expected 'A' to be loc.prev 'A|B' after findBefore(), but wasn't");
        assertEquals("B", loc3.prev.value, "Expected 'B' to be loc.prev 'B|C' after findBefore(), but wasn't");
        assertEquals("C", loc4.prev.value, "Expected 'C' to be loc.prev 'C|D' after findBefore(), but wasn't");
    }


    @Test
    void findAfter()
    {
        var sll = new SLL<>();
        sll.fromArray(new String[]{"A", "B", "C", "D"});
        var loc1 = sll.findAfter("A");
        var loc2 = sll.findAfter("B");
        var loc3 = sll.findAfter("C");
        assertEquals("B", loc1.next.value, "Expected 'B' to be loc.next 'A|B' after findAfter(), but wasn't");
        assertEquals("C", loc2.next.value, "Expected 'C' to be loc.next 'B|C' after findAfter(), but wasn't");
        assertEquals("D", loc3.next.value, "Expected 'D' to be loc.next 'C|D' after findAfter(), but wasn't");
        assertThrows(NoSuchElementException.class, ()->sll.findAfter("D"), "NoSuchElementException was expected, but not returned");
    }


    @Test
    void insert()
    {
        /* Insert a bunch at front */
        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i <= 100; i++)
        {
            sll.insert(i);
        }
        for (int i = 100; i >= 0; i--)
        {
            Integer item = sll.remove(sll.head());
            assertEquals(i, item, "When checking insertions at head, expected: " + i + ", but got: " + item);
        }

        /* Insert a bunch at end */
        SLL<Integer> sll2 = new SLL<>();
        for (int i = 0; i <= 100; i++)
        {
            sll2.insertAt(i, sll2.tailIterator()); // Insert at end of SLL
        }
        for (int i = 100; i >= 0; i--)
        {
            Integer item = sll2.remove(sll2.tail()); // Remove last item
            assertEquals(i, item, "When checking insertions at tail, expected " + i + ", but got: " + item);
        }
    }


    @Test
    void insertAt()
    {
        var sll = new SLL<>();
        Integer[] exp = new Integer[]{0, 1, 2, 3, 4, 5, 21, 6, 7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18, 19, 20};
        sll.fromArray(Utilities.genIntArray(20));
        var loc = sll.findAfter(5);
        sll.insertAt(21, loc);
        for (var i : sll.toArray())
        {
            var item = sll.remove(sll.head());
            assertEquals(i, item, String.format("After removing head, expected head to be %s, but instead got %s", i, item.toString()));
        }
    }


    @Test
    void append()
    {
        /* Append one item and make sure the head of the list is that node */
        SLL<Integer> sll1 = new SLL<>();
        sll1.append(5);
        assertEquals(5, sll1.head(), "Expected head to be 5, instead got " + sll1.head().toString());

        /* Append 100 items, 1 to 100 */
        SLL<Integer> sll2 = new SLL<>();
        sll2.fromArray(Utilities.genIntArray(100));
        /* Now check all 100 items */
        for (int i = 0; i < 100; i++)
        {
            int item = sll2.remove(sll2.head());
            assertEquals(i, item, "Expected head to be " + i + ", instead got " + item);
        }
    }


    @Test
    void prepend()
    {
        SLL<Integer> sll1 = new SLL<>();
        sll1.prepend(5);
        assertEquals(5, sll1.head(), "Expected head to be 5, instead got " + sll1.head().toString());

        /* Prepend 1-- items, 1 to 100 */
        SLL<Integer> sll2 = new SLL<>();
        for (int i = 1; i <= 100; i++)
        {
            sll2.prepend(i);
        }

        /* Now check all 100 items */
        for (int i = 100; i >= 1; i--)
        {
            int item = sll2.remove(sll2.head());
            assertEquals(i, item, "Expected head to be " + i + ", instead got: " + item);
        }
    }


    @Test
    void fromArray()
    {
        Integer[] arr = {303, 499, 218, 59, 324, 488, 486, 325, 254, 91, 217,
                235, 19, 98, 487, 440, 463, 357, 472, 304, 266, 221, 421, 13,
                390, 171, 194, 55, 292, 205, 264, 166, 353, 181, 404, 122, 100,
                14, 92, 376, 255, 176, 96, 28, 485, 326, 124, 360, 417, 346,
                279, 232, 368, 435, 299, 362, 118, 480, 156, 111, 12, 161, 291,
                125, 33, 179, 68, 328, 123, 250, 468, 32, 336, 344, 452, 260,
                84, 78, 315, 280, 252, 49, 56, 276, 107, 70, 212, 293, 316, 44,
                104, 449, 392, 224, 372, 148, 77, 407, 283, 213};
        SLL<Integer> sll = new SLL<>();
        sll.fromArray(arr);
        for (Integer i : arr)
        {
            assertEquals(i, sll.remove(sll.head()), "Index of item in array is not expected item returned from linked list.");
        }
    }


    @Test
    void contains()
    {
        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < 100; i++)
        {
            sll.insert(i);
        }
        assertTrue(sll.contains(69), "contains(69) != true");
        assertFalse(sll.contains(100), "contains(100) != false");
        assertTrue(sll.contains(0), "contains(0) != true");
        assertFalse(sll.contains(1000), "contains(1000) != false");
        assertFalse(sll.contains(null), "contains(null) != false");
    }

}