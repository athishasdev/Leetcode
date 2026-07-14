class Solution {
    public int total (int arr[]){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(total(gas) < total(cost)) return -1;
        
        int g = 0;
        int n = gas.length;
        int start = 0;

        for(int i = 0; i < n; i++){
            g += gas[i] - cost[i];
            if(g < 0){
                start = i+1;
                g = 0;
            }                       
        }
        if(g < 0 ) return -1;
        return start;
    }
}