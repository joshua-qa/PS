// 19ms. 해시맵을 요령있게 쓰는게 중요함. 이런 문제에 익숙치 않으면 미디엄으로 느낄듯.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = numIndexMap.getOrDefault(nums[i], -1);
            if (index == -1) {
                numIndexMap.put(nums[i], i);
                continue;
            }

            if (abs(index - i) <= k) {
                return true;
            }

            numIndexMap.put(nums[i], i);
        }

        return false;
    }

    private int abs(int n) {
        return n < 0 ? -n : n;
    }
}
