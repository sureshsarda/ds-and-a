package leetcode;

/**
 * SingleThreadedCPI to main.java.leetcode
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    static int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (maxEndingHere < 0 && nums[i] >= maxEndingHere) {
                maxEndingHere = 0;
            }

            maxEndingHere += nums[i];


            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }
}
