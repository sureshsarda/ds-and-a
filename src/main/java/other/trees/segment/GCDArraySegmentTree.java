package other.trees.segment;

import java.util.Arrays;

public class GCDArraySegmentTree {

    private int[] nodes;

    public GCDArraySegmentTree(int[] input) {
        nodes = new int[input.length * 4];
        createTree(input, 1, 0, input.length - 1);
    }

    private void createTree(int[] input, int node, int left, int right) {
        if (left == right) {
            nodes[node] = input[left];
        } else {
            int mid = (right + left) / 2;
            createTree(input, node * 2, left, mid);
            createTree(input, node * 2 + 1, mid + 1, right);
            nodes[node] = gcd(nodes[node * 2], nodes[node * 2 + 1]);
        }

    }


    private int query(int node, int ql, int qr, int rl, int rr) {
        if (ql > qr) {
            return 1;
        }

        if (ql == rl && qr == rr) {
            return nodes[node];
        }

        int mid = (rl + rr) / 2;
//        int lv = query(node * 2, rl, mid, );
//        int rv = query(node * 2 + 1, mid + 1, rr, )
        return 0;


    }

    public int query(int left, int right) {
        return query(1, left, right, left, right);
    }


    private int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GCDArraySegmentTree(new int[]{10, 5, 7, 12, 9, 14}).nodes));


    }

}
