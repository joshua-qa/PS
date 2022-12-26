// 2ms. 끝에 도달할 수 있는 케이스와 도달할 수 없는 케이스를 각각 그려서 비교해보면 쉽다.
// 8월에는 이 문제를 완전 헤매다가 겨우 풀었는데 지금은 그것보다 짧고 간결한 로직으로 풀 수 있어서 신난다.
class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;

        int start = nums[0];
        for (int i = 1; i < length; i++) {
            start--;
            if (start < 0) {
                return false;
            }
            if (nums[i] > start) {
                start = nums[i];
            }
        }
        return true;
    }
}
