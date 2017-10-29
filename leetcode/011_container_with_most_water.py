class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # Two pointer
        max_area = 0
        left = 0
        right = len(height) - 1

        while left < right:
            max_area = max(max_area, min(height[left], height[right]) * (right - left))
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
        return max_area


if __name__ == '__main__':
    print Solution().maxArea([1, 4, 1, 4, 15, 3, 4])
    print Solution().maxArea([1, 4, 1, 4, 15, 3, 1, 25, 10])
    print Solution().maxArea([1, 1, 1, 1, 15, 15])
