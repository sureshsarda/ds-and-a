package epi.C08LinkedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForOverlappingLists {

    // lists are overlapping if they both end at the same node
    // challenge is to find the node at which they merge
    // advance the longer list by length in delta, and then move
    // them together till we have a main.java.common node.

    public static Node testOverlapping(Node l1, Node l2) {
        int l1Length = l1.length();
        int l2Length = l2.length();

        if (l1Length > l2Length) {
            int delta = l1Length - l2Length;
            l1 = l1.nth(delta);
        } else {
            int delta = l2Length - l1Length;
            l2 = l2.nth(delta);
        }

        while (l1 != l2) {
            l2 = l2.next;
            l1 = l1.next;
        }

        return l1;
    }

    @Test
    public void testOverlappingWhenListsAreAppendedInMiddle() {
        Node l1 = Node.sequentialList(10); // 0 to 9
        Node l2 = Node.sequentialList(5); // 0 to 4

        Node l1Fifth = l1.nth(5);
        l2.last().next = l1Fifth;

        Node common = testOverlapping(l1, l2);
        assertEquals(common, l1Fifth);

        l1 = Node.sequentialList(5);
        l2 = Node.sequentialList(11);

        Node l1Third = l1.nth(3);
        l2.last().next = l1Third;

        common = testOverlapping(l1, l2);
        assertEquals(common, l1Third);
    }

    @Test
    public void testWhenListsAreAppendedInTheEnd() {
        Node l1 = Node.sequentialList(10);
        Node l2 = Node.sequentialList(10);

        l1.last().next = l2;

        Node out = testOverlapping(l1, l2);
        assertEquals(l2, out);
    }
}
