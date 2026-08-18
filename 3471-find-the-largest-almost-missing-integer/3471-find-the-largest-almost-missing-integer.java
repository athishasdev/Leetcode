class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length-k+1; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < i+k; j++){
                set.add(nums[j]);
            }
            for(int val : set){
                map.put(val,map.getOrDefault(val,0)+1);
            }
        }

        int max = -1;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                max = Math.max(max,entry.getKey());
            }
        }

        return max;
    }
}