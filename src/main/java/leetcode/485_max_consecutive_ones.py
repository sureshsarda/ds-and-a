class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.append(0)  # This is to terminate all sequences
        max_sequence = 0
        current_sequence = 0
        for n in nums:
            if n == 1:
                current_sequence += 1
            else:
                max_sequence = max(max_sequence, current_sequence)
                current_sequence = 0

        return max_sequence


if __name__ == '__main__':
    from util.test_cases import SolvedTestCase, compare

    tests = [

        SolvedTestCase(Solution().findMaxConsecutiveOnes([1, 0, 1, 0, 1, 0]), 1),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([1, 0, 1, 0, 1, 0, 1, 1]), 2),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([1, 1]), 2),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([0, 0]), 0),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([]), 0),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([1]), 1),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([1, 1, 1, 0, 0, 1, 1, 1, 1]), 4),
        SolvedTestCase(Solution().findMaxConsecutiveOnes([1, 1, 1, 0, 0, 1, 1]), 3),
    ]

    compare(tests)
