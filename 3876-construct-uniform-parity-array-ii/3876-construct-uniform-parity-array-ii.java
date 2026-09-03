class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int i : nums){
            min = Math.min(min,i);
        }

        if(min % 2 != 0) return true;

        for(int i : nums){
            if(i % 2 != 0) return false;
        }

        return true;
    }
}