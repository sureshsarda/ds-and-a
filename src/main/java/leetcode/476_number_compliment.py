class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        s = bin(num)
        flip = False
        num = []
        for bit in s:
            if bit == '1' and not flip:
                flip = True
            if flip:
                num.append('0' if bit == '1' else '1')

        return int(''.join(num), 2) if num else 0


if __name__ == '__main__':
    sol = Solution()
    assert int('010', 2) == sol.findComplement(int('101', 2))
    assert int('010', 2) == sol.findComplement(int('00101', 2))
    assert int('0101', 2) == sol.findComplement(int('1010', 2))
    assert int('0', 2) == sol.findComplement(int('1', 2))
    assert int('0000', 2) == sol.findComplement(int('0001', 2))
    assert int('0000', 2) == sol.findComplement(int('1111', 2))
