class Solution {
    public int minAddToMakeValid(String s) {
       int r = 0;
       int count = 0;

       for(char c : s.toCharArray()){
        if(c == '('){
            r++;
        }
        else{
            if(r > 0)
                r--;            
            else
                count++;
        }
       }
       return count+r;
    }
}