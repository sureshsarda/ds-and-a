package epi.C06Arrays;

// similar to one of the main.java.leetcode questions solved
public class AdvanceThroughArray {

    public static boolean canReachEnd(int[] arr) {
        int reachedSoFar = 0;
        for (int i = 0; i <= reachedSoFar && reachedSoFar < arr.length; i++) {
            reachedSoFar = Math.max(reachedSoFar, arr[i] + i);
        }
        return reachedSoFar >= arr.length;
    }

    public static void main(String[] args) {
        System.out.println(canReachEnd(new int[]{3, 2, 0, 0, 2, 0, 1}));
        System.out.println(canReachEnd(new int[]{3, 3, 1, 0, 2, 0, 1}));
        System.out.println(canReachEnd(new int[]{3, 3, 0, 1, 2, 0, 1}));
    }
}
