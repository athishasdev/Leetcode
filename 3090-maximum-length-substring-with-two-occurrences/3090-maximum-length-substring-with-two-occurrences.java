class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freq[c - 'a']++;

            while(freq[c-'a'] > 2){
                char remove = s.charAt(left);
                freq[remove - 'a']--;
                left++;
            }

            max = Math.max(max, right-left+1);
        }
        return max;
    }
}