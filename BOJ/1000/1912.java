package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jgchoi.qa on 2017. 5. 26..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];
        long[] dp = new long[n];
        long current = 0, max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = 0;
        while(st.hasMoreTokens()) {
            numArray[a++] = Integer.parseInt(st.nextToken());
        }

        max = -2147483649L;

        dp[0] = Math.max(max, numArray[0]);
        max = Math.max(max, dp[0]);
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + numArray[i], numArray[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}