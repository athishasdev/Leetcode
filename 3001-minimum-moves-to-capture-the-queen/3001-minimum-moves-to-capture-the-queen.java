class Solution {
    public boolean between(int x, int y, int z){
        return Math.min(y,z) < x && x < Math.max(y,z);
    }
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if(a==e){
            if(!(c == a && between(d,b,f)))
                return 1;
        }
        if(b == f){
            if(!(d == b && between(c,a,e)))
                return 1;
        } 
        if(c-d == e-f){
            if(!(a-b == c-d && between(a,c,e))){
                return 1;
            }
        }
        if(c+d == e+f){
            if(!(a+b == c+d && between(a,c,e)))
                return 1;
        }
        return 2;
    }
}