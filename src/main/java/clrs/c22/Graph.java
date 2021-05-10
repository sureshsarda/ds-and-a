package clrs.c22;

import java.util.Set;

public interface Graph<T> {

    Set<Vertex<T>> neighborsOf(Vertex<T> i);
}
