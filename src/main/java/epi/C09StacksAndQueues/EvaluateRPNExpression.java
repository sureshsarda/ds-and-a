package epi.C09StacksAndQueues;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class EvaluateRPNExpression {

    private static final Map<String, BinaryOperator<Integer>> ops = new HashMap<>();

    static {
        ops.put("+", Integer::sum);
        ops.put("-", (a, b) -> a - b);
        ops.put("*", (a, b) -> a * b);
        ops.put("/", (a, b) -> a / b);
    }

    public static Integer eval(String expression) {
        String[] tokens = expression.split(",");
        Stack<Integer> s = new Stack<>();

        for (String t : tokens) {
            if ("-".equals(t) || "+".equals(t) || "/".equals(t) || "*".equals(t)) {
                try {

                    int a = s.pop();
                    int b = s.pop();
                    s.push(ops.get(t).apply(a, b));
                } catch (EmptyStackException e) {
                    throw new IllegalStateException("Expression is incomplete");
                }
            } else {
                s.push(Integer.valueOf(t));
            }
        }

        if (s.size() != 1) {
            throw new IllegalStateException("Expression is incomplete");
        }

        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println(eval("24,24,+,-24,+"));
        System.out.println(eval("24,24,/,12,12,+,+"));
    }


}
