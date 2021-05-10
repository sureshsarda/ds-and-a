class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        return len(set(nums))


if __name__ == '__main__':
    assert Solution().removeDuplicates([1, 2, 1]) == 2