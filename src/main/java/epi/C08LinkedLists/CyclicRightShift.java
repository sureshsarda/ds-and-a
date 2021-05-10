package epi.C08LinkedLists;

public class CyclicRightShift {


    public static Node rightShift(Node head, int value) {
        // assumes that value is less than length of list.

        Node newHead = head;
        for (int i = 0; i < value - 1; i++) {
            newHead = newHead.next;
        }

        Node current = newHead.next;
        newHead.next = null;
        newHead = current;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = Node.sequentialList(10);
        System.out.println(head);

        head = rightShift(head, 5);
        System.out.println(head);

        head = rightShift(head, 2);
        System.out.println(head);

        // throws NPE
        head = rightShift(head, 200);
    }
}
