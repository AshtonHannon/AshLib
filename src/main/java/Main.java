import data_structures.trees.BinaryTree;

public class Main
{
    public static void main(String[] args)
    {
        var tree = new BinaryTree<>((x, y) -> x/y);
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(100);
        tree.insert(120);
        tree.insert(110);
        System.out.println(tree);
    }
}
