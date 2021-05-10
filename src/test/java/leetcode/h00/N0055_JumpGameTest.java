package leetcode.h00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class N0055_JumpGameTest {


    @Test
    public void testJumps() {
        N0055JumpGame game = new N0055JumpGame();

        assertTrue(game.canJump(new int[]{1, 1, 1, 1}));
        assertTrue(game.canJump(new int[]{1, 1, 9, 1}));
        assertTrue(game.canJump(new int[]{9, 1, 9, 1}));
        assertTrue(game.canJump(new int[]{1}));
        assertTrue(game.canJump(new int[]{0}));
        assertTrue(game.canJump(new int[]{2, 5, 0, 0}));

        assertFalse(game.canJump(new int[]{0, 1, 9, 1}));
        assertFalse(game.canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
