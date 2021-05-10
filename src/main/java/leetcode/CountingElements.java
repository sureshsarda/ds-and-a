package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {

    public int countElements(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i : arr) {
            frequency.putIfAbsent(i, 0);
            frequency.computeIfPresent(i, (k, v) -> v + 1);
        }

        return frequency.keySet()
                .stream()
                .map(it -> frequency.getOrDefault(it - 1, 0))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
