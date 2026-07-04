class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int i = 0;
        int j = len-1;

        while (i < j){
            int add = numbers[i]+numbers[j];
            if(add == target)
                return new int[]{i+1,j+1};
            else if(add > target)
                j--;
            else
                i++;
        }      

        return new int[]{1};  
        

    }
}