package epi.C08LinkedLists;

public class AddListBasedIntegers {

    public static Node add(Node one, Node two) {
        int carry = 0;

        Node resultHead = new Node(0);
        Node result = resultHead;
        while (one != null || two != null) {
            int sum = carry;
            if (one != null) {
                sum += one.data;
                one = one.next;
            }

            if (two != null) {
                sum += two.data;
                two = two.next;
            }

            result.next = new Node(sum % 10);
            carry = sum / 10;
            result = result.next;
        }

        if (carry != 0) {
            result.next = new Node(carry);
        }

        return resultHead.next;
    }

    public static void main(String[] args) {
        Node one = Node.from(1, 2, 5, 8); // 8521
        Node two = Node.from(4, 9, 2); // 294

        Node result = add(one, two);
        System.out.println(result);

        one = Node.from(9, 9, 9);
        two = Node.from(9, 9, 9, 9, 9);

        result = add(one, two);
        System.out.println(result);

        // TODO Test more edge cases, one of the number is zero, less length

    }
}
