package leetcode.h18;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class N1823FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {
        List<Integer> players = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            players.add(i);
        }

        int i = -1;
        while (players.size() > 1) {
            i = (i + k) % players.size();
            players.remove(i);

        }

        return players.get(0) + 1;
    }

//    @Test
//    public void testFindTheWinner() {
//        N1823FindTheWinnerOfTheCircularGame instance = new N1823FindTheWinnerOfTheCircularGame();
//        assertEquals(1, instance.findTheWinner(6, 5));
//    }
}
