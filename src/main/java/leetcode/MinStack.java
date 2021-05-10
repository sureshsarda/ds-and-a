package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private final List<Integer> stackValues;
    private final List<Integer> minValues;

    public MinStack() {
        stackValues = new LinkedList<>();
        minValues = new LinkedList<>();
    }

    public void push(int x) {
        stackValues.add(x);

        if (minValues.isEmpty()) {
            minValues.add(x);
        } else {
            int lastMin = minValues.get(minValues.size() - 1);
            minValues.add(Math.min(x, lastMin));
        }
    }

    public void pop() {
        if (stackValues.isEmpty()) {
            return;
        }
        stackValues.remove(minValues.size() - 1);
        minValues.remove(minValues.size() - 1);

    }

    public int top() {
        if (stackValues.isEmpty()) {
            return 0;
        }
        return stackValues.get(minValues.size() - 1);
    }

    public int getMin() {
        if (minValues.isEmpty()) {
            return 0;
        } else {
            return minValues.get(minValues.size() - 1);
        }
    }
}

