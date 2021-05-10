package leetcode;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        int oneShift = shiftCompressor(shift);

        if (oneShift > 0) {
            oneShift %= s.length();
            String prefix = s.substring(s.length() - oneShift);
            String suffix = s.substring(0, s.length() - oneShift);
            return prefix + suffix;
        } else if (oneShift < 0) {
            oneShift *= -1;
            oneShift %= s.length();
            String prefix = s.substring(oneShift);
            String suffix = s.substring(0, oneShift);
            return prefix + suffix;
        } else {
            return s;
        }
    }

    /**
     * Cancels left and right shifts and gives a single number at the end. The number will be negative if left shift and
     * positive for right shift.
     *
     * @param shifts given set of shift. Each shift should be an array of length 2, the first element should be
     *               direction and the second element should be the amount
     *
     * @return the amount and direction of shift
     */
    int shiftCompressor(int[][] shifts) {
        int shift = 0; // negative number will be left and positive number will be right like on a number axes

        for (int[] shiftRecord : shifts) {
            if (shiftRecord[0] == 0) {
                shift -= shiftRecord[1];
            } else {
                shift += shiftRecord[1];
            }
        }
        return shift;
    }
}
