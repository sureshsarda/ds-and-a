# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy_head = ListNode(0)
        current = dummy_head
        while l1 and l2:
            if l1.val <= l2.val:
                current.next = ListNode(l1.val)
                l1 = l1.next
            else:
                current.next = ListNode(l2.val)
                l2 = l2.next
            current = current.next

        if l1:
            current.next = l1
        if l2:
            current.next = l2

        return dummy_head.next



if __name__ == '__main__':
    from util.linked_list import print_linked_list, list_from_array

    print_linked_list(Solution().mergeTwoLists(list_from_array([1, 2, 3]), list_from_array([1, 2, 3])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([1, 2, 3]), list_from_array([1, 2, 3, 4, 5, 6])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([1, 2, 3, 4, 5, 6]), list_from_array([1, 2, 3])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([1, 2, 3, 4, 5, 6]), list_from_array([])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([]), list_from_array([1, 2, 3, 4, 5, 6])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([]), list_from_array([])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([1, 3, 5, 7]), list_from_array([2, 4, 6, 8, 10, 12])))
    print_linked_list(Solution().mergeTwoLists(list_from_array([-3, -1, 5, 7]), list_from_array([2, 4, 6, 8, 10, 12])))
