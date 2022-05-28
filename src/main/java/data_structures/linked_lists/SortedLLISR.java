package data_structures.linked_lists;

public interface SortedLLISR<T> extends LLISR<T>
{

    interface SortedKeyComparison
    {
        float compare(float xKey, float yKey);
    }

}
