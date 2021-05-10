package leetcode;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        return checkIfValid(s, 0) == 0;
    }

    int checkIfValid(String s, int offset) {
        if (s == null || s.length() <= 0 || offset < 0) {
            return offset;
        }

        char current = s.charAt(0);

        if (current == '(') {
            return checkIfValid(s.substring(1), offset + 1);
        } else if (current == ')') {
            return checkIfValid(s.substring(1), offset - 1);
        } else {
            if (checkIfValid(s.substring(1), offset + 1) == 0) {
                return 0;
            }

            if (checkIfValid(s.substring(1), offset - 1) == 0) {
                return 0;
            }

            if (checkIfValid(s.substring(1), offset) == 0) {
                return 0;
            }
            return -1;
        }
    }
}
