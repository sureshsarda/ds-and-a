package other.trees.segment;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumSegmentTreeTest {

    @Test
    public void testConstruction() {

        SumSegmentTree tree =
                new SumSegmentTree(new int[]{10, 5, 3, 1, 7, 20, 55});

        assertEquals(3, tree.findInRange(2, 2));
        assertEquals(101, tree.findInRange(0, 6));
        assertEquals(10, tree.findInRange(0, 0));
        assertEquals(55, tree.findInRange(6, 6));
        assertEquals(27, tree.findInRange(4, 5));
        assertEquals(75, tree.findInRange(5, 6));

    }
}
