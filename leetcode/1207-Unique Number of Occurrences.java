// 1ms. 초간단한 방법으로 구현함
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int num : arr) {
            count[num+1000]++;
        }

        Set<Integer> countSet = new HashSet<>();
        for (int i = 0; i <= 2000; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (countSet.contains(count[i])) {
                return false;
            }
            countSet.add(count[i]);
        }
        return true;
    }
}

