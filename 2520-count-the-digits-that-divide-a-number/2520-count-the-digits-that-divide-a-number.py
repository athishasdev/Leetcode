class Solution(object):
    def countDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        temp = num
        count = 0

        while temp > 0:
            t = temp % 10
            if num % t == 0:
                count += 1
            temp /= 10
        
        return count