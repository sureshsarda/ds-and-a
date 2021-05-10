package epi.C08LinkedLists;

public class MergeSortedLists {


    public static Node merge(Node n1, Node n2) {
        Node head;
        Node last = null;

        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        if (n1.data < n2.data) {
            head = n1;
            last = n1;
            n1 = n1.next;
        } else {
            head = n2;
            last = n2;
            n2 = n2.next;
        }

        while (n1 != null || n2 != null) {
            if (n1 == null) {
                last.next = n2;
                break;
            }

            if (n2 == null) {
                last.next = n1;
                break;
            }
            if (n1.data < n2.data) {
                Node next = n1.next;
                last.next = n1;
                n1 = next;
            } else {
                Node next = n2.next;
                last.next = n2;
                n2 = next;
            }
            last = last.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node merged = merge(Node.from(1, 3, 5, 7, 9, 11, 13, 15, 17), Node.from(2, 4, 6, 8));
        System.out.println(merged.toString());
    }
}

