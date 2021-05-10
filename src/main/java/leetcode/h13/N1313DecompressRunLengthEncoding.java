package leetcode.h13;

import java.util.LinkedList;
import java.util.List;

public class N1313DecompressRunLengthEncoding {
    public int[] decompressRLElist(int[] nums) {

        List<Integer> decompressed = new LinkedList<>();
        for (int freqIndex = 0; freqIndex < nums.length; freqIndex += 2) {
            int number = nums[freqIndex + 1];
            int freq = nums[freqIndex];

            for (int i = 0; i < freq; i++) {
                decompressed.add(number);
            }
        }
        return decompressed.stream().mapToInt(i -> i).toArray();
    }
}
