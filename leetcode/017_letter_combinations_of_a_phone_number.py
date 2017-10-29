class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        keypad = {
            '1': '*',
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
            '0': ' '
        }

        def combinations(digits):
            if not digits:
                return []

            if len(digits) == 1:
                return [c for c in keypad[digits[0]]]
            else:
                combs = combinations(digits[1:])
                result = []
                for comb in combs:
                    for c in keypad[digits[0]]:
                        result.append(c + comb)
            return result

        return combinations(digits)


if __name__ == '__main__':
    print(Solution().letterCombinations('23'))
    print(Solution().letterCombinations(''))
    print(Solution().letterCombinations('2'))
    print(Solution().letterCombinations('77'))
    print(Solution().letterCombinations('1234567890'))
    # print(Solution().letterCombinations('7777 777777'))
