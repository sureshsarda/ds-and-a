package epi.C07Strings;

import java.util.*;

public class ComputeValidIPAddresses {

    public static List<int[]> compute(String input, int position, int charIndex) {
        // 1921680200
        // yield all number, break if
        // number is greater than 255
        // or you are not last but string has ended
        if (position == 3) {
            int value = getValidNumber(input, charIndex, input.length());
            if (value == -1) {
                return null;
            } else {
                int[] ip = new int[4];
                ip[3] = value;
                return Collections.singletonList(ip);
            }
        } else if (position >= 0 && position < 3) {
            // I can generate a 3 digit number from here
            List<int[]> generated = new LinkedList<>();

            for (int i = 1; i <= 3; i++) {
                int endIndex = charIndex + i;
                // at least one digit should be there for each positions
                if (endIndex > input.length() - (3 - position)) {
                    break;
                }
                int value = getValidNumber(input, charIndex, charIndex + i);
                if (value != -1) {

                    List<int[]> out = compute(input, position + 1, charIndex + i);
                    if (out == null) {
                        continue;
                    }
                    for (int[] ip : out) {
                        ip[position] = value;
                        generated.add(ip);
                    }
                }
            }
            return generated;
        } else {
            throw new IllegalArgumentException("Invalid position");
        }
    }

    private static int getValidNumber(String input, int from, int to) {
        if (input.charAt(from) == '0') {
            return -1;
        }
        int value = Integer.parseInt(input.substring(from, to));

        if (value > 255) {
            return -1;
        }
        return value;
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{
                "19216811",
                "0000",
                "255255255255",
                "1010190200"
        };

        for (String in : inputs) {
            List<int[]> ips = compute(in, 0, 0);
            for (int[] ip : ips) {
                System.out.println(Arrays.toString(ip));
            }
        }
    }
}
