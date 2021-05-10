package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HappyNumberTest {

    @Test
    public void testIntToDigits() {
        assertArrayEquals(new int[]{0}, HappyNumber.intToDigits(0));
        assertArrayEquals(new int[]{1}, HappyNumber.intToDigits(1));
        assertArrayEquals(new int[]{2}, HappyNumber.intToDigits(2));

        assertArrayEquals(new int[]{1, 0}, HappyNumber.intToDigits(10));
        assertArrayEquals(new int[]{2, 2}, HappyNumber.intToDigits(22));
        assertArrayEquals(new int[]{9, 9}, HappyNumber.intToDigits(99));

        assertArrayEquals(new int[]{1, 0, 0}, HappyNumber.intToDigits(100));
        assertArrayEquals(new int[]{1, 0, 1}, HappyNumber.intToDigits(101));
        assertArrayEquals(new int[]{5, 0, 0}, HappyNumber.intToDigits(500));

    }

    @Test
    public void testSquareOfDigits() {
        assertEquals(0, HappyNumber.squareOfDigits(0));
        assertEquals(1, HappyNumber.squareOfDigits(1));
        assertEquals(9, HappyNumber.squareOfDigits(3));
        assertEquals(25, HappyNumber.squareOfDigits(5));

        assertEquals(29, HappyNumber.squareOfDigits(25));
        assertEquals(37, HappyNumber.squareOfDigits(16));
        assertEquals(145, HappyNumber.squareOfDigits(89));
        assertEquals(42, HappyNumber.squareOfDigits(145));

    }

    @Test
    public void testIsHappy() {
        assertTrue(HappyNumber.isHappy(1));
        assertTrue(HappyNumber.isHappy(10));
        assertTrue(HappyNumber.isHappy(100));
        assertTrue(HappyNumber.isHappy(13));
        assertTrue(HappyNumber.isHappy(31));
        assertTrue(HappyNumber.isHappy(19));

        assertFalse(HappyNumber.isHappy(25));
        assertFalse(HappyNumber.isHappy(145));
        assertFalse(HappyNumber.isHappy(41));
        assertFalse(HappyNumber.isHappy(42));
        assertFalse(HappyNumber.isHappy(0));
        assertFalse(HappyNumber.isHappy(99));
        assertFalse(HappyNumber.isHappy(573));

    }
}
