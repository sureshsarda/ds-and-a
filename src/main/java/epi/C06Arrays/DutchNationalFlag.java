package epi.C06Arrays;

import java.util.Arrays;

public class DutchNationalFlag {

    private static void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    public static String sort(String chars) {
        return Arrays.toString(sort(chars.toCharArray(), new char[]{'R', 'G', 'B'}));
    }

    public static char[] sort(char[] chars, char[] types) {
        int ps = 0;
        int current = 0;
        int pl = chars.length - 1;


        // assume the 3 values are known in advance
        // assume that they are R, G, B
        // sorting the array such that R appears first followed by G and lastly B
        while (current <= pl) {
            if (chars[current] == types[0]) {
                swap(chars, ps, current);
                current += 1;
                ps += 1;
            } else if (chars[current] == types[2]) {
                swap(chars, current, pl);
                pl -= 1;
            } else {
                // current = 'G', we are good and just move on
                current += 1;
            }
        }

        return chars;
    }

    public static void main(String[] args) {
        System.out.println(sort("RGRGBRBBGRGB"));
        System.out.println(sort("RGB"));
        System.out.println(sort("BBB"));
        System.out.println(sort("R"));
        System.out.println(sort("G"));
        System.out.println(sort("BBR"));
        System.out.println(sort("BRG"));
        System.out.println(sort("BRBRBR"));
        System.out.println(sort("GRGRGR"));
        System.out.println(sort("RBRBBRBRRBR"));
        System.out.println(sort("BGBGBGBRBRBGBGBRBRBRBRBGBGBGBRGBRBGRBGRBGRBGRBG"));
    }
}
