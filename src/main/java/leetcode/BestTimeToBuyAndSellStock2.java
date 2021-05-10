package leetcode;

public class BestTimeToBuyAndSellStock2 {

    static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = -1; // -1 is not holding anything

        for (int i = 0; i < prices.length - 1; i++) {
            int today = prices[i];
            int tomorrow = prices[i + 1];
            if (buyPrice >= 0) {
                // I have stock
                if (shouldSell(today, tomorrow)) {
                    profit += today - buyPrice;
                    buyPrice = -1;
                }
            } else {
                // I don't have stock
                if (shouldBuy(today, tomorrow)) {
                    buyPrice = today;
                }
            }
        }

        if (buyPrice >= 0) {
            // holding at last day, clear position
            profit += prices[prices.length - 1] - buyPrice;
        }

        return profit;
    }

    static boolean shouldBuy(int today, int tomorrow) {
        return tomorrow > today;
    }

    static boolean shouldSell(int today, int tomorrow) {
        return today > tomorrow;
    }
}
