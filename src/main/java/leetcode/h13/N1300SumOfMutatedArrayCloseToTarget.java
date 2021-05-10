package leetcode.h13;

import java.util.Arrays;

// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
public class N1300SumOfMutatedArrayCloseToTarget {

    private int[] rollingSum(int[] arr) {
        int[] rollingSum = new int[arr.length];
        rollingSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            rollingSum[i] = rollingSum[i - 1] + arr[i];
        }
        return rollingSum;
    }

    private int searchAdjacent(int[] arr, int[] rollingSum, int minI, int maxI, int deltaSoFar, int target) {
        if (minI + 1 >= maxI) {
            return minI;
        } else {
            int midI = (minI + maxI) / 2;

            int arraySum = rollingSum[midI - 1] + arr[midI] * (arr.length - midI);
            int delta = Math.abs(arraySum - target);

            if (delta < deltaSoFar) {
                if (arraySum > target) {
                    return searchAdjacent(arr, rollingSum, minI, midI, delta, target);
                    // move left
                } else if (arraySum < target) {
                    // move right
                    return searchAdjacent(arr, rollingSum, midI, maxI, delta, target);
                } else {
                    return arr[midI];
                }
            } else {
                return searchAdjacent(arr, rollingSum, midI, maxI, deltaSoFar, target);
            }
        }
    }

    // 2 3 9 17 34 67 99 132 200
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int[] rollingSum = rollingSum(arr);
        int currentDelta = Integer.MAX_VALUE;


        int minI = 0;
        int maxI = arr.length - 1;

        while (minI < maxI && minI + 1 != maxI) {


        }

        return 0;
    }
}
