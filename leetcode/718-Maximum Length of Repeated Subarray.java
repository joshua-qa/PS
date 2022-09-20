// 41ms. 첫 제출에 TLE 나와서 놀랬는데 최적화 하다보니 생각보다 재밌는 문제였음
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int result = 0;
        for (int i = 0; i < nums1Length; i++) {
            int nums2End = (i == 0) ? nums2Length : 1;
            for (int j = 0; j < nums2End; j++) {
                int l = i;
                int r = j;
                int curr = 0;
                int max = 0;
                while (l < nums1Length && r < nums2Length) {
                    if (nums1[l++] == nums2[r++]) {
                        curr++;
                    } else {
                        max = max < curr ? curr : max;
                        curr = 0;
                    }
                }
                max = max < curr ? curr : max;
                result = result < max ? max : result;
            }
        }
        return result;
    }
}
