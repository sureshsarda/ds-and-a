package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {


    public int lastStoneWeight(int[] stones) {
        Queue<Integer> weights = new PriorityQueue<>(Collections.reverseOrder());
        weights.addAll(Arrays.stream(stones)
                .boxed()
                .collect(Collectors.toList()));

        while (weights.size() > 1) {
            int max = weights.poll();
            int secondMax = weights.poll();

            int leftOver = max - secondMax;
            if (leftOver != 0) {
                weights.add(leftOver);
            }
        }

        return weights.isEmpty() ? 0 : weights.poll();
    }
}
