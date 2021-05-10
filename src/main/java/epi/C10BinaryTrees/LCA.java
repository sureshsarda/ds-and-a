package epi.C10BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class LCA {

    private static void findHelper(TreeNode from, int data, List<TreeNode> path) {
        if (from == null) {
            return;
        } else {
            path.add(from);
            if (data > from.data) {
                findHelper(from.right, data, path);
            } else if (data < from.data) {
                findHelper(from.left, data, path);
            } else {
                // nothing to do.
            }
        }
    }

    public static List<TreeNode> find(TreeNode root, int data) {
        List<TreeNode> path = new LinkedList<>();
        findHelper(root, data, path);
        return path;
    }

    public static TreeNode lca(TreeNode root, int data1, int data2) {
        List<TreeNode> p1 = find(root, data1);
        List<TreeNode> p2 = find(root, data2);

        if (p1.get(p1.size() - 1).data != data1 || p2.get(p2.size() - 1).data != data2) {
            System.err.println("Data does not exist in the tree");
            return null;
        }

        TreeNode common = root;
        for (int i = 1; i < Math.min(p1.size(), p2.size()); i++) {
            if (p1.get(i).data == p2.get(i).data) {
                common = p1.get(i);
            } else {
                break;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.COMPLETE_H4_BST;
        TreeNode lca = lca(root, 4, 5);
        System.out.println(lca.data);
    }
}
