class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        def check_small_box(x_offset, y_offset, x_size, y_size):
            bit_array = [False for i in range(len(board) + 1)]  # Values are from 1 to 9

            for i in range(x_size):
                for j in range(y_size):
                    val = board[y_offset + j][x_offset + i]
                    if val != '.':
                        if bit_array[int(val)]:
                            return False
                        else:
                            bit_array[int(val)] = True
            return True

        assert len(board) == 9
        assert all([len(row) == 9 for row in board])

        # Check Rows
        for i in range(9):
            if not check_small_box(0, i, 9, 1):
                # print("Row Law {0}".format(i))
                return False

        # Check Columns
        for i in range(9):
            if not check_small_box(i, 0, 1, 9):
                # print("Col Law {0}".format(i))
                return False

        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not check_small_box(i, j, 3, 3):
                    # print("Box Law {0} {1}".format(i, j))
                    return False

        return True


if __name__ == '__main__':
    from util.twod_input import read_2d_input

    print(Solution().isValidSudoku(
        read_2d_input(
            """
            123456789
            456789123
            789123456
            .........
            .........
            .........
            .........
            .........
            .........
            """
        )
    ))

    print(Solution().isValidSudoku(
        read_2d_input(
            """
            .........
            .2.....2.
            .........
            .........
            .........
            .........
            .........
            .........
            .........
            """
        )
    ))

    print(Solution().isValidSudoku(
        read_2d_input(
            """
            .........
            ..21.....
            ..12.....
            .........
            .........
            .........
            .........
            .........
            .........
            """
        )
    ))

    print(Solution().isValidSudoku([
        "1,.,.,.,.,.,.,.,2".split(","),
        ".,.,.,.,.,.,.,.,1".split(","),
        ".,.,.,.,.,1,.,.,.".split(","),
        ".,.,.,1,.,.,.,.,.".split(","),
        ".,1,.,.,.,.,.,.,.".split(","),
        ".,.,.,.,.,.,.,1,.".split(","),
        ".,.,.,.,.,.,1,.,.".split(","),
        ".,.,.,.,1,.,.,.,.".split(","),
        ".,.,1,.,.,.,.,.,.".split(","),
    ]))

    print(Solution().isValidSudoku([
        "1,.,.,.,.,.,.,.,2".split(","),
        ".,.,.,.,.,.,.,.,1".split(","),
        ".,.,.,.,.,1,.,.,.".split(","),
        ".,.,.,1,.,.,.,.,.".split(","),
        ".,1,.,.,.,.,.,.,.".split(","),
        ".,.,.,.,.,.,.,1,.".split(","),
        ".,.,.,.,.,.,1,.,.".split(","),
        ".,.,.,.,1,.,.,.,.".split(","),
        ".,.,1,.,.,.,.,.,1".split(","),
    ]))

    print(Solution().isValidSudoku([
        "3,.,.,.,.,.,.,.,2".split(","),
        ".,.,.,.,.,.,.,.,1".split(","),
        ".,.,.,.,.,1,.,.,.".split(","),
        ".,.,.,1,.,.,.,.,.".split(","),
        ".,1,.,.,.,.,.,.,.".split(","),
        "1,.,.,.,.,.,.,.,.".split(","),
        ".,.,.,.,.,.,1,.,.".split(","),
        ".,.,.,.,1,.,.,.,.".split(","),
        ".,.,1,.,.,.,.,.,.".split(","),
    ]))
