class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int index = 0;
        String res = "";

        for(String s : words){
            int sum = 0;
            for(char c : s.toCharArray()){
                sum += weights[c - 'a'];
            }
            index += s.length();
            char c = (char)('z'-(sum % 26));

            res += c;
        }

        return res;
    }
}