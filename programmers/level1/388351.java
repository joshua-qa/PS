/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 * 코딩테스트 연습 > 2025 프로그래머스 코드챌린지 1차 예선 > 유연근무제 (Lv 1)
 */
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 6 : 토, 7 : 일
        // (i + startday) % 7 = 0 + 5 % 7 = 5
        int n = schedules.length;
        for (int i = 0; i < n; i++) {
            int currSchedule = schedules[i];
            boolean isLate = false;
            for (int j = 0; j < 7; j++) {
                if (isLate(j, timelogs[i][j], startday, currSchedule)) {
                    isLate = true;
                    break;
                }
            }

            if (!isLate) {
                answer++;
            }
        }
        
        return answer;
    }

    private boolean isLate(int logIndex, int logTime, int startday, int schedule) {
        int currDay = (logIndex + startday) % 7;
        if (currDay == 0 || currDay == 6) {
            return false;
        }

        int logTimeMinutes = getMinutes(logTime);
        int scheduleMinutes = getMinutes(schedule);
        return (logTimeMinutes - scheduleMinutes) > 10;
    }

    private int getMinutes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return hour * 60 + minute;
    }
}
