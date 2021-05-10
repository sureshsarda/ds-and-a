package epi.C06Arrays;

import java.util.Arrays;

public class ComputeNextPermutation {

    public static int[] nextPermutation(int[] given) {
        // step 1 find longest increasing suffix
        int pos = given.length - 2; // last entry in itself is longest increasing
        while (pos >= 0 && given[pos] > given[pos + 1]) {
            pos--;
        }

        if (pos < 0) {
            reverse(given, -1);
            return given;
        }

        int value = given[pos];
        // step 2 find the number just larger that value
        int justLargerIndex = given.length - 1;
        while (justLargerIndex >= 0 && given[justLargerIndex] < value) {
            justLargerIndex--;
        }

        swap(given, pos, justLargerIndex);
        reverse(given, pos);

        return given;
    }

    /**
     * Reverses the array after position pos
     *
     * @param given
     * @param pos
     */
    private static void reverse(int[] given, int pos) {
        int start = pos + 1;
        int end = given.length - 1;
        while (start < end) {
            swap(given, start++, end--);
        }
    }

    /**
     * Swaps entries at locations
     *
     * @param given
     * @param i
     * @param j
     */
    private static void swap(int[] given, int i, int j) {
        int temp = given[i];
        given[i] = given[j];
        given[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{6, 2, 1, 5, 4, 3, 0})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 4, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 2, 2, 3, 3, 4, 5, 3, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 5, 1})));

    }

}
