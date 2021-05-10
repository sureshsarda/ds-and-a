# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def sum_and_tilt(head):
            if not head:
                return 0, 0
            left_sum, left_tilt = sum_and_tilt(head.left)
            right_sum, right_tilt = sum_and_tilt(head.right)

            return left_sum + right_sum + head.val, left_tilt + right_tilt + abs(left_sum - right_sum)

        sum, tilt = sum_and_tilt(root)
        return tilt


if __name__ == '__main__':
   from util.tree import array_to_tree

   print(Solution().findTilt(array_to_tree([1, 2, 3, 4, 5, 6])))
   print(Solution().findTilt(array_to_tree([1, 2, 3, 4, 5, 6, 7])))
   print(Solution().findTilt(array_to_tree([1, 2, 3, 4, None, None, 7])))
   print(Solution().findTilt(array_to_tree([])))
   print(Solution().findTilt(array_to_tree([1, 2, None, 4, None, None])))
   print(Solution().findTilt(array_to_tree([1, 2, 3, 4, None, 5, 6, 10, None, None, None, 8, 9, None, 7, 11])))