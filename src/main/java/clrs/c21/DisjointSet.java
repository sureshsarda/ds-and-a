package clrs.c21;

public interface DisjointSet<T, E> {

    void makeSet(T t);

    void union(T x, T y);

    E findSet(T x);

}
