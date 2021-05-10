package clrs.quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void testPartition() {
        int[] arr = new int[]{3, 6, 9, 2, 18, 17, 1, 2, 90, 17, 21, 12, 33, 14};

        int[] target = null;

        target = Arrays.copyOfRange(arr, 0, arr.length);
        QuickSort.partition(target, 0, arr.length - 1);
        assertEquals(14, target[7]);

        target = Arrays.copyOfRange(arr, 0, arr.length);
        QuickSort.partition(target, 0, 3);
        assertEquals(2, target[0]);
    }

    @Test
    public void testSort() {
        int[] arr = new int[]{3, 6, 9, 2, 1, 2, 90, 17, 33, 14};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 3, 6, 9, 14, 17, 33, 90}, arr);
    }

}
