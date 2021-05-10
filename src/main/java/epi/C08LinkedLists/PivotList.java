package epi.C08LinkedLists;

public class PivotList {

    public static Node pivot(Node head, int value) {
        Node leftHead = new Node(0);
        Node rightHead = new Node(0);

        Node left = leftHead;
        Node right = rightHead;

        while (head != null) {
            if (head.data < value) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        left.next = rightHead.next; // skip the dummy entry
        right.next = null;
        return leftHead.next;
    }

    public static void main(String[] args) {
        Node head = Node.from(10, 12, 4, 3, 12, 16, 2, 8, 6, 67, 87, 5, 15, 19);
        Node newHead = pivot(head, 20);
        System.out.println(newHead);
    }
}
