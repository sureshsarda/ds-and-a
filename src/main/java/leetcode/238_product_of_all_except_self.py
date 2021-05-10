class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [0 for _ in range(len(nums))]

        res[0] = nums[0]
        for i in range(1, len(nums)):
            res[i] = res[i - 1] * nums[i]

        res[-1] = res[-2]
        accumulated_product = nums[-1]
        for i in range(len(nums) - 2, -1, -1):
            res[i] = res[i - 1] * accumulated_product

        return res


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().productExceptSelf([1, 2, 3, 4, 5]), [120, 60, 40, 30, 24])
    ]

    compare(tests)
