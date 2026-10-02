class Solution {
    public void backtrack(List<String> list, int n, String s, int open, int close){
        if(s.length() == 2 * n){
            list.add(s);
            return;
        }

        if(open < n){
            backtrack(list,n,s+'(',open+1,close);
        }

        if(close < open){
            backtrack(list,n,s+')',open,close+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res,n,"",0,0);

        return res;
    }
}