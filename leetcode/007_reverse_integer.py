class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """

        i = int(''.join(reversed(str(abs(x)))))



        if x < 0:
            i = - i
        return i


if __name__ == '__main__':
    from util.test_cases import check, TestCase

    test_cases = [
        TestCase(100, 1),
        TestCase(123, 321),
        TestCase(-123, -321),
        TestCase(-12300, -321),
        TestCase(1000000003, 0),

    ]

    check(Solution().reverse, test_cases)
