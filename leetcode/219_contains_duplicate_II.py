from util.test_cases import TestCase


class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        enumerated_nums = sorted(zip(nums, range(len(nums))))
        for i in range(len(enumerated_nums) - 1):
            this = enumerated_nums[i]
            next = enumerated_nums[i + 1]

            if this[0] == next[0] and abs(this[1] - next[1]) <= k:
                return True
        return False


if __name__ == '__main__':
    sol = Solution()
    print(True, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, 1], 10))
    print(False, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, 6], 10))
    print(False, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, 1], 2))
    print(True, sol.containsNearbyDuplicate([1, 2, 3, 4, 1, 1], 2))
    print(True, sol.containsNearbyDuplicate([1, 1, 1, 1, 1, 1], 2))
    print(False, sol.containsNearbyDuplicate([], 2))
    print(False, sol.containsNearbyDuplicate([1], 2))
    print(False, sol.containsNearbyDuplicate([1, 2], 2))
    print(False, sol.containsNearbyDuplicate([1, 1], 0))
    print(True, sol.containsNearbyDuplicate([1, 2, 1], 2))
    print(False, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, -6, -7, 8, 9, 10, 1], 4))
    print(True, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, -6, 7, 8, 9, 10, 1], 10))
    print(False, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, -6, 7, 8, 9, 10, 1], 9))
    print(False, sol.containsNearbyDuplicate([1, 2, 3, 4, 5, -6, 7, 8, 9, 10, 1], 0))

    from test import tc
    print('No idea', sol.containsNearbyDuplicate(tc[0], tc[1]))
