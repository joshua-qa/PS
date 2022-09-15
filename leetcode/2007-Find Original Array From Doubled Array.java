// 53ms. 이정도만 해도 충분히 빠르지만 정렬을 하는 바람에 느려졌다.
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if ((length & 1) == 1) {
            return new int[0];
        }
        int[] result = new int[length/2];
        int[] count = new int[100001];
        for (int i = 0; i < length; i++) {
            count[changed[i]]++;
        }

        int resultIndex = 0;
        Arrays.sort(changed);
        for (int i = length - 1; i >= 0; i--) {
            int num = changed[i];
            if ((num & 1) == 1 || count[num] == 0) {
                continue;
            }

            if (count[num / 2] == 0) {
                return new int[0];
            }

            if (resultIndex == result.length) {
                return new int[0];
            }
            result[resultIndex++] = num / 2;
            count[num]--;
            count[num / 2]--;
            if (count[num] < 0 || count[num / 2] < 0) {
                return new int[0];
            }
        }

        if (resultIndex != result.length) {
            return new int[0];
        }
        return result;
    }
}
