package epi.C08LinkedLists;

public class TestPallindrome {

    private static Node testPallindrome(Node left, Node right) {
        if (right.next != null) {
            left = testPallindrome(left, right.next);
        }

        if (left == null) {
            return null;
        }

        if (left.data == right.data) {
            return left.next;
        } else {
            return null;
        }
    }

    public static boolean isPallindrome(Node head) {
        return testPallindrome(head, head) != null;
    }
}
