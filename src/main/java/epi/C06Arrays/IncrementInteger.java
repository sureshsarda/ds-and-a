package epi.C06Arrays;

import java.util.Arrays;

public class IncrementInteger {

    public static int[] increment(int[] integer) {
        int carry = 0;
        int position = integer.length - 1;

        do {
            if (position == -1) {
                // we have reached the start of array
                // we can break and move all the digits to the left
                int[] res = new int[integer.length + 1];
                res[0] = 1;
                return res;
            }
            integer[position] += 1;
            if (integer[position] >= 10) {
                integer[position] = 0;
                carry = 1;
                position -= 1;
            } else {
                carry = 0;
            }
        } while (carry != 0);

        return integer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(increment(new int[]{1})));
        System.out.println(Arrays.toString(increment(new int[]{1, 2})));
        System.out.println(Arrays.toString(increment(new int[]{1, 9})));
        System.out.println(Arrays.toString(increment(new int[]{1, 9, 3})));
        System.out.println(Arrays.toString(increment(new int[]{4, 9})));
        System.out.println(Arrays.toString(increment(new int[]{9, 9})));
    }
}
