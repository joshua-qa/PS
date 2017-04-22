package Joshua.PS.BOJ;

import java.util.Scanner;

/**
 * Created by Joshua on 2017-03-14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] R = new int[N];
        String[] S = new String[N];

        for (int i = 0; i < N; i++) {
            R[i] = scan.nextInt();
            S[i] = scan.next();
        }

        strPrint(R, S);
    }

    private static void strPrint(int[] r, String[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                for (int k = 0; k < r[i]; k++) {
                    sb.append(s[i].charAt(j));
                }
            }
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
    }
}
