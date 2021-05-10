package epi.C10BinaryTrees;

public class TreeNode {
    int data;

    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String inorder() {
        StringBuilder sb = new StringBuilder();
        if (this.left != null) {
            sb.append(this.left.inorder());
        }
        sb.append(this.data);
        sb.append(" ");
        if (this.right != null) {
            sb.append(this.right.inorder());
        }
        return sb.toString();
    }

    public static TreeNode from(Integer... values) {
        Integer[] padded = new Integer[values.length + 1];
        System.arraycopy(values, 0, padded, 1, values.length);
        return from(padded, 1);
    }

    private static TreeNode from(Integer[] values, int root) {
        if (root >= values.length) {
            return null;
        }

        if (values[root] == null) {
            return null;
        }
        TreeNode node = new TreeNode(values[root]);
        node.left = from(values, root * 2);
        node.right = from(values, root * 2 + 1);

        return node;
    }

    public static final TreeNode COMPLETE_H4 = TreeNode.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    public static final TreeNode COMPLETE_H3 = TreeNode.from(1, 2, 3, 4, 5, 6, 7);
    public static final TreeNode COMPLETE_H2 = TreeNode.from(1, 2, 3);
    public static final TreeNode COMPLETE_H1 = TreeNode.from(1);

    public static final TreeNode COMPLETE_H4_BST = TreeNode.from(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15);

    public static final TreeNode SKEWED_LEFT = TreeNode.from(1, 2, null, 4, null, null, null, null, 8);


}
