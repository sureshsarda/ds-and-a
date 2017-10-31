class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        max_so_far = max_till_end = nums[0]
        for x in nums[1:]:
            max_till_end = max(x, max_till_end + x)
            max_so_far = max(max_so_far, max_till_end)
        return max_so_far


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().maxSubArray([1, 2, 3]), 6),
        SolvedTestCase(Solution().maxSubArray([-2, 1, -3, 2, 1]), 3),
        SolvedTestCase(Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]), 6),
        SolvedTestCase(Solution().maxSubArray([-4, -2, -3, -3]), -2),

    ]

    compare(tests)
