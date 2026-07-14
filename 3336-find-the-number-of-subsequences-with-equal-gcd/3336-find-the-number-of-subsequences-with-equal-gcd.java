class Solution {
    private static final int MOD = 1_000_000_007;

    private int[] nums;
    private Long[][][] memo;
    private int[][] gcdTable;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        memo = new Long[n + 1][201][201];
        gcdTable = new int[201][201];

        // Precompute gcd values
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                gcdTable[i][j] = gcd(i, j);
            }
        }

        return (int) ((dp(0, 0, 0) - 1 + MOD) % MOD);
    }

    private long dp(int i, int gcd1, int gcd2) {
        if (i == nums.length) {
            return gcd1 == gcd2 ? 1 : 0;
        }

        if (memo[i][gcd1][gcd2] != null) {
            return memo[i][gcd1][gcd2];
        }

        int x = nums[i];

        long total = 0;

        total = (total + dp(i + 1, gcd1, gcd2)) % MOD;
        total = (total + dp(i + 1, gcdTable[gcd1][x], gcd2)) % MOD;
        total = (total + dp(i + 1, gcd1, gcdTable[gcd2][x])) % MOD;

        memo[i][gcd1][gcd2] = total;
        return total;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}