/**
 * Two Pointer로 해결... 7ms
 * visit 배열 대신 HashSet을 쓰면 Memory Usage를 줄일 수 있으나 시간이 다소 증가함
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int length = nums.length;
        int left = 0;
        int right = 0;
        int currSize = 0;
        boolean[] visit = new boolean[10001];

        while (right < length) {
            if (visit[nums[right]]) {
                visit[nums[left]] = false;
                currSize -= nums[left++];
                continue;
            }
            visit[nums[right]] = true;
            currSize += nums[right];
            result = currSize > result ? currSize : result;
            right++;
        }
        return result;
    }
}