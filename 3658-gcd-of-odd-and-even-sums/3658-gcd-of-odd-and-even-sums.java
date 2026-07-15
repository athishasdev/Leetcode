class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int even = 0;
        for(int i = 1; i <= n*2; i+=2){
            odd += i;
        }
        
        for(int i = 2; i <= n*2; i+=2){
            even += i;
        }
        return gcd(odd,even);
    }
}