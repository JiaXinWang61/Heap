import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    //返回堆中元素个数
    public int size() {
        return data.size();
    }

    //返回堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组中，一个索引所表示的元素的父亲结点索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组中，一个索引所表示的元素的左孩子结点索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组中，一个索引所表示的元素的右孩子结点索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

}
