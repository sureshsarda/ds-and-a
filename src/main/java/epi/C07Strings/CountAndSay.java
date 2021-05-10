package epi.C07Strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CountAndSay {

    private static String nextNumber(String current) {
        // 122334
        char[] chars = current.toCharArray();

        StringBuilder sb = new StringBuilder();

        int sayingAt = 0;
        while (sayingAt < current.length()) {
            int count = 0;
            char counting = chars[sayingAt];

            while (sayingAt < current.length() && chars[sayingAt] == counting) {
                sayingAt++;
                count++;
            }
            sb.append(count);
            sb.append(counting);
        }
        return sb.toString();
    }

    public static List<String> countAndSay(int n) {
        String seed = "1";
        if (n <= 1) {
            return Collections.singletonList(seed);
        } else {
            List<String> numbers = new LinkedList<>();
            numbers.add(seed);
            for (int i = 2; i < n; i++) {
                seed = nextNumber(seed);
                numbers.add(seed);
            }
            return numbers;
        }
    }

//    @Test
//    public void testCountAndSay() {
//        System.out.println(countAndSay(10));
//    }
}
