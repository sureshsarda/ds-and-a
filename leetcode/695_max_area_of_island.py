from util.test_cases import TestCase, check


class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        def is_visited(r, c):
            return explored[r][c]

        def seen_this(r, c):
            explored[r][c] = True

        def is_land(r, c):
            return True if grid[r][c] == 1 else False  # Not required to cast values but still

        def neighbors(r, c):
            """ Returns land neighbors of a point """
            lands = []
            if r - 1 >= 0 and is_land(r - 1, c):
                lands.append((r - 1, c))

            if r + 1 < len(grid) and is_land(r + 1, c):
                lands.append((r + 1, c))

            if c - 1 >= 0 and is_land(r, c - 1):
                lands.append((r, c - 1))

            if c + 1 < len(grid[0]) and is_land(r, c + 1):
                lands.append((r, c + 1))

            return lands

        def island_size(r, c):
            if is_visited(r, c):
                return 0

            pending = [(r, c)]  # Start
            size = 0

            while pending:
                current = pending.pop()
                if is_land(current[0], current[1]) and not is_visited(current[0], current[1]):
                    seen_this(current[0], current[1])
                    size += 1
                    pending.extend([n for n in neighbors(current[0], current[1]) if not is_visited(n[0], n[1])])

            return size

        max_size = 0
        explored = [[0 for c in r] for r in grid]

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if not is_visited(r, c):
                    max_size = max(max_size, island_size(r, c))

        return max_size


if __name__ == '__main__':
    sol = Solution()

    print 'Expected: 6 ',
    print sol.maxAreaOfIsland([
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
    ])

    print 'Expected: 17 ',
    print sol.maxAreaOfIsland([
        [0, 1, 1, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0, 0],
        [0, 1, 1, 1, 1, 1, 0],
        [0, 1, 1, 1, 0, 1, 0],
        [0, 1, 1, 1, 1, 1, 0],
        [0, 0, 0, 0, 0, 0, 0]
    ])

    print 'Expected: 15 ',
    print sol.maxAreaOfIsland([
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
        [1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0],
        [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
    ])

    # Edge cases
    print 'Expected: 0 ',
    print sol.maxAreaOfIsland([
        []
    ])

    print 'Expected: 0 ',
    print sol.maxAreaOfIsland([
        [0]
    ])

    print 'Expected: 1 ',
    print sol.maxAreaOfIsland([
        [1]
    ])

    print 'Expected: 3 ',
    print sol.maxAreaOfIsland([
        [1, 1],
        [0, 1]
    ])

    print 'Expected: 2 ',
    print sol.maxAreaOfIsland([
        [0],
        [1],
        [0],
        [1],
        [1],
        [0],
    ])

    print 'Expected: 0 ',
    print sol.maxAreaOfIsland([[0, 0, 0, 0, 0, 0, 0, 0]])

    print 'Expected: 3 ',
    print sol.maxAreaOfIsland([
        [0, 1],
        [1, 1]
    ])
