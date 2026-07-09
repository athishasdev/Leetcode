class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];

        Arrays.fill(dp,1);

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Integer.max(dp[j]+1,dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i : dp){
            if(max < i)
                max = i;
        }
        return max;
    }
}