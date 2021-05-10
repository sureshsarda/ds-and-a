package leetcode.h16;

public class N1663SmallestStringWithGivenNumericValue {

    public String getSmallestString(int length, int sum) {
        char[] result = new char[length];

        for (int i = result.length - 1; i >= 0; i--) {
            int maxConsumable = Math.min(sum - i, 26);
            char ch = (char) ('a' + (maxConsumable - 1)); // adjusted for a
            result[i] = ch;
            sum -= maxConsumable;
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        N1663SmallestStringWithGivenNumericValue sol = new N1663SmallestStringWithGivenNumericValue();
        System.out.println(sol.getSmallestString(3, 27));
        System.out.println(sol.getSmallestString(5, 73));

    }

}
