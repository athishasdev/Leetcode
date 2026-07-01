class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;

        int freq[] = {-1,-1,-1};

        for(int i = 0; i < n; i++){
            freq[s.charAt(i)-'a'] = i;

            count += Math.min(freq[0],Math.min(freq[1],freq[2]))+1;
        }

        return count;
    }
}