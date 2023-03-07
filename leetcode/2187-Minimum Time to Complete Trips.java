// 206ms. 의외로 쉽게 쉽게 풀었다. long으로 계산해야하는 곳에 int를 썼다가 한 번 틀리긴 했지만...
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int length = time.length;
        if (length == 1) {
            return (long) totalTrips * (long) time[0];
        }
        long minValue = Long.MAX_VALUE;

        for (int t : time) {
            if (t < minValue) {
                minValue = t;
            }
        }
        long start = 1;
        long end = minValue * (long) totalTrips;
        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int t : time) {
                count += (mid / t);
            }
            if (count >= totalTrips) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
