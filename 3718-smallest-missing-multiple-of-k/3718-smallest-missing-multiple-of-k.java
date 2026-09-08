class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i = 1;
        
        Set<Integer> set = new HashSet<>();

        for(int x : nums) set.add(x);

        while(true){
            int num = k * i++;
            if(!set.contains(num)) return num;
        }
    }
}