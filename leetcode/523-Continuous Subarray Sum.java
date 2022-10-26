// 51ms. 12시까지 방법 생각 안나면 포기하려고했는데 다행히 생각해내서 풀었다..!
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        Map<Integer, List<Integer>> mods = new HashMap<>();
        prefixSum[0] = nums[0];
        List<Integer> modList = new ArrayList<>();
        modList.add(0);
        mods.put(prefixSum[0] % k, modList);
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            int mod = prefixSum[i] % k;
            if (mod == 0) {
                return true;
            }
            if (!mods.containsKey(mod)) {
                mods.put(mod, new ArrayList<>());
            }
            mods.get(mod).add(i);
        }

        for (int i = 1; i < length; i++) {
            int mod = prefixSum[i] % k;
            int index = mods.get(mod).get(0);
            if (index < i && i - index > 1) {
                return true;
            }
        }
        return false;
    }
}
