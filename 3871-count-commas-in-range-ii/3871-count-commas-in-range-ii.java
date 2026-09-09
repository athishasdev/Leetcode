class Solution {
    public long countCommas(long n) {
        if(n - 999 < 0) return 0;

        long commas = 0;

        long base = 1000;

        while(n >= base-1){
            commas += n - (base -1);
            base *= 1000;
        }
        
        return commas;        
    }
}