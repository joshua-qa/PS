package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua on 2017-06-13.
 */
public class Main {
    static char[][] star = new char[3072][6144];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        rec(N, 0, N-1);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N; j++) {
                if(star[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append(star[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void rec(int n, int currentLine, int currentColumn) {
        if(n == 3) {
            star[currentLine][currentColumn] = 42;
            star[currentLine + 1][currentColumn - 1] = 42;
            star[currentLine + 1][currentColumn + 1] = 42;
            star[currentLine + 2][currentColumn - 2] = 42;
            star[currentLine + 2][currentColumn - 1] = 42;
            star[currentLine + 2][currentColumn] = 42;
            star[currentLine + 2][currentColumn + 1] = 42;
            star[currentLine + 2][currentColumn + 2] = 42;
            return;
        } else {
            rec(n/2, currentLine, currentColumn);
            rec(n/2, currentLine + n/2, currentColumn - n/2);
            rec(n/2, currentLine + n/2, currentColumn + n/2);
        }
    }
}
