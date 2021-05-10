package leetcode;


import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int[] sumOfArray = new int[nums.length];

        int lengthOfMaxSubArray = 0;

        for (int i = 0; i < nums.length; i++) {

            int currentNumber = nums[i] == 1 ? 1 : -1;
            sumOfArray[i] = currentNumber;

            for (int j = i + 1; j < nums.length; j++) {
                sumOfArray[j] = sumOfArray[j - 1] + (nums[j] == 1 ? 1 : -1);
                if (j - i + 1 > lengthOfMaxSubArray && sumOfArray[j] == 0) {
                    lengthOfMaxSubArray = j - i + 1;
                }
            }

        }
        return lengthOfMaxSubArray;
    }

    public int findMaxLength2(int[] nums) {
        int longestLength = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> sumVsLength = new HashMap<>();
        sumVsLength.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i] == 0 ? -1 : 1;
            if (sumVsLength.containsKey(currentSum)) {
                longestLength = Math.max(longestLength, i - sumVsLength.get(currentSum));
            }
            sumVsLength.putIfAbsent(currentSum, i);
        }
        return longestLength;
    }
}
