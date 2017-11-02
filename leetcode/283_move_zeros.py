class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        zero_count = 0
        write_index = 0
        scan_index = 0
        for i in range(len(nums)):
            if nums[scan_index] == 0:
                zero_count += 1
                scan_index += 1
            else:
                nums[write_index] = nums[scan_index]
                write_index += 1
                scan_index += 1

        for i in range(len(nums) - zero_count, len(nums)):
            nums[i] = 0


if __name__ == '__main__':
    arr = [1, 3, 0, 1, 2, 0, 0, 5, 0]
    Solution().moveZeroes(arr)
    print(arr)

    arr = [0, 0, 0]
    Solution().moveZeroes(arr)
    print(arr)

    arr = [1, 2, 3, 4, 5]
    Solution().moveZeroes(arr)
    print(arr)

    arr = [1, 3, 0, 1, 2]
    Solution().moveZeroes(arr)
    print(arr)

    arr = [0, 0, 0, 1, 3, 0, 1, 2]
    Solution().moveZeroes(arr)
    print(arr)

    arr = [1, 0, 0, 2]
    Solution().moveZeroes(arr)
    print(arr)