# Given
# An unsorted array (duplicate possible)
#
# I need index of solution, not the actual numbers.
# If I use a dict key = number and value = index, then I can traverse through the dict and find the compliment
#   What about duplicate numbers?

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        # Preprocessing
        d = {}
        for i, num in enumerate(nums):
            if num in d:
                d[num].append(i)
            else:
                d[num] = [i]

        # Query
        for key, value in d.items():
            # if key > target:
            #     continue

            compilment = target - key
            if compilment != key and compilment in d:
                return [d[key][0], d[compilment][0]]
            else:
                if len(d[key]) > 1 and key * 2 == target:
                    return d[key][:2]


if __name__ == '__main__':
    sol = Solution()
    print sol.twoSum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 11)
    print sol.twoSum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 12)
    print sol.twoSum([1, 2, 3, 4, 4], 8)
    print sol.twoSum([1, 2, 3, 4], 8)
    print sol.twoSum([1, 2, 3, 4, 9, -1], 8)
    print sol.twoSum([1, 1], 2)
    print sol.twoSum([1, 1], 3)

