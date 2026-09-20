class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int t =  'z' - c + 1;

            res += t * (i+1);

        }
        return res;
    }
}