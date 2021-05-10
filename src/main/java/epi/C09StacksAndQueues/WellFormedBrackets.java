package epi.C09StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WellFormedBrackets {

    public static boolean isCorrect(String brackets) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        Stack<Character> s = new Stack<>();

        for (Character c : brackets.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (s.isEmpty()) {
                    return false;
                } else {
                    char top = s.pop();
                    if (c != pairs.get(top)) {
                        return false;
                    }
                }
            } else {
                // ignore the characters
            }
        }

        return s.size() == 0;
    }

//    @Test
//    public void testIsCorrect() {
//        assertTrue(isCorrect("()()()"));
//        assertTrue(isCorrect("()(){}"));
//        assertTrue(isCorrect("()([])"));
//        assertTrue(isCorrect("()([{}])"));
//        assertTrue(isCorrect("(){}([{}])"));
//        assertTrue(isCorrect("(((){}([{}])))"));
//
//        assertFalse(isCorrect("(()"));
//        assertFalse(isCorrect("())"));
//        assertFalse(isCorrect("[{}]({}{[][][]}))"));
//        assertFalse(isCorrect("(]"));
//    }
}
