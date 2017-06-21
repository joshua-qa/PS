import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] input = new char[n][];

        for(int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();
        }

        System.out.println(solution(input, n));
    }

    private static String solution(char[][] input, int n) {
        StringBuffer sb = new StringBuffer();
        boolean[] status = new boolean[input[0].length];

        for(int i = 0; i < n-1; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(i == 0) {
                    if (input[i][j] == input[i + 1][j]) {
                        status[j] = true;
                    }
                } else {
                    if (input[i][j] != input[i + 1][j] && status[j]) {
                        status[j] = false;
                    }
                }
            }
        }

        for(int i = 0; i < input[0].length; i++) {
            if(status[i] || n == 1) {
                sb.append(input[0][i]);
            } else {
                sb.append("?");
            }
        }

        return sb.toString();
    }
}