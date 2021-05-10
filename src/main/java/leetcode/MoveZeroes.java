package leetcode;

/**
 * SingleThreadedCPI to main.java.leetcode:
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    static void moveZeroes(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < nums.length) {
            int currentValue = nums[readIndex];
            if (currentValue != 0) {
                nums[writeIndex++] = currentValue;
            }
            readIndex++;
        }

        while (writeIndex < nums.length) {
            nums[writeIndex++] = 0;
        }
    }
}
