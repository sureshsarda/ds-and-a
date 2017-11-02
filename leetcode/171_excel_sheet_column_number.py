class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        import string
        base = 1
        res = 0
        for i, c in enumerate(reversed(s)):
            res += base + base * string.uppercase.index(c)
            base *= 26
        return res





if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().titleToNumber("A"), 1),
        SolvedTestCase(Solution().titleToNumber("B"), 2),
        SolvedTestCase(Solution().titleToNumber("Y"), 25),
        SolvedTestCase(Solution().titleToNumber("Z"), 26),
        SolvedTestCase(Solution().titleToNumber("AA"), 27),
        SolvedTestCase(Solution().titleToNumber("AZ"), 52),
        SolvedTestCase(Solution().titleToNumber("BA"), 53),
        SolvedTestCase(Solution().titleToNumber("CA"), 79),
        SolvedTestCase(Solution().titleToNumber("BZ"), 78),
        SolvedTestCase(Solution().titleToNumber("AMXTRZVR"), 12342342342),
    ]

    compare(tests)