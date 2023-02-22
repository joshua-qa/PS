// 10ms. 풀긴 풀었는데 지저분하게 풀어서 찝찝하다. 다음에 집중해서 다시 풀어야지..
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = weights[0];
        int length = weights.length;
        int sum = min;
        int maxNum = weights[0];
        for (int i = 1; i < length; i++) {
            min = min > weights[i] ? weights[i] : min;
            sum += weights[i];
            maxNum = maxNum < weights[i] ? weights[i] : maxNum;
        }
        if (days == 1) {
            return sum;
        }
        if (days == length) {
            return maxNum;
        }

        int start = maxNum;
        int end = sum;
        int result = sum;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid < maxNum) {
                start = maxNum;
                continue;
            }
            int currMax = 0;
            int currDays = 1;
            int curr = 0;
            for (int i = 0; i < length; i++) {
                if (curr + weights[i] > mid || days - currDays == length - i) {
                    currDays++;
                    currMax = currMax < curr ? curr : currMax;
                    curr = 0;
                }
                curr += weights[i];
            }

            if (currDays < days) {
                end = mid-1;
                continue;
            }
            if (currDays == days && result >= currMax && currMax >= maxNum) {
                result = currMax;
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}
