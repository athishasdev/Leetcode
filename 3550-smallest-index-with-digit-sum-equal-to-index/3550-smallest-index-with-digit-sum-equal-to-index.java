class Solution {
    public int sum(int n){
        int sum = 0;

        while(n > 0){
            int temp = n % 10;
            sum += temp;
            n /= 10;
        }

        return sum;
    }
    public int smallestIndex(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(sum(nums[i]) == i){
                min = Math.min(min,i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}