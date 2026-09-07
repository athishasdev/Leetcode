class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] last = new int[26];

        Arrays.fill(last,-1);

        int mod = 1_000_000_007;

        for(int i = 0; i < n; i++){
            int ind = s.charAt(i) - 'a';
            int val = (dp[i] * 2) % mod;
            if(last[ind] >= 0){
                dp[i+1] = val - dp[last[ind]];
                dp[i+1] %= mod;
            }
            else{
                dp[i+1] = val;
            }

            if(dp[i+1] < 0) dp[i+1] += mod;
            last[ind] = i;
        }

        dp[n] -= 1;

        if(dp[n] < 0) dp[n] += mod;

        return dp[n];
    }
}