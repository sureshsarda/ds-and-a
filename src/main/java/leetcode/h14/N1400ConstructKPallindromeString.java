package leetcode.h14;

public class N1400ConstructKPallindromeString {
    public boolean canConstruct(String s, int k) {
        boolean[] counts = new boolean[26];

        if (s.length() < k) {
            return false;
        }

        int oddCount = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a'] = !counts[c - 'a'];
            oddCount += counts[c - 'a'] ? 1 : -1;
        }
        return oddCount <= k;
    }
}
