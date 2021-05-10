package epi.C10BinaryTrees;

public class HeightBalanced {

    private static class HeightAndBalanced {
        int height;
        boolean isBalanced;
    }

    public static HeightAndBalanced findHeightAndBalance(TreeNode node) {
        HeightAndBalanced bad = new HeightAndBalanced();
        bad.height = 0;
        bad.isBalanced = true;

        if (node == null) {
            return bad;
        }

        HeightAndBalanced left = findHeightAndBalance(node.left);
        HeightAndBalanced right = findHeightAndBalance(node.right);

        bad.height = 1 + Math.max(left.height, right.height);
        bad.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 1;

        return bad;
    }

    public static boolean isBalanced(TreeNode node) {
        return findHeightAndBalance(node).isBalanced;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println(root.inorder());

        System.out.println(isBalanced(root));

        root = TreeNode.from(1, 2, null, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println(root.inorder());
        System.out.println(isBalanced(root));

        root = TreeNode.from(1, 2, 3, 4, 5, 6, null, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println(root.inorder());
        System.out.println(isBalanced(root));


    }
}
