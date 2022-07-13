/**
 * 6ms. Monotonic Stack이 아닐까 고민했는데 단순 Two pointer였음.
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int start = 0, end = length-1;

        while (start < end) {
            int min = height[start] < height[end] ? height[start] : height[end];
            int curr = (end-start) * min;
            if (max < curr) {
                max = curr;
            }
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
