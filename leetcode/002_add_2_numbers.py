# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        zero_node = ListNode(0)
        if not l2:
            return l1

        if not l1:
            return l2

        # TODO Use dummy head so that this logic is at one place
        s = l1.val + l2.val
        carry = s / 10
        result = ListNode(s % 10)
        this = result
        while l1.next or l2.next:
            l1 = l1.next or zero_node
            l2 = l2.next or zero_node
            s = l1.val + l2.val + carry
            carry = s / 10
            mod = s % 10
            this.next = ListNode(mod)
            this = this.next

        if carry:
            this.next = ListNode(1)

        return result


if __name__ == '__main__':
    import util.linked_list as ll

    sol = Solution()

    print 'Extected: 718'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([2, 4, 3]), ll.list_from_array([5, 7, 4])))

    print 'Extected: 243'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([2, 4, 3]), ll.list_from_array([])))

    print 'Extected: 123'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([]), ll.list_from_array([1, 2, 3])))

    print 'Extected: 08388'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([9, 5]), ll.list_from_array([1, 2, 3, 9, 9])))

    print 'Extected: 12399'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([0, 0]), ll.list_from_array([1, 2, 3, 9, 9])))

    print 'Extected: 222901'
    ll.print_linked_list(sol.addTwoNumbers(ll.list_from_array([1, 0, 9, 9]), ll.list_from_array([1, 2, 3, 9, 9])))

