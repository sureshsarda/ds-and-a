package leetcode.h03;

import java.util.Arrays;

public class N0324WiggleSort2 {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int[] arr2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            moveAround(nums, arr2, i);
        }
    }

    private void moveAround(int[] dest, int[] from, int i) {
        // assert both array have equal length
        int length = dest.length;
        int lenBy2 = (int) Math.ceil(length / 2.0);

        if (i < lenBy2) {
            dest[i * 2] = from[i];
        } else {
            dest[(i - lenBy2) * 2 + 1] = from[i];
        }
    }

    public static void main(String[] args) {
        new N0324WiggleSort2().wiggleSort(new int[] {1, 2, 1});
    }
}
