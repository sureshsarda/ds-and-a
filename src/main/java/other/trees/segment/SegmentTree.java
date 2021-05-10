package other.trees.segment;

public class SegmentTree<A> {

    /**
     * Reducer must be null safe, either parameters can be null from time to time
     * @param <A>
     */
    public interface Reducer<A> {
        A reduce(A a1, A a2);
    }

    private static class Node<A> {
        A aggregate;
        int from;
        int to;

        Node<A> left;
        Node<A> right;

        public Node(A aggregate, int from, int to, Node<A> left, Node<A> right) {
            this.aggregate = aggregate;
            this.from = from;
            this.to = to;
            this.left = left;
            this.right = right;
        }
    }

    private final Node<A> root;
    private final Reducer<A> reducer;


    public SegmentTree(A[] input, Reducer<A> reducer) {
        this.reducer = reducer;
        root = createSubTree(input, 0, input.length - 1);
    }

    private Node<A> createSubTree(A[] input, int left, int right) {
        if (left == right) {
            return new Node<>(reducer.reduce(input[left], null), left, right, null, null);
        }

        int mid = (left + right) / 2;
        Node<A> leftChild = createSubTree(input, left, mid);
        Node<A> rightChild = createSubTree(input, mid + 1, right);

        return new Node<>(reducer.reduce(leftChild.aggregate, rightChild.aggregate), left, right, leftChild,
                rightChild);

    }

    public A query(int left, int right) {
        return query(this.root, left, right);
    }

    private A query(Node<A> node, int left, int right) {
        if (node == null || left > right) {
            return null;
        }

        if (left == node.from && right == node.to) {
            return node.aggregate;
        } else {
            int mid = (node.from + node.to) / 2;
            return reducer.reduce(query(node.left, Math.max(node.from, left), Math.min(mid, right)),
                    query(node.right, Math.max(mid + 1, left), Math.min(node.to, right)));
        }


    }

}
