package leetcode.h00;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class N0056MergeInterval {

    private static class Interval implements Comparable<Interval> {

        Integer from;
        Integer to;

        private Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        private static Interval fromArray(int[] arr) {
            return new Interval(arr[0], arr[1]);
        }

        private int[] toArray() {
            return new int[]{from, to};
        }

        @Override
        public int compareTo(Interval that) {
            return from.compareTo(that.from);
        }

    }

    public int[][] merge(int[][] intervals) {
        Queue<Interval> interval = new PriorityQueue<>();

        for (int[] ints : intervals) {
            interval.add(Interval.fromArray(ints));
        }

        List<Interval> merged = new LinkedList<>();
        Interval last = interval.poll();
        while (!interval.isEmpty()) {
            Interval next = interval.poll();

            if (next.from <= last.to) {
                last.to = next.to;
            } else {
                merged.add(last);
                last = next;
            }
        }

        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = new int[]{merged.get(i).from, merged.get(i).to};
        }
        return result;
    }

}
