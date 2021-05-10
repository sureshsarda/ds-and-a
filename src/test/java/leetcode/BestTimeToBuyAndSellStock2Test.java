package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BestTimeToBuyAndSellStock2Test {

    @Test
    public void testMaxProfit() {
        assertEquals(7, BestTimeToBuyAndSellStock2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, BestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, BestTimeToBuyAndSellStock2.maxProfit(new int[]{7, 6, 4, 3, 1}));

        assertEquals(0, BestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 1, 1, 1, 1}));
        assertEquals(1, BestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 2, 2, 2, 2, 1}));
        assertEquals(1, BestTimeToBuyAndSellStock2.maxProfit(new int[]{4, 3, 2, 1, 0, 0, 0, 1, 1, 1}));

        assertEquals(0, BestTimeToBuyAndSellStock2.maxProfit(new int[]{1}));
        assertEquals(0, BestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 1}));
        assertEquals(0, BestTimeToBuyAndSellStock2.maxProfit(new int[]{0, 0}));

        assertEquals(28, BestTimeToBuyAndSellStock2.maxProfit(new int[]{10, 10, 10, 12, 12, 14, 10, 14, 10, 15, 10, 14, 13, 12, 1, 12, 1}));


    }

}
