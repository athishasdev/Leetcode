class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;

        int first = 0;
        int last = m * n;

        while(first <= last){
            int mid = first + (last - first) / 2;
            if(mid >= m*n) return false;
            int row = mid / m;
            int col = mid % m;
            
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                last = mid - 1;
            }
            else{
                first = mid + 1;
            }
        }
        return false;
    }
}