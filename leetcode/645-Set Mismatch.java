// 1ms. 수행속도 빨라서 만족. 해시맵 안써서 그런듯
class Solution {
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int duplicate = -1;
        int loss = -1;
        boolean[] visit = new boolean[length+1];
        for (int i = 1; i <= length; i++) {
            if (visit[nums[i-1]]) {
                duplicate = nums[i-1];
            }
            visit[nums[i-1]] = true;
        }
        for (int i = 1; i <= length; i++) {
            if (!visit[i]) {
                loss = i;
                break;
            }
        }
        return new int[]{duplicate, loss};
    }
}
