# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """

        dummy_head = ListNode(0)
        dummy_head.next = head
        current = dummy_head

        while current.next:
            if current.next.val == val:
                current.next = current.next.next
            else:
                current = current.next

        return dummy_head.next


if __name__ == '__main__':
    from util.linked_list import list_from_array, list_to_array
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([1, 2, 3, 4, 5, 6, 7, 8]), 6)),
            [1, 2, 3, 4, 5, 7, 8]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([1, 2, 3, 6, 6, 6, 7, 8]), 6)),
            [1, 2, 3, 7, 8]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([6, 2, 6, 4, 5, 6, 7]), 6)),
            [2, 4, 5, 7]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([1, 2, 3, 4, 5, 6]), 6)),
            [1, 2, 3, 4, 5]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([]), 6)),
            []
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([1, 2, 3]), 6)),
            [1, 2, 3]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([6, 6, 6]), 6)),
            []
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([6]), 6)),
            []
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([6, 2, 6]), 6)),
            [2]
        ),

        SolvedTestCase(
            list_to_array(Solution().removeElements(list_from_array([6, 2, 6, 2, 6, 2, 6, 2, 6]), 6)),
            [2, 2, 2, 2]
        ),

    ]

    compare(tests)
