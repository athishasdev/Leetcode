
class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        amax = []
        amax.append(nums[0])

        for i in range(1,len(nums)):
            amax.append(max(nums[i],amax[i-1]))

        prefix = [math.gcd(a, n) for a, n in zip(amax, nums)]

        prefix.sort()

        i = 0
        j = len(prefix)-1

        sum = 0

        while(i < j):
            sum += (math.gcd(prefix[i],prefix[j]))
            i += 1
            j -= 1

        return sum
        