class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }
            else{
                int val = stack.pop();

                int temp = 0;

                if(val == 0){
                    temp = 1;
                }
                else{
                    temp = 2 * val;
                }
                stack.push(stack.pop() + temp);
            }
        }

        return stack.pop();
    }
}