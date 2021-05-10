package leetcode.h03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N0378KthSmallestInSortedMatrix {
    /*
    Ideas: Use heaps to keep items when you want max or min
    Ideas: You could have used binary search
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i * j + i + j > k) {
                    continue;
                }

                int number = matrix[i][j];
                if (maxHeap.isEmpty() || number < maxHeap.peek()|| maxHeap.size() <= k) {
                    maxHeap.add(number);
                }

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }


    public static void main(String[] args) {
        System.out.println(new N0378KthSmallestInSortedMatrix().kthSmallest(
                new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 6
        ));
    }


}
