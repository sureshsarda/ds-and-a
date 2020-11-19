class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


def list_to_array(node):
    l = []
    while node:
        l.append(node.val)
        node = node.next
    return l


def list_from_array(arr):
    if not arr:
        return None

    l = ListNode(arr[0])
    this = l
    for i in range(1, len(arr)):
        this.next = ListNode(arr[i])
        this = this.next
    return l


def print_linked_list(node):
    while node:
        print(node.val, ' ')
        node = node.next
    print('')


if __name__ == '__main__':
    l = list_from_array([1, 4, 2, 3])
    print_linked_list(l)
    print_linked_list(l)
