// 12ms. 삼각형 성립 안되는 케이스만 알면 쉬움
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = length - 3; i >= 0; i--) {
            if (isAvailable(nums[i], nums[i+1], nums[i+2])) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }

    private boolean isAvailable(int x, int y, int z) {
        if (x + y <= z) {
            return false;
        }
        if (y + z <= x) {
            return false;
        }
        if (x + z <= y) {
            return false;
        }
        return true;
    }
}
