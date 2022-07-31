// 75ms. (faster than 97.81%) 블로그에 써볼만한 문제인듯.. fenwick tree 연습하기 좋다.
class NumArray {
    int[] table;
    int[] tree;
    int size;
    public NumArray(int[] nums) {
        size = nums.length;
        table = new int[size+1];
        tree = new int[size+1];
        for (int i = 1; i <= size; i++) {
            init(i, nums[i-1]);
        }
    }
    public void init(int index, int val) {
        table[index] = val;
        while (index <= size) {
            tree[index] += val;
            index += (index & -index);
        }
    }
    public void update(int index, int val) {
        index++;
        int prev = table[index];
        int updateVal = val - prev;
        table[index] = val;
        while (index <= size) {
            tree[index] += updateVal;
            index += (index & -index);
        }
    }
    public int sumRange(int left, int right) {
        if (left > right) {
            return 0;
        }
        int sum = sum(right+1);
        if (left == 0) {
            return sum;
        }
        return sum - sum(left);
    }
    private int sum(int index) {
        int result = 0;
        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
