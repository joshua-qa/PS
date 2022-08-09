/**
 * 42ms. 이게 왜 미디엄이야... 진짜 어렵게 느껴졌지만 다행히 자력으로 풀었다.
 * 솔루션 보니까 내가 접근한 방식이랑 거의 비슷한데, 내 접근방식은 늘 정해랑 잘 안맞는 경향이 있어서 좀 신기..
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int length = arr.length;
        long mod = 1000000007;
        Arrays.sort(arr);
        long result = 0;
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Long> count = new HashMap<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < length; i++) {
            long currCount = 1;
            for (int j = 0; arr[j] * arr[j] <= arr[i]; j++) {
                int div = arr[i] / arr[j];
                if (arr[i] % arr[j] == 0 && set.contains(div)) {
                    long x = count.getOrDefault(div, 1L);
                    long y = count.getOrDefault(arr[j], 1L);
                    if (arr[j] == div) {
                        currCount += (x * y);
                    } else {
                        currCount += (x * y * 2);
                    }
                }
            }
            count.put(arr[i], currCount);
        }
        for (int key : count.keySet()) {
            result += count.get(key);
        }
        return (int) (result % mod);
    }
}
