// 3ms. 연습할 가치가 있는 문제였다. 사람들이 풀어놓은 해답이 매우 짧아서 놀랬다.
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        int start = 0;
        while (start < length-1 && nums[start] >= nums[start+1]) {
            start++;
        }
        if (start > length-3) {
            return false;
        }

        int mid = start+1;
        int curr = start+2;
        while (curr < length) {
            if (nums[mid] < nums[curr]) {
                return true;
            }
            if (nums[mid] == nums[curr]) {
                curr++;
                continue;
            }
            if (nums[mid] > nums[curr]) {
                if (curr+1 == length) {
                    return false;
                }
                if (nums[curr] < nums[start] && nums[mid] > nums[curr+1]) {
                    start = curr;
                    mid = curr+1;
                    curr = curr+2;
                    continue;
                }
                if (nums[curr] > nums[start]) {
                    mid = curr;
                    if (nums[curr] < nums[curr+1]) {
                        return true;
                    }
                }
                curr++;
            }
        }
        return false;
    }
}
