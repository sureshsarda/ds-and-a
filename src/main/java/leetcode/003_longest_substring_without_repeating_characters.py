class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_found = 0
        current = ''
        for c in s:
            if c in current:
                current = current[current.index(c) + 1:]
            current = current + c

            if max_found < len(current):
                max_found = len(current)
        return max_found


if __name__ == '__main__':
    from util.test_cases import TestCase, check

    test_cases = [
        TestCase('pwwkew', 3),
        TestCase('abcabcbb', 3),
        TestCase('pwwkewew', 3),
        TestCase('aaaaaa', 1),
        TestCase('', 0),
        TestCase('abcedf', 6),
        TestCase('fabcedff', 6),

    ]

    check(Solution().lengthOfLongestSubstring, test_cases)
