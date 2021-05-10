package epi.C08LinkedLists;

public class RemoveDuplicatesForSortedList {

    public static void removeDuplicates(Node node) {
        while (node != null) {
            int data = node.data;

            Node advance = node.next;
            while (advance != null && advance.data == data) {
                advance = advance.next;
            }

            node.next = advance;
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = Node.from(0, 0, 0, 1, 1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 9);
        removeDuplicates(head);
        System.out.println(head);
    }

}
