package clrs.c22;

import java.util.List;

public interface GraphTraverser<T> {

    public List<Integer> traverse(Graph<T> g, int source);
}
