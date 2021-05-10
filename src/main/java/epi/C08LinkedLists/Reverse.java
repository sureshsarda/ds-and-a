package epi.C08LinkedLists;

public class Reverse {

    public static Node reverseIterative(Node head) {
        Node previous = null;
        Node current = head;
        Node next = head.next;

        while (next != null) {
            current.next = previous;
            previous = current;

            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;
    }

    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }

        Node next = node.next;

        Node out = reverse(node.next);
        node.next = null;

        next.next = node;

        return out;

    }

    public static void main(String[] args) {
        System.out.println(reverse(Node.from(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(reverseIterative(Node.from(1, 2, 3, 4)));
    }
}
