package epi.C07Strings;

public class BaseConversion {

    public static String convert(String number, int from, int to) {
        if (from < 2 || from > 10 || to < 2 || to > 10) {
            return "0";
        }

        int value = convertToInt(number, from);
        return convertToString(value, to);
    }

    private static String convertToString(int number, int base) {
        StringBuilder sb = new StringBuilder();
        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            char digit = (char) (number % base + '0');
            sb.append(digit);
            number /= base;
        }
        return sb.reverse().toString();
    }

    private static int convertToInt(String number, int base) {
        int value = 0;

        int multiplier = 1;
        char[] digits = number.toCharArray();

        for (int i = digits.length - 1; i >= 0; i--) {
            value += (digits[i] - '0') * multiplier;
            multiplier *= base;
        }

        return value;

    }

//    @Test
//    public void testConvertToInt() {
//        assertEquals(9, convertToInt("12", 7));
//        assertEquals(16, convertToInt("20", 8));
//        assertEquals(2, convertToInt("10", 2));
//        assertEquals(10, convertToInt("1010", 2));
//        assertEquals(3, convertToInt("10", 3));
//    }
//
//    @Test
//    public void testConvert() {
//        assertEquals("1010", convert("10", 10, 2));
//        assertEquals("10000", convert("20", 8, 2));
//        assertEquals("11", convert("1010", 2, 9));
//    }
}
