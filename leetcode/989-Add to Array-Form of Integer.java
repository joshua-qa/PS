// 4ms. BigInteger로 풀면 매우 쉽지만 100ms가 넘어가서 의미없다.
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        String sk = String.valueOf(k);
        int plus = 0;
        for (int i = num.length-1; i >= 0; i--) {
            int curr = (k % 10) + num[i] + plus;
            k /= 10;
            plus = (curr >= 10) ? 1 : 0;
            curr = (curr >= 10) ? (curr % 10) : curr;
            result.add(curr);
        }
        if (k > 0) {
            while (k != 0) {
                int curr = (k % 10) + plus;
                k /= 10;
                plus = (curr >= 10) ? 1 : 0;
                curr = (curr >= 10) ? (curr % 10) : curr;
                result.add(curr);
            }
        }
        if (plus == 1) {
            result.add(plus);
        }
        Collections.reverse(result);
        return result;
    }
}
