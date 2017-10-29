class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 1

        found = [False for _ in range(max(nums) + 1)]

        for val in nums:
            if val > 0:
                found[val - 1] = True

        # print('Processing Complete')
        for index, val in enumerate(found):
            if not val:
                return index + 1

        return 1


if __name__ == '__main__':
    import timeit

    # print(timeit.timeit("Solution().firstMissingPositive(list(range(1000000)))", setup="from __main__ import Solution", number=1))
    print(Solution().firstMissingPositive([1, 2, 0]))
    print(Solution().firstMissingPositive([1000, -1]))
    print(Solution().firstMissingPositive([3, 4, -1, 1]))
    print(Solution().firstMissingPositive([]))
    print(Solution().firstMissingPositive([-4, -3]))
    print(Solution().firstMissingPositive([-4, -3, 4, 5, 1]))

    l = list(range(1000, 10000))
    l.extend([-1, -3, 9, 10])
    print(Solution().firstMissingPositive(l))
    print(Solution().firstMissingPositive(list(range(1000))))
