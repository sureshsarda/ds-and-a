package other.trees.segment;

public class GCDNodeSegmentTree {

    private static class Node {
        int gcd;
        int from;
        int to;

        Node left;
        Node right;

        public Node(int gcd, int from, int to, Node left, Node right) {
            this.gcd = gcd;
            this.from = from;
            this.to = to;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;


    public GCDNodeSegmentTree(int[] input) {
        root = createSubTree(input, 0, input.length - 1);
    }

    private Node createSubTree(int[] input, int left, int right) {
        if (left == right) {
            return new Node(input[left], left, right, null, null);
        }

        int mid = (left + right) / 2;
        Node leftChild = createSubTree(input, left, mid);
        Node rightChild = createSubTree(input, mid + 1, right);

        return new Node(gcd(leftChild.gcd, rightChild.gcd), left, right, leftChild, rightChild);

    }

    public int query(Node node, int left, int right) {
        if (node == null || left > right) {
            return 0;
        }

        if (left == node.from && right == node.to) {
            return node.gcd;
        } else {
            int mid = (node.from + node.to) / 2;
            return gcd(query(node.left, Math.max(node.from, left), Math.min(mid, right)),
                    query(node.right, Math.max(mid + 1, left), Math.min(node.to, right)));
        }


    }


    private int gcd(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }


    public static void main(String[] args) {
        GCDNodeSegmentTree tree = new GCDNodeSegmentTree(new int[]{10, 5, 7, 12, 9, 14});

        System.out.println(tree.query(tree.root, 1, 1));
        System.out.println(tree.query(tree.root, 0, 1));
        System.out.println(tree.query(tree.root, 0, 3));
        System.out.println(tree.query(tree.root, 3, 4));
    }

}

