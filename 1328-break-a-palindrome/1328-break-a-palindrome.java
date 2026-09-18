class Solution {
    public String breakPalindrome(String s) {;
        if(s.length() == 1){
            return "";
        }
        char[] res = s.toCharArray();
        boolean done = false;

        for(int i = 0; i < s.length()/2; i++){
            if(!done && s.charAt(i) != 'a'){
                res[i] = 'a';
                done = true;
                break;
            }
        }

        if(!done){
            res[res.length-1] = 'b';
        }

        return new String(res);
    }
}