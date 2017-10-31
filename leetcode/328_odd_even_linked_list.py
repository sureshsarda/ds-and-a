# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        current = head
        odd_dummy_head = ListNode(0)
        even_dummy_head = ListNode(0)
        odd_current = odd_dummy_head
        even_current = even_dummy_head

        index = 1
        while current:
            # node_to_process = odd_current if index % 2 else even_current
            # node_to_process.next = current
            # node_to_process = node_to_process.next
            if index % 2:
                odd_current.next = current
                odd_current = odd_current.next
            else:
                even_current.next = current
                even_current = even_current.next

            current = current.next
            index += 1

        # Attach even after odd
        even_current.next = None
        odd_current.next = even_dummy_head.next
        return odd_dummy_head.next


if __name__ == '__main__':
    from util.linked_list import *

    print(list_to_array(Solution().oddEvenList(list_from_array([1, 2, 3, 4, 5, 6, 7, 8, 9]))))
    print(list_to_array(Solution().oddEvenList(list_from_array([]))))
    print(list_to_array(Solution().oddEvenList(list_from_array([-1, -9, -3]))))
    print(list_to_array(Solution().oddEvenList(list_from_array([-1, -9]))))
    print(list_to_array(Solution().oddEvenList(list_from_array([-1]))))
    print(list_to_array(Solution().oddEvenList(list_from_array([1, 2, 3, 4]))))
