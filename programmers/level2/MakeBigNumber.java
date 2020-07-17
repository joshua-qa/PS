import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int maxPos = 0;
        for (int i = 1; i < k; i++) {
            if (number.charAt(i) > number.charAt(maxPos)) {
                maxPos = i;
            }
        }
        number = number.substring(maxPos);
        k -= maxPos;
        int length = number.length();
        char[] nums = number.toCharArray();
        for (int i = 0, j = 0; i < length && k > 0; i++, j++) {
            if (i != length - 1 && nums[i] == nums[i+1]) {
                continue;
            }
            if (i < length - 1 && nums[i] < nums[i+1]) {
                while (j >= 0 && nums[j] < nums[i+1] && k > 0) {
                    if (nums[j] > 0) {
                        k--;
                    }
                    nums[j--] = 0;
                }
                j = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            sb.append(nums[i]);
        }
        return sb.substring(0, sb.length() - k);
    }
}