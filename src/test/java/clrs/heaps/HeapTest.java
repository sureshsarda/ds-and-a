package clrs.heaps;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HeapTest {

    @Test
    public void testHeapifyAddsElementCorrectly() {
        Heap<Integer> heap = Heap.from(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int root = heap.heap.get(1);
        assertEquals(root, 9);
    }

    @Test
    public void testElementsAddedMaintainsHeap() {
        Heap<Integer> heap = Heap.from(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(1, (int) heap.heap.get(heap.heap.size()));

        heap.add(1);
        assertEquals(9, (int) heap.heap.get(1));
        assertEquals(1, (int) heap.heap.get(heap.heap.size()));

        heap.add(10);
        assertEquals(10, (int) heap.heap.get(1));
    }

    @Test
    public void testHeapSortSorts() {
        Integer[] sorted = Heap.sort(2, 9, 13, 1, 5, 7, 12, 0, 9).toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{0, 1, 2, 5, 7, 9, 9, 12, 13}, sorted);

    }


}
