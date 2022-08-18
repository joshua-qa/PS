// 25ms. 이상하게 제출할때마다 결과가 들쑥날쑥함 ㅋㅋ
class Solution {
    public int minSetSize(int[] arr) {
        int[] count = new int[100001];
        for (int num : arr) {
            count[num]++;
        }

        int length = arr.length;
        Arrays.sort(count);

        int start = 100000;
        int result = 0;
        int reducedSize = length;
        while (reducedSize * 2 > length && start >= 0) {
            reducedSize -= count[start--];
            result++;
        }
        return result;
    }
}
