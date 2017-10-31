class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d = {}
        for s in strs:
            sorted_str = ''.join(sorted(s))
            d[sorted_str] = d.get(sorted_str, [])
            d[sorted_str].append(s)

        return d.values()


if __name__ == '__main__':
    import random
    import string

    print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
    print(Solution().groupAnagrams([]))
    print(Solution().groupAnagrams(["eat", "bat"]))
    print(Solution().groupAnagrams([
        ''.join(random.choice(string.lowercase) for x in range(100)) for j in range(1000)
    ]))
