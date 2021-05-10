package epi.C08LinkedLists;

public class DeleteANode {

    public static void delete(Node nodeToDelete) {
        if (nodeToDelete.next == null) {
            throw new IllegalArgumentException("This method does not support deleting last node");
        }
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }

    public static void main(String[] args) {
        Node head = Node.sequentialList(10);
        System.out.println(head);

        delete(head.nth(5));
        System.out.println(head);

        delete(head.nth(8));
        System.out.println(head);

        delete(head.nth(0));
        System.out.println(head);
    }

}
