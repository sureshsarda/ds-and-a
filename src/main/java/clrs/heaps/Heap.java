package clrs.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    OneBasedArrayList<T> heap = new OneBasedArrayList<T>();

    private Heap() { }

    private int leftChildLocation(int i) {
        return 2 * i;
    }

    private int rightChildLocation(int i) {
        return leftChildLocation(i) + 1;
    }

    protected void heapify(int atIndex) {
        int left = leftChildLocation(atIndex);
        int right = rightChildLocation(atIndex);

        int largest = atIndex;

        if (heap.hasIndex(left) && heap.get(left).compareTo(heap.get(atIndex)) > 0) {
            largest = left;
        }

        if (heap.hasIndex(right) && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }

        if (largest != atIndex) {
            // swap
            heap.swap(largest, atIndex);
            heapify(largest);
        }

    }

    protected void buildHeap(T... items) {
        Collections.addAll(heap, items);
        for (int i = heap.size() / 2; i > 0; i--) {
            heapify(i);
        }
    }

    public void add(T value) {
        heap.add(0, value);
        heapify(1);
    }

    public static <K extends Comparable<K>> Heap<K> from(K... items) {
        Heap<K> heap = new Heap<>();
        heap.buildHeap(items);
        return heap;
    }

    public static <K extends Comparable<K>> List<K> sort(K... items) {
        Heap<K> heap = Heap.from(items);

        List<K> arr = new ArrayList<>(heap.heap.size());
        for (int i = heap.heap.size(); i > 0; i--) {
            arr.add(0, heap.heap.remove(0));
            heap.heapify(1);
        }

        return arr;
    }
}

// TODO Incomplete. More methods that take the index must be overridden
class OneBasedArrayList<T> extends ArrayList<T> {

    @Override
    public T get(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The index start from 0 to " + size());
        }
        return super.get(i - 1);
    }

    @Override
    public T set(int i, T t) {
        return super.set(i - 1, t);
    }

    protected boolean hasIndex(int i) {
        return i > 0 && i <= size();
    }

    protected void swap(int at, int with) {
        T temp = get(at);
        set(at, get(with));
        set(with, temp);
    }
}
