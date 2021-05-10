package epi.C07Strings;

public class ReverseAllWords {

    public static String reversed(String input) {
        char[] chars = input.toCharArray();

        reverse(chars, 0, chars.length - 1);

        for (int i = 0; i < chars.length; i++) {
            int start = i;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            reverse(chars, start, i - 1);
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

//    @Test
//    public void testReverse() {
//        String[] inputs = new String[]{
//                "how are you doing",
//                "hello",
//                "hello world",
//        };
//
//        for (String input : inputs) {
//            List<String> words = Arrays.asList(input.split(" "));
//            Collections.reverse(words);
//            assertEquals(String.join(" ", words), reversed(input));
//        }
//    }
}
