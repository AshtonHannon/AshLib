import data_structures.SortedSLL;
import util.Utilities;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        var sortsll = new SortedSLL<>((x, y) -> x/y);
        var randArr = Utilities.genRandIntArray(100, 0, 100);
        System.out.printf("Beginning randArr: %s%n", Arrays.toString(randArr));
        sortsll.fromArray(randArr);
        System.out.printf("After insertion: %s%n", sortsll);
    }
}
