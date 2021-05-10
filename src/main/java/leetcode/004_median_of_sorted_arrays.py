###
# STATUS: INCOMPLETE
###

"""
type: introduction

Given two sorted arrays, find the median of the two. Seems like a mathematical questions at first
but with a little thought this can be solved quite easily.



"""

from typing import List


class Solution:

    @staticmethod
    def findMedian(arr: List[int]) -> float:
        len_by_2 = int(len(arr) / 2) - 1
        if len(arr) & 1:
            return (arr[len_by_2] + arr[len_by_2 + 1]) / 2
        else:
            return arr[len_by_2]

    @staticmethod
    def isClose(num1, num2):
        import math
        return math.isclose(num1, num2)

    @staticmethod
    def findNumbersGreaterThan(num: float, array: List[int]) -> int:
        pass

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m1 = Solution.findMedian(nums1)
        m2 = Solution.findMedian(nums2)

        if Solution.isClose(m1, m2):
            return m1
        else:
            if m1 < m2:
                nums_less = int(len(nums1) / 2) + (len(nums2) - Solution.findNumbersGreaterThan(m1, nums2))
            elif m1 > m2:
                nums_less = int(len(nums2) / 2) + (len(nums1) - Solution.findNumbersGreaterThan(m2, nums1))
            else:
                raise ArithmeticError


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(Solution.findMedian(arr))
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    print(Solution.findMedian(arr))
