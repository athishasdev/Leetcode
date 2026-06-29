class Solution {
    public int numOfStrings(String[] patterns, String word) {


        int count = 0;
        int n = word.length();

        for(String s : patterns){
            if(word.contains(s))count++;
        }
        

        return count;
    }
}