package leetcode;

class MiddleOfTheLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head; // fast moves twice the speed

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // even number of nodes
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
    }

    /* Test cases
    [1,2,3,4,5]
    [1]
    [1,2,3]
    [1,2,3,4]
    [1,2,3,4,5]
     */

}
