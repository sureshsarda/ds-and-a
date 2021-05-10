package leetcode.h00;

import java.util.HashSet;
import java.util.Set;

public class N0079WordSearch {

    public boolean findHere(char[][] board, int i, int j, String word, int remainingWord, Set<String> visited) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return false;
        }

        String visit = i + "," + j;
        if (board[i][j] == word.charAt(remainingWord) && !visited.contains(visit)) {

            if (remainingWord == word.length() - 1) {
                return true;
            }

            visited.add(visit);

            boolean found = findHere(board, i - 1, j, word, remainingWord + 1, visited) ||
                    findHere(board, i + 1, j, word, remainingWord + 1, visited) ||
                    findHere(board, i, j - 1, word, remainingWord + 1, visited) ||
                    findHere(board, i, j + 1, word, remainingWord + 1, visited);
            if (!found) {
                visited.remove(visit);
            }
            return found;
        } else {
            return false;
        }
    }


    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findHere(board, i, j, word, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
}
