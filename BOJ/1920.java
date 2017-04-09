package Joshua.PS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 4. 9..
 */
public class Main {
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] N = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        int[] M = new int[m];
        for (int i = 0; i < m; i++) {
            M[i] = scan.nextInt();
        }

        Arrays.sort(N);

        solution(N, M);
    }

    private static void solution(int[] N, int[] M) {

        for (int i = 0; i < M.length; i++) {
            sb.append( Arrays.binarySearch(N, M[i]) >= 0 ? "1" : "0" );
            if(i != M.length - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}