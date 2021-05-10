package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackspaceStringCompareTest {

    @Test
    public void backspaceCompare() {
        assertTrue(BackspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
        assertTrue(BackspaceStringCompare.backspaceCompare("ab##", "c#d#"));
        assertTrue(BackspaceStringCompare.backspaceCompare("a##c", "#a#c"));
        assertFalse(BackspaceStringCompare.backspaceCompare("a#c", "b"));
    }

    @Test
    public void compareTillHash() {
        assertTrue(BackspaceStringCompare.compareTillHash("d".toCharArray(), "d".toCharArray()));
        assertTrue(BackspaceStringCompare.compareTillHash("d####".toCharArray(), "d#".toCharArray()));
        assertTrue(BackspaceStringCompare.compareTillHash("adv##".toCharArray(), "adv##".toCharArray()));
        assertTrue(BackspaceStringCompare.compareTillHash("d#".toCharArray(), "d#####".toCharArray()));
        assertTrue(BackspaceStringCompare.compareTillHash("".toCharArray(), "".toCharArray()));

        assertFalse(BackspaceStringCompare.compareTillHash("a".toCharArray(), "".toCharArray()));
        assertFalse(BackspaceStringCompare.compareTillHash("".toCharArray(), "a".toCharArray()));
        assertFalse(BackspaceStringCompare.compareTillHash("ab".toCharArray(), "ba".toCharArray()));
        assertFalse(BackspaceStringCompare.compareTillHash("ab###".toCharArray(), "abb###".toCharArray()));


    }

    @Test
    public void compress() {
        // string at odd position are expected values of respective strings at even positions
        String[] io = new String[]{
                "d####", "ab##d",
                "a", "a",
                "##", "a#",
                "d####", "dab##",
                "", "",
                "######", "a#b#c#",
                "#####", "##a##",
                "d#", "#d"
        };

        for (int i = 0; i < io.length; i += 2) {
            assertArrayEquals(io[i].toCharArray(), BackspaceStringCompare.compress(io[i + 1].toCharArray()));
        }
    }
}
