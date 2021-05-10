package epi.C07Strings;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpreadSheetColumnEncoding {

    public static int encode(String column) {

        int value = 0;
        char[] digits = column.toCharArray();
        for (char digit : digits) {
            value = (value * 26) + digit - 'A' + 1;
        }
        return value;
    }

    @Test
    public void testEncode() {
        assertEquals(1, encode("A"));
        assertEquals(27, encode("AA"));
        assertEquals(26, encode("Z"));
        assertEquals(52, encode("AZ"));
        assertEquals(53, encode("BA"));
    }
}
