package leetcode.h00;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class N0068TextJustify {

    private static class TextJustifier {

        final int maxWidth;;

        List<String> lines = new LinkedList<>();
        List<String> currentLine = new LinkedList<>();

        int remaining;

        public TextJustifier(int maxWidth) {
            this.maxWidth = maxWidth;
            remaining = maxWidth;
        }


        private void feed(String w) {
            if (remaining < w.length() + 1) {
                startNewLine();
            }
            currentLine.add(w);
            remaining = remaining - w.length() - 1;

        }

        private void startNewLine() {
            flushCurrentLine();
            currentLine = new LinkedList<>();
            remaining = maxWidth;
        }

        private void flushCurrentLine() {
            // itn len = maxWidth - currentLine.stream().map(String::length).sum();
            int spaceCount = maxWidth - currentLine.stream().mapToInt(String::length).sum();

            int[] spaces = new int[currentLine.size() - 1];

            int position = 0;
            while (spaceCount > 0) {
                spaces[position] += 1;
                spaceCount -= 1;
                position = (position + 1) % spaces.length;
            }


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentLine.size() - 1; i++) {
                sb.append(currentLine.get(i));
                addSpaces(sb, spaces[i]);
            }
            sb.append(currentLine.get(currentLine.size() - 1));
            lines.add(sb.toString());


        }

        private void close() {
            currentLine.stream().collect(Collectors.joining(" "));
            StringBuilder sb = new StringBuilder();
            for (String w: currentLine) {
                sb.append(w);
                sb.append(' ');
            }
            lines.add(sb.toString());
        }


        private void addSpaces(StringBuilder sb, int count) {
            for (int i = 0; i < count; i++) {
                sb.append(' ');
            }
        }


    }


    public List<String> fullJustify(String[] words, int maxWidth) {

        TextJustifier tj = new TextJustifier(maxWidth);
        for (String w : words) {
            tj.feed(w);
        }
        tj.close();

        return tj.lines;


    }
}
