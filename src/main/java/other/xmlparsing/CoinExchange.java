package other.xmlparsing;

import java.util.Arrays;
import java.util.List;

// FIXME Doesn't work
public class CoinExchange {

    public static int coinExchange(List<Integer> denominations, int value) {
        if (value == denominations.get(0) || value == 0) {
            return 1;
        } else if (value < denominations.get(0)) {
            return 0;
        } else {
            int count = 0;
            for (int deno : denominations) {
                count += coinExchange(denominations, value - deno);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(coinExchange(Arrays.asList(1, 2), 2));
        System.out.println(coinExchange(Arrays.asList(1, 2), 3));
        System.out.println(coinExchange(Arrays.asList(1, 2), 5));
    }
}
