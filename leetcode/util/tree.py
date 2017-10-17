class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def array_to_tree(l, index=0):
    """
    Converts and list to tree

    :param l: list containing tree description
    :param index:
    :return:
    """
    if not l or index > len(l) - 1:
        return None

    node = TreeNode(l[index])
    node.left = array_to_tree(l, index * 2 + 1)
    node.right = array_to_tree(l, index * 2 + 2)

    return node


def preorder(root):
    if not root:
        raise ValueError('This is not a node')

    traversed = []

    traversed.append(root.val)
    if root.left:
        traversed.extend(inorder(root.left))

    if root.right:
        traversed.extend(inorder(root.right))

    return traversed


def inorder(root):
    if not root:
        raise ValueError('This is not a node')

    traversed = []
    if root.left:
        traversed.extend(inorder(root.left))

    traversed.append(root.val)

    if root.right:
        traversed.extend(inorder(root.right))

    return traversed


if __name__ == '__main__':
    print inorder(array_to_tree([1, 2, 3, 4, 5, 6]))
