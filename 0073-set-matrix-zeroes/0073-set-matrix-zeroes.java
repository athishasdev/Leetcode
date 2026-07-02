class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int temp[] = queue.poll();

            int i = temp[0];
            int j = temp[1];

            for(int id = 0; id < rows; id++){
                matrix[id][j] = 0;
            }

            for(int jd = 0; jd < cols; jd++){
                matrix[i][jd] = 0;
            }
        }
    }
}