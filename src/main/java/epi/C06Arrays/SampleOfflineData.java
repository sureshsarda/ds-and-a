package epi.C06Arrays;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class SampleOfflineData {

    public static int[] sample(int[] given, double percentage) {
        int sampleSize = (int) Math.floor(given.length * percentage);
        Random rand = new Random();

        for (int i = 0; i < sampleSize; i++) {
            int index = rand.nextInt(given.length - i);
            ArrayUtils.swap(given, index, given.length - 1 - i);
        }

        return Arrays.copyOfRange(given, given.length - sampleSize, given.length);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sample(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 0.25)));
    }
}
