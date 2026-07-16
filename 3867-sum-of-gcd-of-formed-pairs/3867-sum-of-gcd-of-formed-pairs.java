class Solution {
    public long gcd(long a, long b){
        if(b == 0) return a;

        return gcd(b ,a % b);
    }
    public long gcdSum(int[] nums) {
        long n = nums.length;
        
        long[] prefix = new long[(int)n];
        long[] max = new long[(int)n];
        max[0] = nums[0];

        for(int i = 1; i < n; i++){
            max[i] = Math.max(nums[i],max[i-1]);
        }
        
        for(int i = 0; i < (int)n; i++){
            prefix[i] = gcd(max[i],nums[i]);
        }

        Arrays.sort(prefix);

        long sum = 0;

        int i = 0;
        int j = prefix.length-1;

        while(i < j){
            sum += gcd(prefix[i],prefix[j]);
            i++;
            j--;
        }

        return sum;
    }
}