package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesisStringTest {

    @Test
    public void checkValidString() {
        ValidParenthesisString vps = new ValidParenthesisString();
        assertTrue(vps.checkValidString(""));
        assertTrue(vps.checkValidString("()"));
        assertTrue(vps.checkValidString("(*)"));
        assertTrue(vps.checkValidString("(**)"));
        assertTrue(vps.checkValidString("()()()"));
        assertTrue(vps.checkValidString("((*)"));
        assertTrue(vps.checkValidString("(*))"));

        assertTrue(vps.checkValidString("()()****()(*)((**"));
        assertTrue(vps.checkValidString("()()****()(*)((***"));

        assertTrue(vps.checkValidString("**"));
        assertTrue(vps.checkValidString("(**"));
        assertTrue(vps.checkValidString("*)*"));


        assertFalse(vps.checkValidString("*("));

        assertFalse(vps.checkValidString("((((((("));
        assertFalse(vps.checkValidString("))"));


        assertFalse(vps.checkValidString("**((((*)(*((((((((*)((*)"));


        assertFalse(vps.checkValidString(")("));
        assertFalse(vps.checkValidString("*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)"));


    }

    @Test
    public void checkIfValid() {
        ValidParenthesisString vps = new ValidParenthesisString();
        assertEquals(0, vps.checkIfValid("()", 0));
        assertEquals(1, vps.checkIfValid("(()", 0));

        assertEquals(0, vps.checkIfValid("*)", 2));


    }
}
