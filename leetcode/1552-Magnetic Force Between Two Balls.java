// 35ms. 이분 탐색 응용 문제임.
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        if (m == 2) {
            return position[n-1] - position[0];
        }

        if (n == m) {
            int max = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int curr = position[i] - position[i-1];
                max = Math.min(max, curr);
            }
            return max;
        }

        int start = 1;
        int end = (position[n-1] - position[0]) / (m-1);
        int result = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isAvailable(position, m-1, n, mid)) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return result;
    }

    private boolean isAvailable(int[] position, int m, int n, int mid) {
        int prev = position[0];
        int lastPosition = position[n-1];
        int remainBall = m;

        for (int i = 1; i < n; i++) {
            int currForce = position[i] - prev;
            if (currForce >= mid) {
                remainBall--;
                prev = position[i];
            }
        }

        return remainBall <= 0;
    }
}
