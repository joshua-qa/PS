class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] count = new int[30];
        int[] bits = new int[30];
        int size = nums.length;
        int[] result = new int[size];
        int left = size-1, right = size-1;
        result[size-1] = 1;
        for (int i = 0; i < 30; i++) {
            int curr = 1 << i;
            bits[i] = curr;
            if ((curr & nums[size-1]) == curr) {
                count[i]++;
            }
        }

        int currMax = nums[size-1];

        for (int i = size-2; i >= 0; i--) {
            left--;
            currMax |= nums[left];
            if (nums[left] == 0) {
                result[left] = (currMax == 0) ? 1 : (right - left) + 1;
                continue;
            }
            for (int j = 0; j < 30; j++) {
                int curr = bits[j];
                if ((curr & nums[left]) == curr) {
                    count[j]++;
                }
                if (curr >= nums[left]) {
                    break;
                }
            }

            while (left < right) {
                boolean flag = false;
                for (int j = 0; j < 30; j++) {
                    int curr = bits[j];
                    if ((curr & nums[right]) == curr && count[j] == 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                for (int j = 0; j < 30; j++) {
                    int curr = bits[j];
                    if ((curr & nums[right]) == curr) {
                        count[j]--;
                    }
                }
                right--;
            }
            result[left] = (right - left) + 1;
        }
        return result;
    }
}
