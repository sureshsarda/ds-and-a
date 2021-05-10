package other.coderbyte;

import java.util.*;

class Main {

    private static enum Type {
        BRACKET_LEFT(3),
        BRACKET_RIGHT(3),
        DIVIDE(2),
        MULTIPLY(2),
        PLUS(1),
        MINUS(1),
        DIGIT(0);

        int priority;

        private Type(int priority) {
            this.priority = priority;
        }
    }

    private static class Token {
        private Type type;
        private String token;

        private Token(Type type, String token) {
            this.type = type;
            this.token = token;
        }

        private Token(Type type, char ch) {
            this(type, String.valueOf(ch));
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", token='" + token + '\'' +
                    '}';
        }
    }

    private static class ExpressionParser implements Iterator<Token> {

        private final char[] input;
        private int index;

        private ExpressionParser(String input) {
            this.input = input.toCharArray();
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < input.length;
        }

        @Override
        public Token next() {
            if (hasNext()) {

                char current = input[index];
                if (isDigit(input[index])) {

                    StringBuilder sb = new StringBuilder();
                    while (hasNext() && isDigit(input[index])) {
                        sb.append(input[index++]);
                    }
                    return new Token(Type.DIGIT, sb.toString());
                } else if (current == '(') {
                    index++;
                    return new Token(Type.BRACKET_LEFT, current);
                } else if (current == ')') {
                    index++;
                    return new Token(Type.BRACKET_RIGHT, current);
                } else if (current == '+') {
                    index++;
                    return new Token(Type.PLUS, current);
                } else if (current == '-') {
                    index++;
                    return new Token(Type.MINUS, current);
                } else if (current == '/') {
                    index++;
                    return new Token(Type.DIVIDE, current);
                } else if (current == '*') {
                    index++;
                    return new Token(Type.MULTIPLY, current);
                } else {
                    throw new IllegalArgumentException("Incorrect input");
                }
            } else {
                throw new IllegalStateException("Iterator is empty");
            }
        }
    }

    private static boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }


    private static List<String> infixToPostFix(String str) {
        final List<String> tokens = new ArrayList<>();
        final Deque<Token> stack = new ArrayDeque<>();

        ExpressionParser parsr = new ExpressionParser(str);

        while (parsr.hasNext()) {
            Token next = parsr.next();
            if (next.type == Type.DIGIT) {
                tokens.add(next.token);
            } else if (next.type == Type.BRACKET_LEFT) {
                tokens.add(next.token);
            } else if (next.type == Type.BRACKET_RIGHT) {
                // pop till empty or left
                while (!stack.isEmpty() && stack.peek().type != Type.BRACKET_LEFT) {
                    tokens.add(stack.pop().token);
                }
            } else {
                while (!stack.isEmpty() && next.type.priority < stack.peek().type.priority) {
                    tokens.add(stack.pop().token);
                }
                stack.push(next);
            }


        }

        while (!stack.isEmpty()) {
            tokens.add(stack.pop().token);
        }
        return tokens;
    }

    public static String MathChallenge(String str) {
        List<String> postfix = infixToPostFix(str);
        System.out.println(postfix);

        // code goes here
        return str;
    }

    public static void main(String[] args) {
        // keep this function call here
        MathChallenge("2+(3-1)*3");
    }

}
