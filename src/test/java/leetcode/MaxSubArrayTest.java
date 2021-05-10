package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSubArrayTest {

    @Test
    public void maxSubArray() {
        assertEquals(0, MaxSubArray.maxSubArray(new int[]{}));
        assertEquals(0, MaxSubArray.maxSubArray(new int[]{0}));
        assertEquals(-1, MaxSubArray.maxSubArray(new int[]{-1}));
        assertEquals(-1, MaxSubArray.maxSubArray(new int[]{-1, -2, -3, -1}));
        assertEquals(-1, MaxSubArray.maxSubArray(new int[]{-2, -1}));

        assertEquals(3, MaxSubArray.maxSubArray(new int[]{-2, -1, 0, 1, 2}));
        assertEquals(3, MaxSubArray.maxSubArray(new int[]{0, 1, 0, 0, 1, 0, 1}));
        assertEquals(2, MaxSubArray.maxSubArray(new int[]{1, -1, 1, -1, 1, -2, 2}));

        assertEquals(14, MaxSubArray.maxSubArray(new int[]{-1, 2, 3, -1, -1, 1, -10, 5, -1, 3, 2, 2, -1, -1, 5}));






    }
}
