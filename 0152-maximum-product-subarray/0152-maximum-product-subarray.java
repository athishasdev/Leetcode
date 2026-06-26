class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        if(n == 1) return nums[0];

        for(int i = 0; i < n; i++){
            int temp = 1;
            for(int j = i; j < n; j++){
                temp *= nums[j];
                max = Math.max(max,temp);
            }            
        }

        return max;
    }
}