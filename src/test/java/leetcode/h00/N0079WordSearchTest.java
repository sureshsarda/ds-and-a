package leetcode.h00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class N0079WordSearchTest {

    @Test
    public void testExist() {
        N0079WordSearch instance = new N0079WordSearch();

        char[][] board = new char[][]{
                toChar("ABCE"),
                toChar("SFCS"),
                toChar("ADEE"),
        };
        assertTrue(instance.exist(board, "ABCCED"));

        board = new char[][]{{'A'}};
        assertTrue(instance.exist(board, "A"));

        board = new char[][]{
                toChar("ABCE"),
                toChar("SFCS"),
                toChar("ADEE"),
        };
        assertFalse(instance.exist(board, "ABCB"));

        board = new char[][]{
                toChar("ABCDEFABCBCABAAABGKHIEEACED"),
        };
        assertTrue(instance.exist(board, "ACED"));
        assertTrue(instance.exist(board, "ED"));
        assertFalse(instance.exist(board, "ABCDEFGH"));


        board = new char[][]{
                toChar("A"),
                toChar("A"),
                toChar("B"),
                toChar("C"),
                toChar("D"),
        };
        assertTrue(instance.exist(board, "ABC"));
        assertTrue(instance.exist(board, "AA"));
        assertTrue(instance.exist(board, "CD"));
        assertFalse(instance.exist(board, "AAA"));
        assertFalse(instance.exist(board, "ABA"));

        board = new char[][]{
                toChar("AB"),
                toChar("CD"),
        };
        assertTrue(instance.exist(board, "AB"));
        assertTrue(instance.exist(board, "DB"));
        assertTrue(instance.exist(board, "CD"));
        assertTrue(instance.exist(board, "CA"));
        assertTrue(instance.exist(board, "CABD"));
        assertFalse(instance.exist(board, "ABCD"));


        board = new char[][]{
                toChar("ABCE"),
                toChar("SFES"),
                toChar("ADEE"),
        };
        assertTrue(instance.exist(board, "ABCESEEEFS"));

    }

    private static char[] toChar(String s) {
        return s.toCharArray();
    }

}
