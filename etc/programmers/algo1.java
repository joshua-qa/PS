import java.util.*;

public class Solution {
	public int solution(int n) {
		int answer = 0;
        char[] ca = String.valueOf(n).toCharArray();
        for(char c : ca) {
            answer += c - '0';
        }
		return answer;
	}
}