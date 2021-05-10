package epi.C06Arrays;

public class BuyAndSellStock {

    public static int buyAndSellStock(int[] prices) {
        int maxProfitPossible = 0;
        int maxSoFar = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int currentProfit = maxSoFar - prices[i];
            maxProfitPossible = Math.max(currentProfit, maxProfitPossible);
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }
        return maxProfitPossible;
    }

    public static void main(String[] args) {
        System.out.println(buyAndSellStock(new int[]{10, 12, 14, 19, 12, 9, 14, 12, 15, 13, 12}));
    }
}
