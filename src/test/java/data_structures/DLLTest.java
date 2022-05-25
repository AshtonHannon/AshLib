package data_structures;

import org.junit.jupiter.api.Test;
import util.Utilities;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DLLTest
{

    @Test
    void remove()
    {
        DLL<Integer> dll = new DLL<>();
        dll.fromArray(Utilities.genIntArray(25));
        for (Integer i : dll.toArray())
        {
            if (i % 2 == 1)
            {
                dll.remove(i);
            }
        }
    }


    @Test
    void size()
    {
        DLL<Integer> dll = new DLL<>();
        dll.fromArray(Utilities.genRandIntArray(500, 0, 500));
        assertEquals(500, dll.size(), "Inserted 500 random items, but dll.size() != 500");
    }


    @Test
    void find()
    {
        DLL<Integer> dll = new DLL<>();
        dll.fromArray(Utilities.genIntArray(100));

        Iterator<Integer> itr15 = dll.find(15);
        assertEquals(15, itr15.next(), "Tried to find 15, but value of resulting iterator is not as expected");

        Iterator<Integer> itr49 = dll.find(49);
        assertEquals(49, itr49.next(), "Tried to find 49, but value of resulting iterator is not as expected");
    }


    @Test
    void insert()
    {
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < 100; i++)
        {
            dll.insert(i);
        }
        System.out.println(dll);
        for (int i = 99; i >= 0; i--)
        {
            Integer item = dll.remove(dll.head());
            assertEquals(i, item, String.format("Expected %s, but instead got %s after insertion.%n", i, item));
        }
    }


    @Test
    void insertAt()
    {
        DLL<String> dll = new DLL<>();
        dll.append("Hello");
        dll.append("I");
        dll.append("am");
        dll.append("appending");
        dll.append("strings!");
        LLIterator<String> pos = dll.find("strings!");
        dll.insertAt("some", pos);
        ArrayList<String> arr = dll.toArray();
        String[] exp = {"Hello", "I", "am", "appending", "some", "strings!"};
        for (int i = 0; i < exp.length; i++)
        {
            assertEquals(exp[i], arr.get(i), String.format("Expected: %s, instead got: %s%n", exp[i], arr.get(i)));
        }
    }


    @Test
    void append()
    {
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < 100; i++)
        {
            dll.append(i);
        }
        for (int i = 0; i < 100; i++)
        {
            Integer item = dll.remove(dll.head());
            assertEquals(i, item, "Removed item was not as expected after appending items.");
        }
    }


    @Test
    void prepend()
    {
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < 100; i++)
        {
            dll.prepend(i);
        }
        for (int i = 99; i >= 0; i--)
        {
            Integer item = dll.remove(dll.head());
            assertEquals(i, item, "Expected head to be " + i + ", but instead it was " + item);
        }
    }


    @Test
    void fromArray()
    {
        Integer[] randArr = Utilities.genRandIntArray(100, 0, 100);
        DLL<Integer> dll = new DLL<>();
        dll.fromArray(randArr);
        for (Integer i : randArr)
        {
            assertEquals(i, dll.remove(dll.head()), "Index of item in array is not expected item returned from linked list.");
        }
    }

}