class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        compliment = {
            '{': '}',
            '}': '{',
            '[': ']',
            ']': '[',
            '(': ')',
            ')': '('

        }
        stack = []

        for c in s:
            if not stack:
                stack.append(c)
            else:
                if stack[-1] != compliment[c]:
                    stack.append(c)
                else:
                    stack.pop()

        return not bool(stack)


if __name__ == '__main__':
    from util.test_cases import check, TestCase

    test_cases = [
        TestCase('', True),
        TestCase('[]', True),
        TestCase('{}', True),
        TestCase('{}[', False),
        TestCase('[{}', False),
        TestCase('[{}]', True),
        TestCase('([{)}]', False),
        TestCase('(([]{})[]{()})', True),
        TestCase('(', False),
        TestCase('()()', True),
    ]

    check(Solution().isValid, test_cases)
