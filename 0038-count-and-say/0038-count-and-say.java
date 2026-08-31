class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for(int i = 0; i < n-1; i++){
            int count = 1;
            String t = "";
            for(int j = 1; j <= s.length(); j++){
                if(j < s.length() && s.charAt(j) == s.charAt(j-1)){
                    count++;
                }
                else{
                    t = t + count + s.charAt(j-1);
                    count = 1;
                }
            }
            s = t;
        }
        return s;
    }
}