// 4ms. 약간의 함정은 있지만 간단한 그리디
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int start = 0;
        int end = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        int currPower = power;
        Arrays.sort(tokens);

        while (start <= end) {
            if (currPower >= tokens[start]) {
                score++;
                currPower -= tokens[start];
                start++;
                maxScore = maxScore > score ? maxScore : score;
            } else if (score >= 1) {
                score--;
                currPower += tokens[end];
                end--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
