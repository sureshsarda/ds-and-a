package other.trees.segment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTreeTest {

    private static int gcd(Integer n1, Integer n2) {
        if (n1 == null || n1 == 0) {
            return n2;
        }
        if (n2 == null || n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    @Test
    public void testGCDSegmentTree() {
        SegmentTree<Integer> tree = new SegmentTree<>(new Integer[]{10, 5, 7, 12, 9, 14},
                SegmentTreeTest::gcd);

        System.out.println(tree.query(1, 1));
        System.out.println(tree.query(0, 1));
        System.out.println(tree.query(0, 3));
        System.out.println(tree.query(3, 4));
    }


    @Test
    public void testSumSegmentTree() {
        Integer[] input = new Integer[]{10, 5, 7, 12, 9, 14};
        SegmentTree<Integer> tree = new SegmentTree<>(input, (a, b) -> {
            if (a == null) return b;
            if (b == null) return a;
            return a + b;
        });

        assertEquals(57, (int) tree.query(0, input.length - 1));
        assertEquals(10, (int) tree.query(0, 0));
        assertEquals(34, (int) tree.query(0, 3));

    }

//    @Test
//    public void testMaximumRectangle() {
//        Integer[] input = new Integer[]{2, 1, 5, 6, 2, 3};
//        SegmentTree<Integer> tree = new SegmentTree<>(input, (a, b) -> {
//            if (a == null) return b;
//            if (b == null) return a;
//            return Math.min(a, b) * 2;
//        });
//
//        assertEquals(10, (int) tree.query(0, input.length - 1));
//    }

}
