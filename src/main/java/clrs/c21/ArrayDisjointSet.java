package clrs.c21;

import java.util.ArrayList;
import java.util.List;

public class ArrayDisjointSet<T> implements DisjointSet<T, Integer> {

    private List<T> data = new ArrayList<>();
    private List<Integer> setIds = new ArrayList<>();

    int nextId = 0;

    @Override
    public void makeSet(T t) {
        data.add(t);
        setIds.add(nextId++);
    }

    @Override
    public void union(T x, T y) {
        int indexOfx = data.indexOf(x);
        int indexOfy = data.indexOf(y);

        int setIdx = setIds.get(indexOfx);
        int setIdy = setIds.get(indexOfy);

        for (int i = 0; i < setIds.size(); i++) {
            if (setIds.get(i) == setIdy) {
                setIds.set(i, setIdx);
            }
        }
    }

    @Override
    public Integer findSet(T x) {
        int indexOfx = data.indexOf(x);
        int setId = setIds.get(indexOfx);
        return setId;
    }
}
