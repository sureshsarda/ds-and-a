package clrs.c21;

import common.Status;
import common.annotations.Quality;

import java.util.*;

@Quality(Status.INCOMPLETE)
public class DisjointSetNaive<T, E> implements DisjointSet<T, E> {

    /*
    Implementation Note:

    Implemented using multiple sets using standard Java constructs
     */

    Map<UUID, Set<T>> sets = new HashMap<>();

    @Override
    public void makeSet(T t) {
        Set<T> s = new HashSet<>();
        s.add(t);
        sets.put(UUID.randomUUID(), s);
    }

    @Override
    public void union(T x, T y) {
    }

    @Override
    public E findSet(T x) {
        return null;
    }
}
