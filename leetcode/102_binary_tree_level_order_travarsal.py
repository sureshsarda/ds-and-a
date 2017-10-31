# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        def level_order_traversal(head):
            if not head:
                return {}
            left = level_order_traversal(head.left)
            right = level_order_traversal(head.right)

            lot = {}
            for key in left.keys() + right.keys():
                lot[key + 1] = left.get(key, []) + right.get(key, [])

            lot[0] = [head.val]

            return lot

        def level_order_traversal_faster(head):
            if not head:
                return []
            left = level_order_traversal_faster(head.left)
            right = level_order_traversal_faster(head.right)

            lot = []

            lot.append([head.val])
            for i in range(max(len(left), len(right))):
                lot.append([])
                if i < len(left):
                    lot[i + 1] += left[i]
                if i < len(right):
                    lot[i + 1] += right[i]

            return lot

        # lot = level_order_traversal(root)
        # res = [lot[key] for key in sorted(lot.keys())]
        # return res
        return level_order_traversal_faster(root)

if __name__ == '__main__':
    from util.tree import array_to_tree

    print(Solution().levelOrder(array_to_tree([1, 2, 3, 4, 5, 6])))
    print(Solution().levelOrder(array_to_tree([1, 2, 3, 4, 5, 6, 7])))
    print(Solution().levelOrder(array_to_tree([1, 2, 3, 4, None, None, 7])))
    print(Solution().levelOrder(array_to_tree([])))
    print(Solution().levelOrder(array_to_tree([1, 2, None, 4, None, None])))
    print(Solution().levelOrder(array_to_tree([1, 2, 3, 4, None, 5, 6, 10, None, None, None, 8, 9, None, 7, 11])))
