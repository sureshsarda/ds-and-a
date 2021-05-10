package leetcode;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }


        int[] temp = new int[nums.length];
        temp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] * nums[i];
        }

        int rightHandProduct = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            temp[i] = temp[i - 1] * rightHandProduct;
            rightHandProduct *= nums[i];
        }
        temp[0] = rightHandProduct;

        return temp;
    }
}
