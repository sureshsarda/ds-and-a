package epi.C07Strings;

public class RunLengthEncoding {

    public static String encode(String input) {
        int readIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (readIndex < input.length()) {
            // take the character here, repeat mistake
            char ch = input.charAt(readIndex);
            int count = 0;
            // Make sure you put the length comparision on inner loop as well, repeat mistake
            while (readIndex < input.length() && input.charAt(readIndex) == ch) {
                count++;
                readIndex++;
            }
            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String decode(String compressed) {
        int readIndex = 0;

        StringBuilder sb = new StringBuilder();
        while (readIndex < compressed.length()) {
            int count = 0;

            while ('0' <= compressed.charAt(readIndex) && compressed.charAt(readIndex) <= '9') {
                count = count * 10 + compressed.charAt(readIndex) - '0';
                readIndex++;
            }

            char ch = compressed.charAt(readIndex);

            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }

            readIndex++;
        }

        return sb.toString();
    }

//    @Test
//    public void testEncode() {
//        assertEquals("4a", encode("aaaa"));
//        assertEquals("1a", encode("a"));
//        assertEquals("1a2b1c1d", encode("abbcd"));
//        assertEquals("14a1d2e1f1e1f13b", encode("aaaaaaaaaaaaaadeefefbbbbbbbbbbbbb"));
//
//    }
//
//
//    @Test
//    public void testDecode() {
//        assertEquals("aaaa", decode("4a"));
//        assertEquals("a", decode("1a"));
//        assertEquals("aaaaaaaaaaaaaadeefefbbbbbbbbbbbbb", decode("14a1d2e1f1e1f13b"));
//
//    }
//
//    @Test
//    public void testEncodeAndDecode() {
//        assertEquals("aaaabbbbbcdeeeaadff", decode(encode("aaaabbbbbcdeeeaadff")));
//    }
}
