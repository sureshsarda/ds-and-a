package clrs.quicksort;

public class QuickSort {

    protected static void swap(int[] arr, int at, int with) {
        int temp = arr[at];
        arr[at] = arr[with];
        arr[with] = temp;
    }

    protected static int partition(int[] arr, final int start, final int end) {
        if (start < 0 || end < start) {
            throw new IllegalArgumentException("Array index out of bounds");
        }

        if (end > arr.length - 1) {
            throw new IllegalArgumentException("End is greater than the length of the array");
        }

        int current = start;
        int lowEnd = start - 1;

        int pivot = arr[end];

        while (current < end) {
            if (arr[current] < pivot) {
                lowEnd += 1;
                swap(arr, lowEnd, current);
            }
            current++;
        }
        swap(arr, lowEnd + 1, end);
        return lowEnd + 1;
    }

    protected static void doSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            doSort(arr, start, pivot - 1);
            doSort(arr, pivot + 1, end);
        }
    }

    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }
}
