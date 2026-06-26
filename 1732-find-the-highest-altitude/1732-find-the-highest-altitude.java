class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int ch[] = new int[n+1];

        ch[0] = 0;

        for(int i = 1; i <= n; i++){
           ch[i] = ch[i-1] + gain[i-1];
        }

        int high = Integer.MIN_VALUE;
        for(int i : ch){
            if(i > high) high = i;
        }
        return high;
    }
}