// 0ms. Log n 풀이도 있는데 이건 다음에..
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int currIndex = 0;
        int currNum = 1;
        while (k > 0) {
            if (currIndex == arr.length) {
                currNum++;
                k--;
                continue;
            }

            if (arr[currIndex] != currNum) {
                k--;
            } else {
                currIndex++;
            }
            currNum++;
        }
        return currNum-1;
    }
}
