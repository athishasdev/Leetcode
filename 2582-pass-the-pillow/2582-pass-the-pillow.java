class Solution {
    public int passThePillow(int n, int time) {
        int cycle = time / (n-1);
        int place = time % (n-1);
        
        return (cycle % 2 == 0) ? place + 1 : n - place;
    }
}