class Solution {
    public int maxNumberOfBalloons(String text) {
        String ball = "balloon";

        int freq[] = new int[26];

        for(char c : text.toCharArray()){
            if(ball.contains(Character.toString(c))){
                freq[c-'a']++;
            }
        }

        return Math.min(
                    Math.min(freq['a'-'a'],freq['b'-'a']),
                    Math.min(Math.min(freq['l'-'a']/2,freq['o'-'a']/2),
                            freq['n'-'a']));
    }
}