# https://www.interviewbit.com/problems/palindrome-list/
#
# Intuition:
# Recurse to last element of list, but also preserve first element with each call, such that when you are at last,
# you will have the first element and last element. Now at every return call, return the next element of first element
# This way, when you were at last, current was last and first was first but in 2nd last call, current will be second
# last and first will be 2nd element. Keep going till you find something not matching.

class Node():
    def __init__(self, data):
        self.data = data
        self.next_node = None


def create_list(str):
    first = None
    current = None
    for c in str:
        if not first:
            first = Node(c)
            current = first
        else:
            current.next_node = Node(c)
            current = current.next_node
    return first


def traverse(first):
    if not first:
        return

    current = first
    while current:
        print(current.data)
        current = current.next_node


def is_pallindrome(first):
    def _pal(first, current):
        status = 'pallindrome'
        if current.next_node:
            target, status = _pal(first, current.next_node)
            if status != 'pallindrome':
                return None, status
        else:
            target = first

        # print('Comparing: {0}-{1}'.format(target.data, current.data))
        if target.data != current.data:
            status = 'not pallindrome'
        return target.next_node, status

    target, status = _pal(first, first)
    return status


if __name__ == '__main__':
    str = ['malayalam', '1234554321', '123454321', '1', '123456', '12']
    for s in str:
        print('{0} - {1}'.format(s, is_pallindrome(create_list(s))))
