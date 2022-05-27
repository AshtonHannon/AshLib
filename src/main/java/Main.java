import data_structures.SortedDLL;
import util.Utilities;

public class Main
{
    public static void main(String[] args)
    {
        var dll = new SortedDLL<>((x, y) -> x/y);
        dll.fromArray(Utilities.genRandIntArray(500, 13, 147));
        System.out.println(dll);
    }
}
