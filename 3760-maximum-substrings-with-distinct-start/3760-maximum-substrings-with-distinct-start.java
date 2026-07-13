class Solution {
    public int maxDistinct(String s) {
        int count = 0;
        int freq[] = new int[26];

        for(char c : s.toCharArray()){
            freq[c-'a']++;
            if(freq[c-'a'] == 1){
                count++;
            }
        }
        return count;
    }
}