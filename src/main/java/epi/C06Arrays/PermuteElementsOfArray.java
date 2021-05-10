package epi.C06Arrays;

import java.util.Arrays;

public class PermuteElementsOfArray {

    public static char[] permuteElementsAdditionalSpace(char[] arr, int[] permutation) {
        char[] perm = new char[arr.length];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = arr[permutation[i]];
        }
        return perm;
    }

    public static char[] permuteElements(char[] arr, int[] permutation) {
        // you will need at least bit mask to mark things that are done
        // or as in the book, mark the permutations as negative
        // using the books approach
        for (int i = 0; i < permutation.length && permutation[i] >= 0; i++) {
            chainedPermutation(arr, permutation, i);
        }
        return arr;
    }

    private static void chainedPermutation(char[] arr, int[] permutation, int startAt) {
        final int startPos = permutation[startAt];
        final char startValue = arr[permutation[startAt]];

        int currentPos = startPos;

        do {
            char currentVal = arr[currentPos];
            arr[currentPos] = arr[permutation[currentPos]];
            arr[permutation[currentPos]] = currentVal;

            // mark current position as done
            permutation[currentPos] *= -1;

            // perp for next cycle
            currentPos = permutation[currentPos];

        } while (permutation[currentPos] != startPos);
        arr[currentPos] = startValue;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permuteElementsAdditionalSpace("ABCDEF".toCharArray(), new int[]{2, 3, 1, 4, 5, 0})));
        System.out.println(Arrays.toString(permuteElementsAdditionalSpace("ABCDEF".toCharArray(), new int[]{1, 0, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(permuteElementsAdditionalSpace("ABCDEF".toCharArray(), new int[]{0, 1, 3, 2, 5, 4})));
    }
}
