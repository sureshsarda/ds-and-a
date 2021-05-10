package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void productExceptSelf() {
        ProductOfArrayExceptSelf paes = new ProductOfArrayExceptSelf();

        assertArrayEquals(new int[]{}, paes.productExceptSelf(new int[]{}));
        assertArrayEquals(new int[]{2}, paes.productExceptSelf(new int[]{2}));
        assertArrayEquals(new int[]{4, 5}, paes.productExceptSelf(new int[]{5, 4}));

        assertArrayEquals(new int[]{80, 100, 20}, paes.productExceptSelf(new int[]{5, 4, 20}));
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, paes.productExceptSelf(new int[]{1, 1, 1, 1, 1}));
        assertArrayEquals(new int[]{81, 81, 81, 81, 81}, paes.productExceptSelf(new int[]{3, 3, 3, 3, 3}));


        assertArrayEquals(new int[]{720, 360, 240, 180, 144, 120}, paes.productExceptSelf(new int[]{1, 2, 3, 4, 5, 6}));
        assertArrayEquals(new int[]{24, 12, 8, 6}, paes.productExceptSelf(new int[]{1, 2, 3, 4}));


    }
}
