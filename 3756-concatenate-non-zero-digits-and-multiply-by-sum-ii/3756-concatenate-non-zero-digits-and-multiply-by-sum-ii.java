class Solution {
    public int lowerBound(ArrayList<Integer> list, int target){
        int f = 0;
        int l = list.size();

        while(f < l){
            int mid = f + (l - f) / 2;

            if(list.get(mid) < target){
                f = mid + 1;
            }
            else{
                l = mid;
            }
        }
        return f;
    }
    public int upperBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;
        int arr[] = new int [n];
        int prefix[] = new int[s.length()];
        int sum = 0;
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            int t = s.charAt(i) - '0'; 
            sum += t;
            prefix[i] = sum;
            if(t != 0){
                digits.add(t);
                pos.add(i);
            }
        }
        long MOD = 1000000007L;

        long[] pow10 = new long[digits.size() + 1];
        pow10[0] = 1;

        for (int i = 1; i <= digits.size(); i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixConcat = new long[digits.size() + 1];

        for (int i = 0; i < digits.size(); i++) {
            prefixConcat[i + 1] = (prefixConcat[i] * 10 + digits.get(i)) % MOD;
        }

        for(int i = 0; i < n; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int start = lowerBound(pos,l);
            int end = upperBound(pos,r) - 1 ;

            if(start > end ){
                arr[i] = 0;
                continue;
            }
            int digitSum = prefix[r];
            if (l > 0) {
                digitSum -= prefix[l - 1];
            }

            int len = end - start + 1;

            long number =
                    (prefixConcat[end + 1]
                    - (prefixConcat[start] * pow10[len]) % MOD
                    + MOD) % MOD;

            arr[i] = (int) ((number * digitSum) % MOD);
        }
        
        return arr;
    }
}