class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int num = 0;

        while(n > 0){
            int t = n % 10;
            if(t != 0){
                sum += t;
                num = num * 10 + t;
            }
            n /= 10;
        }
        int sum2 = 0;
        while(num > 0){
            int t = num % 10;
            sum2 = sum2 * 10 + t;
            num /= 10;
        }
        return (long) sum * sum2;
    }
}