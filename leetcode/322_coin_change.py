class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        counter = 0
        coins = sorted(coins, reverse=True)
        for c in coins:
            while c <= amount:
                amount -= c
                counter += 1

        return counter if amount == 0 else -1


if __name__ == '__main__':
    sol = Solution()
    print sol.coinChange([5, 2, 1], 11), "Ans: 3"
    print sol.coinChange([2], 3), "Ans: -1"
    print sol.coinChange([5, 2], 3), "Ans: -1"
    print sol.coinChange([5, 2, 7], 9), "Ans: 2"
    print sol.coinChange([5, 2, 7], 0), "Ans: 0"
    print sol.coinChange([13], 39), "Ans: 3"
    print sol.coinChange([], 39), "Ans: -1"
    print sol.coinChange([12, 11, 10, 7], 39), "Ans: -1"
    print sol.coinChange([186, 419, 83, 408], 6249), "Ans: 20"
