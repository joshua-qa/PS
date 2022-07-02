class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long mod = 1000000007;
        int hCutLength = horizontalCuts.length;
        int vCutLength = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hMax = Math.max(horizontalCuts[0], h - horizontalCuts[hCutLength-1]);
        int wMax = Math.max(verticalCuts[0], w - verticalCuts[vCutLength-1]);
        for (int i = 1; i < hCutLength; i++) {
            int curr = horizontalCuts[i] - horizontalCuts[i-1];
            if (hMax < curr) {
                hMax = curr;
            }
        }
        for (int i = 1; i < vCutLength; i++) {
            int curr = verticalCuts[i] - verticalCuts[i-1];
            if (wMax < curr) {
                wMax = curr;
            }
        }
        long result = (((long) hMax % mod) * ((long) wMax % mod)) % mod;
        return (int) result;
    }
}