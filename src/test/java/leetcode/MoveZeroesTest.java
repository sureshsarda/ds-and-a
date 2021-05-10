package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveZeroesTest {

    @Test
    public void testMoveZero() {

        int[] input;
        int[] output;

        input = new int[]{0, 1, 0, 3, 12};
        output = new int[]{1, 3, 12, 0, 0};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(output, input);

        input = new int[]{0};
        output = new int[]{0};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(output, input);

        input = new int[]{0, 1};
        output = new int[]{1, 0};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(output, input);

        input = new int[]{-1, 1};
        output = new int[]{-1, 1};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(output, input);

    }

}
