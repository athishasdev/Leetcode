class Solution {
    public int[][] merge(int[][] interval) {
        Arrays.sort(interval,(a,b) -> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();

        stack.push(interval[0]);

        for(int i = 1; i < interval.length; i++){
            int[] top = stack.peek();

            if(interval[i][0] <= top[1]){
                top[1] = Math.max(top[1],interval[i][1]);
            }
            else{
                stack.push(interval[i]);
            }
        }

        return stack.toArray(new int[stack.size()][]);
    }
}