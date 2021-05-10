package epi.C07Strings;

public class InterconvertStringInteger {

    public static int stringToInt(String number) {
        // input can be: "232", "3", "-199", "200"
        // TODO Integer overflow not handled
        int value = 0;
        char[] digits = number.toCharArray();

        int multiply = digits[0] == '-' ? -1 : 1;

        int base = 1;

        for (int i = digits.length - 1; i >= (multiply > 0 ? 0 : 1); i--) {
            value += (digits[i] - '0') * base;
            base *= 10;
        }
        return value * multiply;
    }

    public static String intToString(int number) {
        StringBuilder sb = new StringBuilder();
        boolean isPositive = true;
        if (number == 0) {
            return "0";
        }

        if (number < 0) {
            number *= -1;
            isPositive = false;
        }

        while (number > 0) {
            char digit = (char) (number % 10 + '0');
            sb.append(digit);
            number /= 10;
        }
        return (isPositive ? "" : "-") + sb.reverse().toString();
    }

//
//    @Test
//    public void testIntegerToStringConversion() {
//        assertEquals("-199", intToString(-199));
//        assertEquals("244", intToString(244));
//        assertEquals("0", intToString(0));
//        assertEquals("-1", intToString(-1));
//        assertEquals("1", intToString(1));
//        assertEquals("2", intToString(2));
//        assertEquals("5", intToString(5));
//    }
//
//    @Test
//    public void testStringToIntegerConversion() {
//        assertEquals(-199, stringToInt("-199"));
//        assertEquals(244, stringToInt("244"));
//        assertEquals(0, stringToInt("0"));
//        assertEquals(-1, stringToInt("-1"));
//        assertEquals(1, stringToInt("1"));
//        assertEquals(2, stringToInt("2"));
//        assertEquals(5, stringToInt("5"));
//        assertEquals(222323232, stringToInt("222323232"));
//    }
}
