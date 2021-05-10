package leetcode;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        return compareTillHash(compress(S.toCharArray()), compress(T.toCharArray()));
    }

    static boolean compareTillHash(char[] src, char[] target) {
        int index = 0;
        while (index < src.length && index < target.length) {
            if (src[index] != target[index]) {
                return false;
            }
            index++;
        }

        // after the loop, either one of th string has exhausted but they both are same till now.
        if (index == src.length && index != target.length) {
            return target[index] == '#';
        } else if (index == target.length && index != src.length) {
            return src[index] == '#';
        } else {
            return true;
        }
    }

    static char[] compress(char[] str) {
        int readPtr = 0;
        int writePtr = 0;

        while (readPtr < str.length) {
            if (str[readPtr] != '#') {
                str[writePtr] = str[readPtr];
                writePtr++;
            } else {
                writePtr = writePtr > 0 ? writePtr - 1 : 0;
            }
            readPtr++;
        }

        while (writePtr < str.length) {
            str[writePtr] = '#';
            writePtr++;
        }
        return str;
    }
}
