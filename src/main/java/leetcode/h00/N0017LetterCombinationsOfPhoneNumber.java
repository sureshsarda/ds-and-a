package leetcode.h00;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N0017LetterCombinationsOfPhoneNumber {
    private static final String[][] KEYPAD = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"},
            {"J", "K", "L"},
            {"M", "N", "O"},
            {"P", "Q", "R", "S"},
            {"T", "U", "V"},
            {"W", "X", "Y", "Z"},
    };

    private String[] lettersAt(String digits, int position) {
        int number = digits.charAt(position) - '0';
        if (number >= 2 && number <= 9) {
            return KEYPAD[number - 2];
        } else {
            return new String[0];
        }
    }

    private List<String> combinations(String digits, int position, List<String> soFar) {
        if (position >= digits.length()) {
            return soFar;
        }

        String[] letters = lettersAt(digits, position);

        List<String> out = new LinkedList<>();
        for (String letter : letters) {
            if (soFar.size() > 0) {
                for (String sof : soFar) {
                    out.add(sof + letter);
                }
            } else {
                out.add(letter);
            }

        }
        return combinations(digits, position + 1, out);
    }

    public List<String> letterCombinations(String digits) {
        return combinations(digits, 0, Collections.emptyList());
    }

    public static void main(String[] args) {
        new N0017LetterCombinationsOfPhoneNumber().letterCombinations("23");
    }
}
