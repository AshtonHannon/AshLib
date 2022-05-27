package data_structures;

public interface SortedLLISR<T> extends LLISR<T>
{

    interface SortedKeyComparison
    {
        float compare(float xKey, float yKey);
    }

}
