class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        if (!isAvailable(sum, mean, m, n)) {
            return new int[0];
        }

        int[] result = new int[n];
        // fill
        int expectSum = mean * (m + n);
        int remain = expectSum - sum;
        int div = remain / n;
        int mod = remain % n;

        for (int i = 0; i < n; i++) {
            result[i] = div;
            if (mod > 0) {
                result[i]++;
                mod--;
            }
        }

        return result;
    }

    private boolean isAvailable(int sum, int mean, int m, int n) {
        double min = sum + n;
        double max = sum + (n * 6);
        double totalSize = m + n;
        if (min / totalSize > (double) mean || max / totalSize < (double) mean) {
            return false;
        }

        return true;
    }
}
