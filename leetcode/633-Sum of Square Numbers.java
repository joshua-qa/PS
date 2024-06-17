// 간단하게 풀었지만 다른 풀이들보다 많이 느려서 다음에 다시 해봐야함..
class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> squares = new HashSet<>();

        for (long i = 0; i * i <= c; i++) {
            long square = i * i;
            squares.add(square);
            if (squares.contains(c - square)) {
                return true;
            }
        }
        return false;
    }
}
