package epi.C10BinaryTrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymmetricalTree {

    private static boolean isSymmetricalHere(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null || right == null && left != null) {
            return false;
        }

        if (left.data != right.data) {
            return false;
        }

        // check symmetry in structure
        return isSymmetricalHere(left.left, right.right) && isSymmetricalHere(left.right, right.left);
    }

    public static boolean isSymmetrical(TreeNode node) {
        return isSymmetricalHere(node.left, node.right);
    }

    @Test
    public void testIsSymmetrical() {
        TreeNode[] symmetrical = new TreeNode[]{
                TreeNode.from(1),
                TreeNode.from(1, 2, 2),
                TreeNode.from(1, 2, 2, 3, null, null, 3, 4, 5, null, null, null, null, 5, 4)
        };

        for (TreeNode treeNode : symmetrical) {
            assertTrue(isSymmetrical(treeNode));
        }

        TreeNode[] asymmetrical = new TreeNode[]{
                TreeNode.from(1, 2, 3),
                TreeNode.from(1, 2, 2, 3, null, null, 3, 4, 5, null, null, null, null, 4, 5)

        };

        for (TreeNode treeNode : asymmetrical) {
            assertFalse(isSymmetrical(treeNode));
        }
    }
}
