class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int i : nums){
            max = Math.max(max,i);
        }

        int[] freq = new int[max+1];

        for(int i : nums){
            freq[i]++;
        }

        int count[] = new int[max+1];

        for(int i = 1; i <= max; i++){
            for(int j = i; j <= max; j+=i){
                count[i] += freq[j];
            }
        }

        long[] gcd = new long[max+1];

        for(int i = max; i >= 1; i--){
            long p = (long) count[i] *(count[i]-1) / 2;
            for(int j = i*2; j <= max; j+=i){
                p -= gcd[j];
            }
            gcd[i] = p;
        }

        long[] prefix = new long[max+1];
        for(int i = 1; i <= max; i++){
            prefix[i] = prefix[i-1] + gcd[i];
        }

        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            long k = queries[i]+1;

            int left = 1;
            int right = max; 

            while(left < right){
                int mid = left + (right - left) / 2;

                if(prefix[mid] >= k){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }
            res[i] = left;
        }

        return res;
    }
}