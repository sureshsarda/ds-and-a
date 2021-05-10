package epi.C06Arrays;

import java.util.Arrays;

/**
 * Given a random array with numbers rearrange it such that even number appears first and odd later, without using
 * additional space
 */
public class EvenOdd {

    public static int nextEven(int[] arr, int i) {
        while (i >= 0 && arr[i] % 2 != 0) {
            i--;
        }
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] evenOdd(int[] arr) {
        int odd = nextEven(arr, arr.length - 1);

        for (int i = 0; i < arr.length && i < odd; i++) {
            if (arr[i] % 2 != 0) {
                swap(arr, i, odd);
                odd = nextEven(arr, odd - 1);
            }
        }
        return arr;
    }

    public static int[] evenOddBook(int[] arr) {
        int odd = arr.length - 1;
        int even = 0;
        while (even < odd) {
            if (arr[even] % 2 == 0) {
                even++;
            } else {
                swap(arr, even, odd--);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOdd(new int[]{1})));
        System.out.println(Arrays.toString(evenOdd(new int[]{2})));
        System.out.println(Arrays.toString(evenOdd(new int[]{2, 4})));
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 4})));
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(evenOdd(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 5, 2, 3, 4, 1, 9, 0})));
    }

}
