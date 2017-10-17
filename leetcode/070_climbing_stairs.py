class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0 or n == 1:
            return 1

        prev_prev = 1
        prev = 1
        for i in range(1, n):
            current = prev + prev_prev
            prev_prev = prev
            prev = current
        return prev

if __name__ == '__main__':
    sol = Solution()
    for i in range(10):
        print i, sol.climbStairs(i)