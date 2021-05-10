class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return ' '.join(reversed(s.split()))


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().reverseWords('Joe is aa   good girl  '), 'girl good aa is Joe'),
        SolvedTestCase(Solution().reverseWords('the sky is blue'), 'blue is sky the'),
        SolvedTestCase(Solution().reverseWords('the sky is blue'), 'blue is sky the')
    ]

    compare(tests)