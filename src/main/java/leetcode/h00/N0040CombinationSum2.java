package leetcode.h00;

import java.util.*;

public class N0040CombinationSum2 {

    private List<List<Integer>> findCombinations(int[] candidates, int start, int target) {
        if (target <= 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];

            if (c == target) {
                List<Integer> res = new LinkedList<>();
                res.add(c);
                result.add(res);
                break; // since array is sorted, you can be sure that next numbers will be bigger than this
            } else {

                if (i > 0 && candidates[i - 1] == candidates[i]) {
                    continue;
                }

                List<List<Integer>> out = findCombinations(candidates, i + 1, target - c);

                for (List<Integer> combi : out) {
                    combi.add(c);
                    result.add(combi);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return findCombinations(Arrays.stream(candidates).distinct().toArray(), 0, target);
    }

    public static void main(String[] args) {
        System.out.println(new N0040CombinationSum2().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));
    }
}
