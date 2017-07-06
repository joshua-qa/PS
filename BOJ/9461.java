import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] D = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int x;

        D[1] = 1;
        D[2] = 1;
        D[3] = 1;
        D[4] = 2;
        D[5] = 2;
        solution(100);
        for(int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            sb.append(D[x]+"\n");
        }

        System.out.print(sb.toString());
    }

    private static long solution(int x) {
        for(int i = 6; i <= x; i++) {
            D[i] = D[i-1] + D[i-5];
        }

        return D[x];
    }
}