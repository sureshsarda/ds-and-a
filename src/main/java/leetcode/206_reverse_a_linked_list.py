# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        def reverse(head):
            if not head.next:
                new_head = head
            else:
                curr_head, new_head = reverse(head.next)
                curr_head.next = head
            return head, new_head

        new_head = None
        if head:
            curr_head, new_head = reverse(head)
            curr_head.next = None
        return new_head


if __name__ == '__main__':
    from util.linked_list import *

    print(list_to_array(Solution().reverseList(list_from_array([1, 2, 3]))))
    print(list_to_array(Solution().reverseList(list_from_array([]))))
    print(list_to_array(Solution().reverseList(list_from_array([-1, -9, -3]))))
    print(list_to_array(Solution().reverseList(list_from_array([-1, -9]))))
    print(list_to_array(Solution().reverseList(list_from_array([-1]))))
    print(list_to_array(Solution().reverseList(list_from_array([1, 2, 3, 4]))))
