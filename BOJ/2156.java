package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 8..
 */
public class Main {
    static int[] DP = new int[10001];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] A = new int[N];
        int ans = 0;

        for(int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        if (N > 2) {
            DP[0] = A[0];
            DP[1] = DP[0] + A[1];
            DP[2] = Math.max(A[0] + A[1], Math.max(DP[0] + A[2], A[1] + A[2]));
            int two, three, not;

            for (int i = 3; i < N; i++) {
                two = DP[i - 2];
                three = DP[i - 3] + A[i - 1];
                not = DP[i - 1];

                DP[i] = Math.max(not, (Math.max(two, three) + A[i]));
            }

            System.out.println(Math.max(DP[N - 2], DP[N - 1]));
        } else if (N == 1) {
            System.out.println(A[0]);
        } else if (N == 2) {
            System.out.println(A[0] + A[1]);
        }
    }
}