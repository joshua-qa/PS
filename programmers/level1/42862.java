class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] students = new int[n+1];
        for (int i : lost) {
            students[i]--;
        }
        for (int i : reserve) {
            students[i]++;
            if (students[i] == 0) {
                for (int j = 0; j < lost.length; j++) {
                    if (lost[j] == i) {
                        lost[j] = -1;
                    }
                }
                answer++;
            }
        }
        for (int i : lost) {
            if (i == -1) {
                continue;
            }
            if (i != 0 && students[i-1] == 1) {
                students[i-1] = 0;
                answer++;
                continue;
            }
            if (i != n && students[i+1] == 1) {
                students[i+1] = 0;
                answer++;
            }
        }
        return answer;
    }
}