class Solution(object):
    def maxDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """

        freq= [0] * 26
        count = 0
        
        for c in s:
            freq[ord(c) - ord('a')] += 1
            if freq[ord(c) - ord('a')] == 1:
                count += 1

        return count