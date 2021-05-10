package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PerformStringShiftsTest {

    @Test
    public void stringShift() {
        PerformStringShifts t = new PerformStringShifts();
        assertEquals("foobar", t.stringShift("foobar", new int[][]{

        }));

        assertEquals("foobar", t.stringShift("foobar", new int[][]{
                {0, 0}
        }));

        assertEquals("rfooba", t.stringShift("foobar", new int[][]{
                {1, 1}
        }));

        assertEquals("arfoob", t.stringShift("foobar", new int[][]{
                {1, 2}
        }));

        assertEquals("obarfo", t.stringShift("foobar", new int[][]{
                {0, 2}
        }));

        assertEquals("barfoo", t.stringShift("foobar", new int[][]{
                {0, 15}
        }));

        assertEquals("barfoo", t.stringShift("foobar", new int[][]{
                {1, 15}
        }));


    }

    @Test
    public void shiftCompressor() {
        PerformStringShifts t = new PerformStringShifts();

        assertEquals(0, t.shiftCompressor(new int[][]{
                {0, 1},
                {1, 1}
        }));

        assertEquals(-5, t.shiftCompressor(new int[][]{
                {0, 1},
                {1, 1},
                {0, 5}
        }));

        assertEquals(-2, t.shiftCompressor(new int[][]{
                {0, 1},
                {1, 1},
                {0, 5},
                {0, 2},
                {1, 5}
        }));

        assertEquals(0, t.shiftCompressor(new int[][]{

        }));

        assertEquals(1, t.shiftCompressor(new int[][]{
                {1, 1}
        }));

    }

}
