package clrs.c21;

import common.Status;
import common.annotations.Quality;

import java.util.*;

@Quality(Status.INCOMPLETE)
public class DisjointSets<T extends Comparable<T>> {

    private Map<T, Node<T>> allItems = new TreeMap<>();

    private List<Node<T>> sets = new LinkedList<>();

    DisjointSets(Collection<T> items) {
        for (T t : items) {
            Node<T> n = new Node<>(t);
            allItems.put(t, n);
            sets.add(n);
        }
    }

    public void union(T set1, T set2) {
        if (allItems.containsKey(set1) && allItems.containsKey(set2)) {
            Node<T> s1 = allItems.get(set1).representative;
            Node<T> s2 = allItems.get(set2).representative;

            s1.add(s2);


        }

    }

    public Node<T> findSet(T item) {
        return allItems.get(item).representative;
    }

    public boolean connected(T item1, T item2) {
        return findSet(item1).equals(findSet(item2));
    }
}

class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    Node<T> representative;
    T data;

    List<Node<T>> children = new LinkedList<>();

    Node(T t) {
        this.representative = null;
        this.data = t;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }

    public void add(Node<T> child) {
        this.children.add(child);
    }
}
