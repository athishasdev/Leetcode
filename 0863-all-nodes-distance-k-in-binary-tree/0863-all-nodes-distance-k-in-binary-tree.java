/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public Map<TreeNode,TreeNode> findParents(TreeNode root){
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return map;

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr.left != null){
                queue.add(curr.left);
                map.put(curr.left,curr);
            }

            if(curr.right != null){
                queue.add(curr.right);
                map.put(curr.right,curr);
            }
        }
        return map;
        
    }

    public List<Integer> bfs(Map<TreeNode,TreeNode> parent,TreeNode target,int k){
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(target);
        visited.add(target);
        
        int dis = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            if(dis == k){
                while(!queue.isEmpty()){
                    list.add(queue.poll().val);
                }
                return list;
            }

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(parent.containsKey(curr)){
                    TreeNode p = parent.get(curr);
                    if(!visited.contains(p)){
                        queue.add(p);
                        visited.add(p);
                    }
                }

                if(curr.left != null && !visited.contains(curr.left)){
                    queue.add(curr.left);
                    visited.add(curr.left);
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
            }
            dis++;
        }
        return list;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<>();
        
        Map<TreeNode,TreeNode> parent = new HashMap<>();

        parent = findParents(root);
        return bfs(parent,target,k);
    }
}