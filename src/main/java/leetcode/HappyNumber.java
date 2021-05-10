package leetcode;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * SingleThreadedCPI to main.java.leetcode:
 * https://leetcode.com/problems/happy-number/
 */
class HappyNumber {

    static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> alreadySeen = new TreeSet<>();

        int current = n;
        while (!alreadySeen.contains(current) && current != 1) {
            alreadySeen.add(current);
            current = squareOfDigits(current);

        }

        return current == 1;
    }

    static int squareOfDigits(int number) {
        int[] digits = intToDigits(number);
        return IntStream.of(digits).reduce(0, (a, b) -> a + b * b);
    }

    static int[] intToDigits(int number) {
        return String.valueOf(number).chars().map(it -> it - '0').toArray();
    }

}
