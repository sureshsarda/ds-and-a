package epi.C08LinkedLists;

public class TestForCycles {

    public static Node hasCycles(Node node) {
        Node fast = node;
        Node slow = node;

        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                // there is a cycle
                // we can now figure out the node with cycle
                slow = node;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    private static Node createCyclicList(int items, int cycleAt) {
        Node head = Node.sequentialList(items);
        if (cycleAt < 0) {
            return head;
        } else {
            Node at = head.nth(cycleAt);
            Node last = head.last();
            last.next = at;
            return head;
        }
    }

//    @Test
//    public void testCycle() {
//        // FIXME Rewrite the test cases that they also node with cycles
//        assertNotNull(hasCycles(createCyclicList(10, 5)));
//        assertNotNull(hasCycles(createCyclicList(10, 0)));
//        assertNotNull(hasCycles(createCyclicList(10, 9)));
//        assertNotNull(hasCycles(createCyclicList(20, 9)));
//        assertNotNull(hasCycles(createCyclicList(19, 9)));
//
//        assertNull(hasCycles(createCyclicList(10, -1)));
//        assertNull(hasCycles(createCyclicList(5, -1)));
//        assertNull(hasCycles(createCyclicList(25, -1)));
//    }
}
