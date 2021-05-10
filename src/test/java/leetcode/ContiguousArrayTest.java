package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContiguousArrayTest {

    @Test
    public void findMaxLength() {
        ContiguousArray ca = new ContiguousArray();

        assertEquals(0, ca.findMaxLength(new int[]{}));

        assertEquals(0, ca.findMaxLength(new int[]{1}));

        assertEquals(2, ca.findMaxLength(new int[]{1, 0}));
        assertEquals(2, ca.findMaxLength(new int[]{0, 1}));

        assertEquals(6, ca.findMaxLength(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0}));
        assertEquals(6, ca.findMaxLength(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0}));

        assertEquals(8, ca.findMaxLength(new int[]{1, 0, 0, 0, 1, 1, 1, 0}));

        assertEquals(6, ca.findMaxLength(new int[]{1, 0, 0, 0, 1, 1, 1}));
        assertEquals(6, ca.findMaxLength(new int[]{1, 1, 0, 0, 1, 1, 1, 0}));


    }
    }
