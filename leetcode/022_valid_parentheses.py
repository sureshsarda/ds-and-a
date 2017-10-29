class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """

        def paren(open, close):
            if open == 0 and close == 0:
                return []

            if open == 0 and close == 1:
                return [')']
                # if open == 0 and close > 0:
                #     return [''.join(')' for _ in range(close))]

            combinations = []
            if close > 0:
                for p in paren(open, close - 1):
                    combinations.append(')' + p)

            if open > 0:
                for p in paren(open - 1, close + 1):
                    combinations.append('(' + p)

            return combinations

        return paren(n, 0)


if __name__ == '__main__':
    print(Solution().generateParenthesis(0))
    print(Solution().generateParenthesis(1))
    print(Solution().generateParenthesis(2))
    print(Solution().generateParenthesis(3))
    print(Solution().generateParenthesis(4))
