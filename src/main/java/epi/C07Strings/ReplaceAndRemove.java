package epi.C07Strings;

public class ReplaceAndRemove {

    public static char[] replaceAndRemove(char[] chars) {
        /*
        Replace a by 2d and remove b, assume there is plenty of space in input array
         */
        int aCount = 0;
        int writeIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'b') {
                chars[writeIndex++] = chars[i];
            }

            if (chars[i] == 'a') {
                aCount += 1;
            }
        }

        // now start writing the things from the end
        int readIndex = writeIndex - 1;
        writeIndex = readIndex + aCount;

        if (writeIndex > chars.length - 1) {
            System.err.println("Too many values to write in the array");
        }

        while (readIndex >= 0) {
            if (chars[readIndex] == 'a') {
                chars[writeIndex--] = 'd';
                chars[writeIndex--] = 'd';
            } else {
                chars[writeIndex--] = chars[readIndex];
            }
            readIndex--;
        }

        return chars;
    }

//    @Test
//    public void testReplaceAndRemove() {
//        String[] io = new String[]{
//                "acdbbca", "ddcdcdd", "ab", "dd"
//        };
//
//        for (int i = 0; i < io.length; i += 2) {
//            assertArrayEquals(io[i + 1].toCharArray(), replaceAndRemove(io[i].toCharArray()));
//        }
//        assertArrayEquals("dd".toCharArray(), replaceAndRemove("ab".toCharArray()));
//    }
}
