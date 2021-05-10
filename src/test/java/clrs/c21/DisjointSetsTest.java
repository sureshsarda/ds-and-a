package clrs.c21;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisjointSetsTest {

    @Test
    public void testDisjointSetOnNetwork() {
        DisjointSet<Integer, Integer> set = new ArrayDisjointSet<>();

        for (int i = 1; i <= 10; i++) {
            set.makeSet(i);
        }

        set.union(1, 3);
        set.union(3, 4);
        set.union(3, 5);

        set.union(1, 2);
        set.union(2, 6);
        set.union(9, 10);

        // should return the representative of 2
        assertEquals(set.findSet(1), set.findSet(3));
        assertEquals(set.findSet(1), set.findSet(4));


    }


}
