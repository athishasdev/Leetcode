class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n*m;
        List<List<Integer>> res = new ArrayList<>();
        int[][] t = new int[n][m];

        k %= total;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int index = i * m + j;
                int newRow = ((index + k) % total) / m;
                int newCol = ((index + k) % total) % m;

                t[newRow][newCol] = grid[i][j];
            }
        }

        for(int[] arr: t){
            List<Integer> list = new ArrayList<>();
            for(int i : arr){
                list.add(i);
            }
            res.add(list);
        }

        return res;
    }
}