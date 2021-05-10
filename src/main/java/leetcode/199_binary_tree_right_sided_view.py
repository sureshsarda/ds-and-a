# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        level_order = self.level_order_traversal(root)
        res = []
        for level, val in level_order.items():
            res.append(val[-1])
        return res

    def level_order_traversal(self, head):
        # Reused from Q.102 - Binary tree level order traversal
        if not head:
            return {}
        left = self.level_order_traversal(head.left)
        right = self.level_order_traversal(head.right)

        lot = {}
        for key in left.keys() + right.keys():
            lot[key + 1] = left.get(key, []) + right.get(key, [])

        lot[0] = [head.val]

        return lot


if __name__ == '__main__':
    from util.tree import array_to_tree

    print(Solution().rightSideView(array_to_tree([1, 2, 3, 4, 5, 6])))
    print(Solution().rightSideView(array_to_tree([1, 2, 3, 4, 5, 6, 7])))
    print(Solution().rightSideView(array_to_tree([1, 2, 3, 4, None, None, 7])))
    print(Solution().rightSideView(array_to_tree([1, 2, 3, None, 5, None, 4])))
    print(Solution().rightSideView(array_to_tree([1, 2, 3, 5, 6, 7, None, None, None, 8, None, None, None, 9, 10])))
    print(Solution().rightSideView(array_to_tree([])))
    print(Solution().rightSideView(array_to_tree([1, 2, None, 4, None, None])))
    print(Solution().rightSideView(array_to_tree([1, 2, 3, 4, None, 5, 6, 10, None, None, None, 8, 9, None, 7, 11])))
