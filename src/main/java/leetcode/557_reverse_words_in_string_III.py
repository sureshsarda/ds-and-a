class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """

        collector = []
        words = s.split(' ')
        for word in words:
            collector.append(''.join(reversed(word)))

        return ' '.join(collector)



# Test cases
# "Let's take LeetCode contest"
# "Hey how are you"
# "I'm sooo gonna rock this party"
# ""
# "OneWord"
# "Exclamation Mark Baby!!"