import data_structures.DLL;
import data_structures.SLL;
import jdk.jshell.execution.Util;
import util.Utilities;

public class Main
{
    public static void main(String[] args)
    {
        var dll = new DLL<>();
        var sll = new SLL<>();
        dll.fromArray(Utilities.genRandIntArray(100, 0, 100));
        sll.fromArray(Utilities.genRandIntArray(100, 0, 100));
        System.out.println(dll);
        System.out.println(sll);
    }
}
