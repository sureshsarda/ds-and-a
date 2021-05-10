package leetcode.h00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class N0048_RotateImageTest {

    @Test
    public void testRotateSquare() {
        int[][] matrix = new int[][]{
                {1}
        };
        new N0048RotateImage().rotate(matrix);
        assertEquals(1, matrix[0][0]);

        matrix = new int[][]{
                {1, 2},
                {3, 4}
        };
        new N0048RotateImage().rotate(matrix);
        assertArrayEquals(new int[]{3, 1}, matrix[0]);
        assertArrayEquals(new int[]{4, 2}, matrix[1]);

        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new N0048RotateImage().rotate(matrix);
        assertArrayEquals(new int[]{7, 4, 1}, matrix[0]);
        assertArrayEquals(new int[]{8, 5, 2}, matrix[1]);
        assertArrayEquals(new int[]{9, 6, 3}, matrix[2]);

        matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new N0048RotateImage().rotate(matrix);
        assertArrayEquals(new int[]{21, 16, 11, 6, 1}, matrix[0]);
        assertArrayEquals(new int[]{22, 17, 12, 7, 2}, matrix[1]);
        assertArrayEquals(new int[]{23, 18, 13, 8, 3}, matrix[2]);
        assertArrayEquals(new int[]{24, 19, 14, 9, 4}, matrix[3]);
        assertArrayEquals(new int[]{25, 20, 15, 10, 5}, matrix[4]);
    }

    @Test
    public void testSwapWorks() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        N0048RotateImage.swap(matrix, 0, 0);
        assertEquals(21, matrix[0][0]);
        assertEquals(1, matrix[0][4]);
        assertEquals(5, matrix[4][4]);
        assertEquals(25, matrix[4][0]);

        N0048RotateImage.swap(matrix, 1, 1);
        assertEquals(8, matrix[2][3]);
        assertEquals(14, matrix[3][2]);
        assertEquals(18, matrix[2][1]);
        assertEquals(12, matrix[1][2]);
    }

    @Test
    public void testSquareRotationWorks() {

    }

}
