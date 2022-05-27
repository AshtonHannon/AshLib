package util;

import java.util.Random;

public class Utilities
{

    public static Integer[] genRandIntArray(Integer numOfItems, Integer min, Integer max)
    {
        return new Random().ints(numOfItems, min, max+1).boxed().toArray(Integer[]::new);
    }


    public static Integer[] genIntArray(Integer numOfItems, boolean... inclusive)
    {
        Integer[] arr = new Integer[numOfItems];
        boolean inc = inclusive.length == 0;
        if (inc) { for (int i = 0; i < numOfItems; i++) { arr[i] = i; } }
        else { for (int i = 1; i <= numOfItems; i++) { arr[i - 1] = i; } }
        return arr;
    }

}
