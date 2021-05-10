package utils;

public class ArrayUtils {

    public static void swap(int[] given, int from, int to) {
        int temp = given[to];
        given[to] = given[from];
        given[from] = temp;
    }
}
