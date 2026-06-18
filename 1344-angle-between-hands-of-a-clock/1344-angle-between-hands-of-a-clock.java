class Solution {
    public double angleClock(int hour, int minutes) {
            double angle = (double)Math.abs((double)(30 * hour) - (5.5 * (double) minutes));

            return (angle < 180) ? angle : 360 - angle ;
    }
}