class Solution:
    INT_MAX = 1 << 31 - 1
    INT_MIN = 1 << 31

    def myAtoi(self, s: str) -> int:

        def numeric(c):
            return '0' <= c <= '9'

        def sign(c):
            return c == '-'

        num = 0
        multiplier = 1
        number_started = False
        for c in s:
            if numeric(c):
                number_started = True
                num = num * 10 + int(c)
            elif sign(c):
                number_started = True
                multiplier = -1
            elif not numeric(c) and number_started:
                break

            if num >= Solution.INT_MAX and multiplier > 0:
                return Solution.INT_MAX

            if num >= Solution.INT_MIN and multiplier < 0:
                return - Solution.INT_MIN

        return num * multiplier


print(Solution().myAtoi("-A2"))
print(Solution().myAtoi("42"))
print(Solution().myAtoi(""))
print(Solution().myAtoi("-"))
print(Solution().myAtoi("-1"))
print(Solution().myAtoi("-A"))
print(Solution().myAtoi("-A22323232"))
print(Solution().myAtoi("-2323232323232A"))
print(Solution().myAtoi("   -42"))
print(Solution().myAtoi(" sdfsdf  -42"))
print(Solution().myAtoi(" sdfsdf  -42asdfd"))
print(Solution().myAtoi(" sdfsdf  -42 asdfd"))
print(Solution().myAtoi("  -42 asdfd"))
print(Solution().myAtoi("4193 with wrods"))
print(Solution().myAtoi(" 4193 with wrods"))
print(Solution().myAtoi(" -4193 with wrods"))
print(Solution().myAtoi(" A-4193 with wrods"))
print(Solution().myAtoi(" A-91283472332 with wrods"))
print(Solution().myAtoi("words and 987"))
