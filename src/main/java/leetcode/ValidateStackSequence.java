package leetcode;

import java.util.*;

/*
Note this can be done in place as well
*/

public class ValidateStackSequence {


}
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int pop = 0;
        for (int push = 0; push < pushed.length; push++) {
            stack.push(pushed[push]);
            while (stack.size() > 0 && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.size() == 0;
    }
}
