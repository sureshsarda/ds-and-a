class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        min_price = prices[0]
        max_profile = 0
        for p in prices:
            if p > min_price:
                max_profile = max(max_profile, p - min_price)

            min_price = min(p, min_price)
        return max_profile


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().maxProfit([1, 2, 3, 4, 5, 6, 7, 8]), 7),
        SolvedTestCase(Solution().maxProfit([7, 6, 4, 3, 1]), 0),
        SolvedTestCase(Solution().maxProfit([7, 1, 5, 3, 6, 4]), 5),
        SolvedTestCase(Solution().maxProfit([]), 0),
        SolvedTestCase(Solution().maxProfit([1]), 0),
        SolvedTestCase(Solution().maxProfit([1, 2]), 1),
        SolvedTestCase(Solution().maxProfit([2, 1]), 0),
        SolvedTestCase(Solution().maxProfit([2, 2, 2, 2]), 0),
        SolvedTestCase(Solution().maxProfit([1, 2, 3, 3, 3, 2, 1, 1, 1, 5, 6, 10, 9, 3]), 9),

    ]

    compare(tests)
