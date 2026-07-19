class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            freq[c - 'a'] = i;
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(visited[c-'a']){
                continue;
            }
            while(!stack.isEmpty() && c < stack.peek() && freq[stack.peek()-'a'] > i){                
                char removed = stack.pop();
                visited[removed-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        String res = "";
        for(char c : stack){
            res = res + c;
        }
        return res;
    }
}