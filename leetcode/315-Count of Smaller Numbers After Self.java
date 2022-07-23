// 39ms. fenwick tree는 index를 1부터 시작해야 헷갈릴 일이 없는듯..
class Solution {
    int[] tree;
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        tree = new int[20002];
        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            nums[i] += 10001;
            update(nums[i], 1);
        }

        for (int i = 0; i < length; i++) {
            int count = sum(nums[i]-1);
            result.add(count);
            update(nums[i], -1);
        }
        return result;
    }

    private void update(int i, int diff) {
        while (i < tree.length) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    private int sum(int i) {
        int result = 0;
        while (i > 0) {
            result += tree[i];
            i -= (i & -i);
        }
        return result;
    }
}
