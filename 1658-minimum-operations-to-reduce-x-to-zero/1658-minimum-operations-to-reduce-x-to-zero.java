import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return nums.length;
        }

        int f = 0;
        int curr = 0;
        int maxLen = -1;

        for (int l = 0; l < nums.length; l++) {

            curr += nums[l];

            while (curr > target && f <= l) {
                curr -= nums[f];
                f++;
            }

            if (curr == target) {
                maxLen = Math.max(maxLen, l - f + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return nums.length - maxLen;
    }
}