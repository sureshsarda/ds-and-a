from typing import List


class Solution:

    @staticmethod
    def _find_from(nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums]

        perms = []
        covered = set()
        for i, n in enumerate(nums):
            if n not in covered:
                for p in Solution._find_from(nums[0: i] + nums[i + 1:]):
                    perms.append(p + [n])
                covered.add(n)

        return perms

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        return Solution._find_from(nums)


if __name__ == '__main__':
    print(Solution().permuteUnique([1, 2, 2]))
    print(Solution().permuteUnique([]))
    print(Solution().permuteUnique([1]))
    print(Solution().permuteUnique([1, 2]))
    print(Solution().permuteUnique([1, 2, 2, 2, 2]))
    print(Solution().permuteUnique([1, 1, 1, 1]))
