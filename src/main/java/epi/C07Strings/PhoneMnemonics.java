package epi.C07Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneMnemonics {

    public static List<String> findAllMnemonics(String input, int start) {
        String[] numpad = new String[]{"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


        int number = input.charAt(start) - '0';
        char[] possibilities = numpad[number].toCharArray();

        if (start == input.length() - 1) {
            List<String> list = new ArrayList<>(possibilities.length);
            for (char p : possibilities) {
                list.add(String.valueOf(p));
            }
            return list;
        }

        List<String> generated = new LinkedList<>();
        for (char ch : possibilities) {
            List<String> allMnemonics = findAllMnemonics(input, start + 1);
            generated.addAll(allMnemonics.stream().map(it -> new String(ch + it)).collect(Collectors.toList()));
        }
        return generated;
    }

    public static void main(String[] args) {
        System.out.println(findAllMnemonics("22", 0));
        System.out.println(findAllMnemonics("23", 0));
        System.out.println(findAllMnemonics("27", 0));
        System.out.println(findAllMnemonics("899987", 0));
    }
}
