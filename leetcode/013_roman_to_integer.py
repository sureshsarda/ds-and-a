class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.upper()
        CHARACTERS = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        num = 0
        i = 0
        while i < len(s):
            if i < len(s) - 1 and CHARACTERS[s[i]] < CHARACTERS[s[i + 1]]:
                num += CHARACTERS[s[i + 1]] - CHARACTERS[s[i]]
                i += 1  # Consuming 2 tokens
            else:
                num += CHARACTERS[s[i]]
            i += 1

        return num


if __name__ == '__main__':
    from util.test_cases import TestCase, check

    test_cases = [
        TestCase('I', 1),
        TestCase('II', 2),
        TestCase('III', 3),
        TestCase('IV', 4),
        TestCase('v', 5),
        TestCase('vi', 6),
        TestCase('vii', 7),
        TestCase('viii', 8),
        TestCase('Ix', 9),
        TestCase('x', 10),
        TestCase('xi', 11),
        TestCase('xxi', 21),
        TestCase('xxiv', 24),
        TestCase('XLIV', 44),
        TestCase('LXXXIV', 84),
        TestCase('MDCCC', 1800),
        TestCase('MMMCMXCIX', 3999),


    ]

    check(Solution().romanToInt, test_cases)
