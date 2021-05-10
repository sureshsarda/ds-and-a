package epi.C07Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPallindromeIgnoreSpecialChars {

    private static boolean isAlphaNumeric(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
    }

    public static boolean isPallindrome(String str) {
        char[] chars = str.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;

        while (p2 > p1) {
            while (!isAlphaNumeric(chars[p1])) {
                p1 += 1;
            }

            while (!isAlphaNumeric(chars[p2])) {
                p2 -= 1;
            }

            if (chars[p1++] != chars[p2--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsPallindrom() {
        assertTrue(isPallindrome("abccba"));
        assertTrue(isPallindrome("hello, how are you today??..ya/.dot   uoy??erawoh ()olleh++"));
    }
}
