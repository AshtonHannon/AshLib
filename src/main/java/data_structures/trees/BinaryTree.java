package data_structures.trees;

import data_structures.BaseNode;
import data_structures.ISR;

import java.rmi.UnexpectedException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BTISR<T>
{

    private TreeComparison keyComp;

    private BTNode<T> root;

    private Integer size = 0;


    public BinaryTree(TreeComparison keyComparisonFunc) { this.keyComp = keyComparisonFunc; }


    private static class BTNode<T> extends TNode<T>
    {
        BTNode(TNode<T> parentNode, TNode<T> leftChildNode, T nodeValue, TNode<T> rightChildNode)
        {
            super(parentNode, leftChildNode, nodeValue, rightChildNode);
        }
    }


    private boolean insertFirst(T item)
    {
        if (this.root == null)
        {
            this.root = new BTNode<T>(null, null, item, null);
            return true;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator()
    {
        return null;
    }


    @Override
    public Iterator<T> find(T item) throws NoSuchElementException
    {
        return null;
    }


    @Override
    public void insert(T item)
    {
        if (this.insertFirst(item)) { return; }
        BTNode<T> curNodeParent = null;
        Character direction = ' ';
        BTNode<T> curNode = this.root;
        while (curNode != null)
        {
            float compValue = this.keyComp.compare(item.hashCode(), curNode.value.hashCode());
            if (compValue < 1)
            {
                curNodeParent = curNode;
                curNode = (BTNode<T>) curNode.leftChild;
                direction = 'L';
            }
            else
            {
                curNodeParent = curNode;
                curNode = (BTNode<T>) curNode.rightChild;
                direction = 'R';
            }
        }
        curNode = new BTNode<>(curNodeParent, null, item, null);
        if (direction == 'L')
        {
            curNodeParent.leftChild = curNode;
        }
        else if (direction == 'R')
        {
            curNodeParent.rightChild = curNode;
        }
        size++;
    }


    @Override
    public T get(Integer index)
    {
        return null;
    }


    @Override
    public T head()
    {
        return null;
    }


    @Override
    public T tail()
    {
        return null;
    }


    @Override
    public T remove(T item)
    {
        return null;
    }


    @Override
    public int size()
    {
        return 0;
    }


    @Override
    public boolean contains(T item)
    {
        return false;
    }


    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    @Override
    public String toString() { return this.stringify(this.root); }

}
