package leetcode.h00;

// 1hour 15 mins
public class N0096UniqueBST {

    private static final int[] CACHE = new int[19];

    public int numTrees(int n) {
        if (n > 19 || n < 0) {
            return 1;
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            if (CACHE[n] != 0) {
                return CACHE[n];
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                int left = numTrees(i);
                int right = numTrees(n - i - 1);
                result += left * right;
            }
            CACHE[n] = result;

            return result;
        }
    }

    public static void main(String[] args) {

        final N0096UniqueBST bst = new N0096UniqueBST();
        for (int i = 1; i < 20; i++) {
            System.out.println(bst.numTrees(i));

        }
    }
}
