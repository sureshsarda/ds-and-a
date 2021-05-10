package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

public class JsonFormatter {

    private static class Tokenizer implements Iterator<String> {

        private Pattern pattern = Pattern.compile("[A-Za-z0-9]+");

        private Set<String> tokens = new HashSet<>(Arrays.asList("{ } ' , : true false NaN nan : [ ]".split(" ")));

        private String rawJson;
        private int location;

        public Tokenizer(String rawJson) {
            this.rawJson = rawJson.trim();
            this.location = 0;
        }

        @Override
        public boolean hasNext() {
            return location < rawJson.length();
        }

        @Override
        public String next() {

            while (hasNext() && rawJson.charAt(location) == ' ') {
                location++;
            }

            for (String token : tokens) {
                if (rawJson.substring(location).startsWith(token)) {
                    location += token.length();
                    return token;
                }
            }

            StringBuilder sb = new StringBuilder();
            while (hasNext() && rawJson.charAt(location) <= 'z' && rawJson.charAt(location) >= 'a') {
                sb.append(rawJson.charAt(location++));
            }
            return sb.toString();
        }
    }


    static void format(String json) {
        Tokenizer tokenizer = new Tokenizer(json);

        int indent = 0;
        while (tokenizer.hasNext()) {
            String token = tokenizer.next();

            if (",".equals(token)) {
                System.out.println(",");
                for (int i = 0; i < indent; i++) {
                    System.out.print(" ");

                }
            } else if ("{".equals(token)) {
                System.out.println("{");
                indent += 4;
            } else if ("}".equals(token)) {
                System.out.println("}");
                indent -= 4;
            } else {

                System.out.print(token);
            }
        }
    }


    public static void main(String[] args) {
        format("{'foo':'bar'}");
        format("{'foo':'bar', 'bar':'baz'}");
    }

}
