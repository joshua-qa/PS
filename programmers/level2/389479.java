/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/389479
 * 코딩테스트 연습 > 2025 프로그래머스 코드챌린지 2차 예선 > 서버 증설 횟수 (Lv 2)
 */
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] prefixSum = new int[48];
        // 현재 최대 수용 가능한 인원수를 기록해뒀다가 이용자수랑 비교하고, prefixSum에 증설 필요한 숫자를 더함
        // 현재 인덱스에 +n을 하고, +k번째 index에 -n을 해야함
        int currMaxUsers = m;
        for (int i = 0; i < 24; i++) {
            if (i != 0) {
                prefixSum[i] += prefixSum[i-1];
            }

            currMaxUsers = (prefixSum[i] + 1) * m;
            // System.out.println("currMaxUsers : " + currMaxUsers + ", index : " + i);
            if (players[i] >= currMaxUsers) {
                int needNewServers = (players[i] + m - currMaxUsers) / m;
                // System.out.println("currMaxUsers : " + currMaxUsers + ", needNewServers : " + needNewServers);
                answer += needNewServers;
                prefixSum[i] += needNewServers;
                prefixSum[i+k] -= needNewServers;
            }
        }
        
        return answer;
    }
}
