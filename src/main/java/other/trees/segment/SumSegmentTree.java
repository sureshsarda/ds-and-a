package other.trees.segment;

public class SumSegmentTree {

    private static class Node {
        int data;
        int from;
        int to;
        Node left;
        Node right;

        public Node(int data, int from, int to, Node left, Node right) {
            this.data = data;
            this.from = from;
            this.to = to;
            this.left = left;
            this.right = right;
        }
    }

    private final Node root;

    public SumSegmentTree(int[] arr) {
        root = construct(arr, 0, arr.length - 1);
    }

    private Node construct(int[] arr, int from, int to) {
        if (from == to) {
            return new Node(arr[from], from, to, null, null);
        } else {
            int mid = from + (to - from) / 2;
            Node left = construct(arr, from, mid);
            Node right = construct(arr, mid + 1, to);

            return new Node(left.data + right.data, from, to, left, right);
        }
    }

    private int findInRange(Node node, int from, int to) {
        if (node == null || from > to || node.to < from || node.from > to) {
            return 0;
        }

        if (from == node.from && to == node.to) {
            System.out.println("Exact match: " + node.data);
            return node.data;
        }

        System.out.printf("Node: %d, From: %d, To: %d\n", node.data, from, to);
        int res = 0;

        // TODO isn't there a better way to do this?
        res += findInRange(node.left, Math.max(node.left.from, from), Math.min(node.left.to, to));
        res += findInRange(node.right, Math.max(node.right.from, from), Math.min(node.right.to, to));
        return res;
    }


    public int findInRange(int from, int to) {
        return findInRange(root, from, to);
    }

    private String toString(Node node, int indent) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        sb.append(String.format("%d(%d-%d)\n", node.data, node.from, node.to));
        if (node.left != null) {
            sb.append(toString(node.left, indent + 4));
        }

        if (node.right != null) {
            sb.append(toString(node.right, indent + 4));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(this.root, 0);
    }
}
