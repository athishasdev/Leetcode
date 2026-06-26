class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";

        for(String s : words){
            int sum = 0;
            for(char c : s.toCharArray()){
                sum += weights[c - 'a'];
            }
            char c = (char)('z'-(sum % 26));

            res += c;
        }

        return res;
    }
}