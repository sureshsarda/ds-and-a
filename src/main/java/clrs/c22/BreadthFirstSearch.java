package clrs.c22;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<T> implements GraphTraverser<T> {

    @Override
    public List<Integer> traverse(Graph<T> g, int source) {
        Queue<Integer> pending = new LinkedList<>();
        pending.offer(source);

        while (!pending.isEmpty()) {

        }
        return null;
    }
}
