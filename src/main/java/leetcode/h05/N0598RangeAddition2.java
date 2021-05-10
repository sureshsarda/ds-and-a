package leetcode.h05;

public class N0598RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for (int i = 0; i < ops.length; i++) {
            int x = ops[i][0];
            int y = ops[i][1];

            if (x < minX) {
                minX = x;
            }

            if (y < minY) {
                minY = y;
            }

        }

        return minX * minY;

    }
}
