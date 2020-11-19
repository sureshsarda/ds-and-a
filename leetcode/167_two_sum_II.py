import bisect


class Solution(object):
    def index(self, a, x, lo=0):
        i = bisect.bisect_left(a, x, lo)
        if i != len(a) and a[i] == x:
            return i
        return None

    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, num in enumerate(numbers):
            compliment = target - num
            c = self.index(numbers, compliment, i + 1)
            if c:
                return [i + 1, c + 1]  # Solution needs 1 based indexes


if __name__ == '__main__':
    sol = Solution()
    print(sol.twoSum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 11))
    print(sol.twoSum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 12))
    print(sol.twoSum([1, 2, 3, 4, 4], 8))
    print(sol.twoSum([1, 2, 3, 4], 8))
    print(sol.twoSum([1, 2, 3, 4, 9, -1], 8))
    print(sol.twoSum([1, 1], 2))
    print(sol.twoSum([1, 1], 3))
