class Solution {
    public boolean canAliceWin(int[] nums) {
        int d = 0;
        int s = 0;

        for(int i : nums){
            if(i < 10){
                s += i;
            }
            else{
                d += i;
            }
        }
        if(s != d){
            return true;
        }
        return false;
    }
}