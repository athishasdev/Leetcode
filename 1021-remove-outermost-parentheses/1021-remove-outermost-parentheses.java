class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String res = "";
        for(char c : s.toCharArray()){
            if(c == '('){
                if(count > 0) res += c;
                count++;
            }
            else{
                count--;
                if(count > 0) res += c;
            }
        }
        return res;
    }
}