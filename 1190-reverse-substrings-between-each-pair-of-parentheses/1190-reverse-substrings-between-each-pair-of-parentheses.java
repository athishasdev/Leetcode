class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(sb);
                sb = new StringBuilder();
            }
            else if(ch == ')'){
                sb.reverse();

                StringBuilder prev = stack.pop();
                prev.append(sb);

                sb = prev;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}