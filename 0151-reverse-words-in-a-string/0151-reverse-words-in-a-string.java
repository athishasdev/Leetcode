class Solution {
    public String reverse(String s, int end){
        while(end >= 0 && s.charAt(end) == ' '){
            end--;
        }

        if(end < 0){
            return "";
        }

        int start = end;

        while(start >= 0 && s.charAt(start) != ' '){
            start--;
        }

        String word = s.substring(start+1,end+1);

        String sentance = reverse(s,start-1);

        if(sentance.isEmpty()){
            return word;
        }

        return word + " " + sentance;
    }
    public String reverseWords(String s) {
        return reverse(s, s.length()-1);
    }
}