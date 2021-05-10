package epi.C08LinkedLists;

public class RemoveKthElement {

    public static void removeKthElementFromLast(Node head, int kth) {
        Node advance = head.nth(kth);

        while (advance.next != null) {
            advance = advance.next;
            head = head.next;
        }

        // head is pointing to the node one before that needs to be removed
        head.next = head.next.next;
    }

    public static void removeKthElement(Node head, int kth) {
        // stop one element before
        Node current = head;
        for (int i = 0; i < kth - 1; i++) {
            current = current.next;
        }

        // now remove the next element
        current.next = current.next.next;
    }

    public static void main(String[] args) {
        Node head = Node.sequentialList(10);
        System.out.println(head);

        removeKthElement(head, 4);
        System.out.println(head);

        removeKthElement(head, 4);
        System.out.println(head);

        removeKthElement(head, 1);
        System.out.println(head);

        removeKthElement(head, head.length() - 1);
        System.out.println(head);

        head = Node.sequentialList(10);
        System.out.println(head);

        removeKthElementFromLast(head, 2);
        System.out.println(head);

        removeKthElementFromLast(head, 5);
        System.out.println(head);

        removeKthElementFromLast(head, 1);
        System.out.println(head);
    }

}
