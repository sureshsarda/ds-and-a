package leetcode;

import java.util.*;

public class SingleThreadedCPI {

    private static class Task {
        int enqueueTime;
        int processingTime;
        int index;

        public Task(int e, int p, int i) {
            enqueueTime = e;
            processingTime = p;
            index = i;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "enqueueTime=" + enqueueTime +
                    ", processingTime=" + processingTime +
                    ", index=" + index +
                    '}';
        }
    }

    public int[] getOrder(int[][] raw) {
        List<Task> tasks = new ArrayList<>(raw.length);
        for (int i = 0; i < raw.length; i++) {
            tasks.add(new Task(raw[i][0], raw[i][1], i));
        }

        tasks.sort((o1, o2) -> {
            if (o2.enqueueTime - o1.enqueueTime == 0) {
                return o1.processingTime - o2.processingTime;
            } else {
                return o1.enqueueTime - o2.enqueueTime;
            }
        });

        Queue<Task> queue = new PriorityQueue<>(tasks.size(), (t1, t2) -> {
            if (t1.enqueueTime < t2.enqueueTime) {
                return -1;
            } else {
                if (t1.processingTime != t2.processingTime) {
                    return t1.processingTime - t2.processingTime;
                } else {
                    return t1.index - t2.index;
                }
            }

        });

        List<Integer> seq = new ArrayList<>(tasks.size());
        // iterating over the array.
        int position = 0;
        int busyTill = 0;

        while (position < tasks.size()) {
            Task nextTask = tasks.get(position);

            if (queue.isEmpty()) {
                queue.offer(nextTask);

                busyTill = nextTask.enqueueTime + nextTask.processingTime;
                position++;
            }

            Task current = queue.poll();
            seq.add(current.index);

            busyTill = busyTill + current.processingTime;

            while (position < tasks.size() && tasks.get(position).enqueueTime <= busyTill) {
                queue.offer(tasks.get(position));
                position++;
            }
        }

        while (!queue.isEmpty()) {
            Task c = queue.poll();
            seq.add(c.index);
        }

        return seq.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
//        System.out.println(Arrays.toString(new SingleThreadedCPI().getOrder(arr)));
//
//
//        arr = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
//        System.out.println(Arrays.toString(new SingleThreadedCPI().getOrder(arr)));
//
        arr = new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33,
                6}, {45, 4}, {18, 18}
                , {46, 39}, {12, 24}};
        System.out.println(Arrays.toString(new SingleThreadedCPI().getOrder(arr)));
    }
}
