class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        return sum(nums[::2])


if __name__ == '__main__':
    sol = Solution()
    print sol.arrayPairSum([1, 2, 4, 3])  # 4
    print sol.arrayPairSum([1, 4])  # 1
    print sol.arrayPairSum([1,4, -1, -2])  # -1
    print sol.arrayPairSum([1,4, 0, 9, -9, -1, -2, 3])  # -5
