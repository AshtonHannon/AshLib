package data_structures.trees;

import data_structures.ISR;

public interface BTISR<T> extends ISR<T>
{
    interface TreeComparison
    {
        float compare(float xNode, float yNode);
    }


    default String sidewaysString(TNode<T> root, TNode<T> node, Integer indent, Integer offset)
    {
        StringBuilder spacing = new StringBuilder();
        spacing.append(" ".repeat(Math.max(0, indent)));

        if (node == null || (node == root && this.isEmpty())) { return ""; }
        if (node.leftChild == null)
        {
            if (node.rightChild == null)
            {
                return (spacing + "()" + node.value);
            }
            else
            {
                return sidewaysString(root, node.rightChild, indent+offset, offset) + "\n"
                        + spacing + "()" + node.value;
            }
        }
        else if (node.rightChild == null)
        {
            return (spacing + "()" + node.value + "\n" + sidewaysString(root, node.leftChild, indent+offset, offset));
        }
        else
        {
            return (sidewaysString(root, node.rightChild, indent+offset, offset) + "\n"
            + spacing + "()" + node.value + "\n" + sidewaysString(root, node.leftChild, indent+offset, offset));
        }
    }


    default String stringify(TNode<T> root) { return this.sidewaysString(root, root, 0, 3); }

}
