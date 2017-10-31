class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """

        for i in range(len(matrix) / 2):
            pass
            


if __name__ == '__main__':
    mat = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    Solution().rotate(mat)
    print(mat)
