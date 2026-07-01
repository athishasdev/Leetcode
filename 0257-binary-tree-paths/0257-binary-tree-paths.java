
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        dfs(root, "", list);

        return list;
    }

    public void dfs(TreeNode root, String s, List<String> list){
        if(root == null){
            return;
        }

        if(s.length() == 0){
            s += root.val;
        }
        else{
            s += "->" + root.val;
        }

        if(root.left == null && root.right == null){
            list.add(s);
            return;
        }

        dfs(root.left,s,list);
        dfs(root.right,s,list);
    }
}