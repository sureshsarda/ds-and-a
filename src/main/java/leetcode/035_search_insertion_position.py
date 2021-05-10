from typing import List


class Solution:

    @staticmethod
    def binarySearchIterative(nums, target):
        start = 0
        end = len(nums)

        while start < end:
            middle = start + (end - start) >> 1
            ele = nums[middle]

            if ele < target:
                start = middle + 1
            elif ele > target:
                end = middle - 1
            else:
                return middle

        return -1

    @staticmethod
    def binarySearchRec(nums, start, end, target):
        len_by_2 = int(len(nums) / 2)
        middle = nums[len_by_2]

    def searchInsert(self, nums: List[int], target: int) -> int:
        return Solution.binarySearchIterative(nums, target)


print(Solution().searchInsert([1], 5))
print(Solution().searchInsert([0, 2, 3], 1))
print(Solution().searchInsert([2], 1))
print(Solution().searchInsert([], 1))
print(Solution().searchInsert([1, 2, 3], 1))
print(Solution().searchInsert([1, 3, 5, 7], 4))
print(Solution().searchInsert([1, 3, 5, 7], 8))
print(Solution().searchInsert([1, 3, 5, 7], 0))
