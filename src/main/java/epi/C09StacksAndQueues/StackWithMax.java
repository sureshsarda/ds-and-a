package epi.C09StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class StackWithMax<T extends Comparable<T>> {

    private final List<T> stack = new ArrayList<>();
    private final List<T> max = new ArrayList<>();

    boolean isEmpty() {
        return stack.isEmpty();
    }

    void push(T t) {
        stack.add(t);
        max.add(max.size() == 0 ? t : max(max.get(max.size() - 1), t));
    }

    T pop() {
        preconditionNotEmpty();
        max.remove(max.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    T max() {
        preconditionNotEmpty();
        return max.get(max.size() - 1);
    }

    private boolean preconditionNotEmpty() {
        if (!isEmpty()) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

    private T max(T t1, T t2) {
        if (t1.compareTo(t2) > 0) {
            return t1;
        } else {
            return t2;
        }
    }

//    @Test
//    public void testMaxStackApi() {
//        StackWithMax<Integer> stack = new StackWithMax<>();
//
//        stack.push(4);
//        stack.push(3);
//        stack.push(5);
//
//        assertEquals(5, (int) stack.max());
//        assertEquals(5, (int) stack.pop());
//        assertEquals(4, (int) stack.max());
//
//    }
}
