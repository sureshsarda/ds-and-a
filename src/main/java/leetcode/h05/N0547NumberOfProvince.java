package leetcode.h05;

import java.util.*;

public class N0547NumberOfProvince {

    private static class ArrayDisjointSet<T> {

        private List<T> data = new ArrayList<>();
        private List<Integer> setIds = new ArrayList<>();

        int nextId = 0;

        public void makeSet(T t) {
            data.add(t);
            setIds.add(nextId++);
        }

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

        public Integer findSet(T x) {
            int indexOfx = data.indexOf(x);
            int setId = setIds.get(indexOfx);
            return setId;
        }

        public Integer sets() {
            return new HashSet<Integer>(setIds).size();
        }
    }


    public int findCircleNum(int[][] isConnected) {
        ArrayDisjointSet<Integer> set = new ArrayDisjointSet<Integer>();

        for (int i = 0; i < isConnected.length; i++) {
            set.makeSet(i);
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }

        return set.sets();
    }

    public int findCircleNumDFS(int[][] isConnected) {
        TreeSet<Integer> remaining = new TreeSet<>();
        Set<Integer> visited = new HashSet<>();



        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            remaining.add(i);
        }

        while (remaining.size() > 0) {
            TreeSet<Integer> pending = new TreeSet<>();

            provinces++;

            pending.add(remaining.first());
            while (pending.size() > 0) {
                int current = pending.first();
                for (int i = 0; i < isConnected[current].length; i++) {
                    if (isConnected[current][i] == 1) {
                        remaining.remove(i);

                        if (!visited.contains(i)) {
                            pending.add(i);
                        }
                    }
                }
                pending.remove(current);
                visited.add(current);
            }

        }

        return provinces;
    }
}
