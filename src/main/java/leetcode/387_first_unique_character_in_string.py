class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        for i, c in enumerate(s):
            if c in d:
                d[c] = 'D'
            else:
                d[c] = i

        return min([v for v in d.values() if v != 'D']) if d else -1
