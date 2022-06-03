class Solution {
    public int[] constructArray(int n, int k) {
        if (k == 1) {
            return createSequence(n);
        }

        int[] result = new int[n];
        int gap = n-1;
        int mid = (1 + n) / 2;
        int i = 0;
        for (int j = 1; i < n && k > 0; i++) {
            result[i] = j;
            j += gap;
            gap *= -1;
            gap = (gap > 0) ? gap-1 : gap+1;
            k--;
        }

        if (result[i-1] > mid) {
            gap = -1;
        } else {
            gap = 1;
        }
        while (i < n) {
            result[i] = result[i-1] + gap;
            i++;
        }

        return result;
    }

    private int[] createSequence(int n) {
        int[] sequence = new int[n];
        for (int i = 1; i <= n; i++) {
            sequence[i-1] = i;
        }
        return sequence;
    }
}