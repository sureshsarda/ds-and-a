class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        import string
        res = []
        quot = n
        while quot > 0:
            quot, rem = divmod(quot, 26)
            res.append(string.uppercase[rem - 1])
            if rem == 0:
                quot -= 1
        return ''.join(reversed(res))






if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().convertToTitle(1), "A"),
        SolvedTestCase(Solution().convertToTitle(2), "B"),
        SolvedTestCase(Solution().convertToTitle(25), "Y"),
        SolvedTestCase(Solution().convertToTitle(26), "Z"),
        SolvedTestCase(Solution().convertToTitle(27), "AA"),
        SolvedTestCase(Solution().convertToTitle(52), "AZ"),
        SolvedTestCase(Solution().convertToTitle(53), "BA"),
        SolvedTestCase(Solution().convertToTitle(78), "BZ"),
        SolvedTestCase(Solution().convertToTitle(79), "CA"),
        SolvedTestCase(Solution().convertToTitle(12342342342), "AMXTRZVR"),
    ]

    compare(tests)