package leetcode;

import java.util.*;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String str : strs) {
            String key = convertToKey(str);
            if (!groupedAnagrams.containsKey(key)) {
                groupedAnagrams.put(key, new LinkedList<>());
            }
            groupedAnagrams.get(key).add(str);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }

    static String convertToKey(String word) {
        char[] wordCopy = word.toCharArray();
        int[] histogram = new int[26];

        for (char c : wordCopy) {
            histogram[c - 'a'] += 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] != 0) {
                char ch = (char) (i + 'a');
                builder.append(ch);
                builder.append(histogram[i]);
            }
        }
        return builder.toString();

    }

}
