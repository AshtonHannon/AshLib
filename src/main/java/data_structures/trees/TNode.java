package data_structures.trees;

import data_structures.BaseNode;
import org.w3c.dom.Node;

/**
 * <b>TNode</b>
 * <p>Stands for TreeNode</p>
 *
 * @param <T>
 */
abstract public class TNode<T> extends BaseNode<T>
{

    T value;
    TNode<T> leftChild;
    TNode<T> rightChild;
    TNode<T> parent;


    TNode(TNode<T> parentNode, TNode<T> leftChildNode, T nodeValue, TNode<T> rightChildNode)
    {
        this.value = nodeValue;
        this.leftChild = leftChildNode;
        this.rightChild = rightChildNode;
        this.parent = parentNode;
    }


    /* Travels down the left subtree of this node for the left most node. */
    public TNode<T> getLeftMost()
    {
        TNode<T> n = this;
        while (n.leftChild != null)
        {
            n = n.leftChild;
        }
        return n;
    }


    /* Travels down the right subtree of this node for the right most node. */
    public TNode<T> getRightMost()
    {
        TNode<T> n = this;
        while (n.rightChild != null)
        {
            n = n.rightChild;
        }
        return n;
    }


    /* Gets the next inorder successor to this node. */
    TNode<T> getNextInorder()
    {
        if (this.rightChild != null)
        {
            return this.rightChild.getLeftMost();
        }
        else
        {
            TNode<T> n = this;
            while (n.parent != null && n == n.parent.rightChild)
            {
                n = n.parent;
            }
            return n.parent;
        }
    }

}
