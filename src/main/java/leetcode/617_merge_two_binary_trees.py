# Definition for a binary tree node.
from util.tree import TreeNode


class Solution(object):

    @staticmethod
    def merge(t1, t2):
        if not t1:
            return t2

        if not t2:
            return t1

        merged = TreeNode(t1.val + t2.val)
        merged.left = Solution.merge(t1.left, t2.left)
        merged.right = Solution.merge(t1.right, t2.right)

        return merged

    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        return Solution.merge(t1, t2)
