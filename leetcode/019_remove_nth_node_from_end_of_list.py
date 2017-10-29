# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """

        left = None
        right = head
        for i in range(n):
            right = right.next

        while right:
            right = right.next
            left = left.next if left else head

        if not left:
            head = head.next or []
        else:
            left.next = left.next.next

        return head


if __name__ == '__main__':
    from util.linked_list import list_from_array, print_linked_list

    print_linked_list(Solution().removeNthFromEnd(list_from_array([1, 2, 3, 4, 5, 6]), 3))
    print_linked_list(Solution().removeNthFromEnd(list_from_array([1]), 1))
    print_linked_list(Solution().removeNthFromEnd(list_from_array([1, 2]), 1))
    print_linked_list(Solution().removeNthFromEnd(list_from_array([1, 2]), 2))
    print_linked_list(Solution().removeNthFromEnd(list_from_array([1, 2, 3]), 2))

