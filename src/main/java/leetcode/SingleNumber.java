package leetcode;

/**
 * SingleThreadedCPI to main.java.leetcode
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    private int singleNumber(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        return value;

    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        assert 4 == sn.singleNumber(new int[]{2, 3, 4, 3, 2});
        assert 1 == sn.singleNumber(new int[]{1});
        assert 0 == sn.singleNumber(new int[]{1, 2, 1, 2, 0});
        assert 0 == sn.singleNumber(new int[]{0});
        assert -1 == sn.singleNumber(new int[]{-1, -2, 1, 1, -2});
    }

}
