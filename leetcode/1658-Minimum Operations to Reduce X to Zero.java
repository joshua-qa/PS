/**
 * 누적합 + Binary Search로 해결.. 23ms
 * 정해는 Two Pointer로 O(N) 인듯
 */
public int minOperations(int[] nums, int x) {
    int length = nums.length;
    int result = length + 1;
    if (length == 1) {
        return nums[0] == x ? 1 : -1;
    }

    int[] sum = new int[length+1];
    for (int i = 1; i <= length; i++) {
        sum[i] = sum[i-1] + nums[i-1];
    }

    int total = sum[length];
    if (total == x) {
        return length;
    }
    for (int i = 0; i < length; i++) {
        if (sum[i] == x) {
            result = result <= i ? result : i;
            continue;
        }
        if (i > result) {
            return result;
        }
        int curr = total - (x - sum[i]);
        int index = Arrays.binarySearch(sum, i+1, length, curr);
        if (index == -1) {
            continue;
        }
        int answer = length - (index - i);
        result = result <= answer ? result : answer;
    }
    return result == length + 1 ? -1 : result;
}