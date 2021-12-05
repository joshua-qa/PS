class Solution {
    /**
     * 평범한 팰린드롬 문제 풀이 방식과 동일하게, 문자열 상태에서 비교하기.
     * 공간 복잡도 면에서 유리하게 나왔음.
     * Runtime:7 ms, faster than 76.31% of Java online submissions.
     * Memory Usage:37.8 MB, less than 99.92% of Java online submissions.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        char[] nums = String.valueOf(x).toCharArray();

        for (int i = 0; i * 2 < nums.length; i++) {
            if (nums[i] != nums[nums.length-1-i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Follow up: Could you solve it without converting the integer to a string?
     * lookup 테이블을 만들거나 다른 방법을 사용해서 자릿수 계산을 처리한다.
     * 문자열로 바꿔서 하는 것보다 실행속도 빠름.
     * Runtime:6 ms, faster than 99.96% of Java online submissions.
     * Memory Usage:38.3 MB, less than 77.60% of Java online submissions.
     */
    public boolean isPalindromeFollowUp(int x) {
        if (x < 0) {
            return false;
        }
        int[] table = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        int length = 0;
        for (int i = 1; i < 10; i++) {
            if (x < table[i]) {
                break;
            }
            length = i;
        }
        if (length == 0) {
            return true;
        }

        int start = 0;
        int result = 0;
        int origin = x;
        while (start * 2 <= length) {
            int num = x % 10;
            int matchNum = num * table[length-start];
            if (start * 2 != length) {
                result += ((num * table[start]) + matchNum);
            } else {
                result += matchNum;
            }

            x /= 10;
            start++;
        }
        return origin == result;
    }
}