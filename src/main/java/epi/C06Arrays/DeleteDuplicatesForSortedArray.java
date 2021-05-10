package epi.C06Arrays;

import java.util.Arrays;

public class DeleteDuplicatesForSortedArray {

    /* Deletion should be inplace and last entries should be 0 */
    public static int[] deleteDuplicates(int[] arr) {

        int readIndex = 1;
        int writeIndex = 1;

        while (readIndex < arr.length) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        // fill the remaining array with 0
        while (writeIndex < arr.length) {
            arr[writeIndex] = 0;
            writeIndex++;
        }
        return arr;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteDuplicates(new int[]{1})));
        System.out.println(Arrays.toString(deleteDuplicates(new int[]{1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9})));
    }
}
