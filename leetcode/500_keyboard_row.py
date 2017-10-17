class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        rows = [
            'qwertyuiop',
            'asdfghjkl',
            'zxcvbnm'
        ]

        possible = []
        for word in words:
            for row in rows:
                if all([True if c in row else False for c in word.lower()]):
                    possible.append(word)
                    break

        return possible
