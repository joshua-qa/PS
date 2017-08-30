import java.util.*;
class Solution {
	public int solution(String[] strs, String t) {
        int answer = 0;
        int len = t.length();
        int strsLen = 0;
        int[] D = new int[len+1];
        Arrays.fill(D, 1, D.length, -1);

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < strs.length; j++) {
                if(i < strs[j].length()) {
                    continue;
                }

                strsLen = strs[j].length();
                if(t.substring(i-strsLen, i).equals(strs[j]) && D[i-strsLen] != -1) {
                    if(D[i] == -1) {
                        D[i] = D[i-strsLen] + 1;
                    } else if(D[i] > D[i-strsLen] + 1) {
                        D[i] = D[i-strsLen] + 1;
                    }
                }
            }
        }
        return D[len];
    }
}