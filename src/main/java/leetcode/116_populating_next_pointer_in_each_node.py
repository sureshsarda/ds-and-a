# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        level_order = self.level_order_traversal(root)
        for level, nodes in level_order.items():
            next = None
            for n in reversed(nodes):
                n.next = next
                next = n


    def level_order_traversal(self, head):
        # Reused from Q.102 - Binary tree level order traversal
        if not head:
            return {}
        left = self.level_order_traversal(head.left)
        right = self.level_order_traversal(head.right)

        lot = {}
        for key in left.keys() + right.keys():
            lot[key + 1] = left.get(key, []) + right.get(key, [])

        lot[0] = [head]

        return lot

if __name__ == '__main__':
    from util.tree import array_to_tree

    tree = array_to_tree([1, 2, 3, 4, 5, 6, 7, 8, 9])
    print(Solution().connect(tree))

    print('Done')

