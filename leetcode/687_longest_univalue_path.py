import util.tree as tree
from util.test_cases import TestCase, check


class Solution(object):
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        l_longest = 0
        r_longest = 0
        l_value = None
        r_value = None
        if root.left:
            l_longest, l_value = self.longestUnivaluePath(root.left)

        if root.right:
            r_longest, r_value = self.longestUnivaluePath(root.right)


        # Now few things are possible.
        if l_value == r_value == root.val:
            pass
        elif l_value != r_value and (l_value == root.val or r_value == root.val):
            pass
        elif l_value


if __name__ == '__main__':
    test_cases = [
        TestCase(tree.array_to_tree([4, 1, 2, 1, 1, None, None, 1, 2, 2, 1]), 4),
        TestCase(tree.array_to_tree([1, 1, 1]), 2),
        TestCase(tree.array_to_tree([0, 1, 1]), 0),
        TestCase(tree.array_to_tree([1, 0, 1]), 1),
    ]

    check(Solution().longestUnivaluePath, test_cases)
