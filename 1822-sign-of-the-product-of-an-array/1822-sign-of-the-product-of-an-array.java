class Solution {
    public int arraySign(int[] nums) {
        int val = 1;
        for(int i : nums){
            if(i == 0) return 0;
            if(i < 0) val *= -1;
        }
        return val; 
    }
}