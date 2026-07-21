class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prevZero = 0;
        int currZero = 0;

        int totalOnes = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                totalOnes++;
            }
        }

        int max = 0;
        int gain = 0;
        int ones = 0;

        int i = 0;

        while(i < s.length()){
            while(i < s.length() && s.charAt(i) == '0'){
                prevZero++;
                i++;
            }
            while(i < s.length() && s.charAt(i) == '1'){
                ones++;
                i++;
            }
            while(i < s.length() && s.charAt(i) == '0'){
                currZero++;
                i++;
            }
            if(prevZero > 0 && currZero > 0 && ones > 0 ){
                max = Math.max(max, prevZero + currZero);
            }
            prevZero = currZero;
            ones = 0;
            currZero = 0;
            
        }

        return totalOnes + max;
    }
}