class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        
        answer[0] = (v[0][0] == v[1][0]) ? v[2][0] : (v[0][0] == v[2][0]) ? v[1][0] : v[0][0];
        answer[1] = (v[0][1] == v[1][1]) ? v[2][1] : (v[0][1] == v[2][1]) ? v[1][1] : v[0][1];

        return answer;
    }
}