import util.tree as tree


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    @staticmethod
    def preorder(root):
        if not root:
            raise ValueError('This is not a node')

        traversed = []
        traversed.append(root.val)
        if root.left:
            traversed.extend(Solution.preorder(root.left))

        if root.right:
            traversed.extend(Solution.preorder(root.right))

        return traversed

    @staticmethod
    def inorder(root):
        if not root:
            raise ValueError('This is not a node')

        traversed = []

        if root.left:
            traversed.extend(Solution.inorder(root.left))

        traversed.append(root.val)
        if root.right:
            traversed.extend(Solution.inorder(root.right))

        return traversed

    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        s_preorder = ''.join([str(_) for _ in Solution.preorder(s)])
        t_preorder = ''.join([str(_) for _ in Solution.preorder(t)])

        s_inorder = ''.join([str(_) for _ in Solution.inorder(s)])
        t_inorder = ''.join([str(_) for _ in Solution.inorder(t)])

        return t_inorder in s_inorder and t_preorder in s_preorder


if __name__ == '__main__':
    sol = Solution()

    print(sol.isSubtree(tree.array_to_tree([3, 4, 5, 1, 2, None, None, 0]), tree.array_to_tree([4, 1, 2])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3]), tree.array_to_tree([2, 3])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3]), tree.array_to_tree([1, 2])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3, 4, 5, 6, 7, None, 8]), tree.array_to_tree([1, 2, 3])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3, 4, 5, 6, 7, None, 8]), tree.array_to_tree([3, 6, 7])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3, 4, 5, 6, 7, None, 8]), tree.array_to_tree([3, None, 7])))
    print(sol.isSubtree(tree.array_to_tree([1, 2, 3, 4, 5, 6, 7, None, 8]), tree.array_to_tree([3, 6])))


