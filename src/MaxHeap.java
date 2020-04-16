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

    //向堆中添加元素
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    //上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中最大元素
    public E findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        swap(0,data.size()-1);
        data.remove(data.size() - 1);
        shiftDown(0);
        return ret;
    }

    //下浮
    private void shiftDown(int k) {
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }

    }


    private void swap(int k, int j) {
        E temp = data.get(k);
        data.set(k, data.get(j));
        data.set(j, temp);
    }

}
