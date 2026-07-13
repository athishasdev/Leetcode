class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String num = "123456789";
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < num.length(); i++){
            for(int j = i+1; j < num.length(); j++){
                int x = Integer.parseInt(num.substring(i,j+1));
                if(x >= low && x <= high){
                    list.add(x);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}