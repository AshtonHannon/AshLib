package data_structures;

abstract public class LLNode<T> extends BaseNode<T>
{

    T value;
    LLNode<T> prev;
    LLNode<T> next;


    LLNode(LLNode<T> prevNode, T data, LLNode<T> nextNode)
    {
        value = data;
        prev = prevNode;
        next = nextNode;
    }


    LLNode(T data, LLNode<T> nextNode)
    {
        value = data;
        next = nextNode;
    }


    @Override
    public String toString()
    {
        String strPrev = prev == null ? "X" : prev.value.toString();
        String strNext = next == null ? "X" : next.value.toString();
        return String.format("LLNode[%s, %s, %s]", strPrev, value.toString(), strNext);
    }

    @Override
    public int hashCode() { return value.hashCode(); }

}