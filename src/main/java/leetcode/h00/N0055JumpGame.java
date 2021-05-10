package leetcode.h00;

public class N0055JumpGame {

    // had to ses discussion. Was thinking in Backtracking and DP direction
    public boolean canJump(int[] nums) {
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (jump >= i)
                jump = Math.max(jump, i + nums[i]);
            else
                return false;
        }
        return true;
    }
}
