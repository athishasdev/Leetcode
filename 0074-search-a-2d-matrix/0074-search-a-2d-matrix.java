class Solution {
    public boolean binary(int[][] matrix, int first, int last,int target,int m){
        if(first > last){
            return false;
        }

        int mid = first + (last - first) / 2;
        System.out.println(mid);

        int row = mid / m;
        int col = mid % m;
        
        if(matrix[row][col] == target){
            return true;
        }
        else if(matrix[row][col] > target){
            return binary(matrix,first,mid-1,target,m);
        }
        else{
            return binary(matrix,mid+1,last,target,m);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;

        return binary(matrix,0,n*m-1,target,m);
    }
}