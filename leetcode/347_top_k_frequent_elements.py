class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []

        import collections
        ctr = collections.Counter(nums)
        freq = sorted(ctr.values(), reverse=True)[:k][-1]
        res = [key for key, val in ctr.items() if val >= freq]
        return res


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [
        SolvedTestCase(Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2), [1, 2]),
        # SolvedTestCase(Solution().topKFrequent([1, 1, 1, 2, 2, 3, 3], 2), [1, 2]),
        SolvedTestCase(Solution().topKFrequent([1, 1, 1, 2, 3, 3], 2), [1, 3]),
        SolvedTestCase(Solution().topKFrequent([2, 2, 3], 1), [2]),
        SolvedTestCase(Solution().topKFrequent([2, 2], 1), [2]),
        SolvedTestCase(Solution().topKFrequent([], 0), []),
        SolvedTestCase(Solution().topKFrequent([1], 1), [1]),
        SolvedTestCase(Solution().topKFrequent([1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 9, 9], 3), [3, 6, 9]),
    ]

    compare(tests)