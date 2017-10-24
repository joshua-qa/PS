import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private StringTokenizer st;
    private int M, N, x, y;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(cal(M, N, x, y) + "\n");
        }

        System.out.print(sb);
    }

    private int cal(int m, int n, int x, int y) {
        int result = -1;
        int i = 0, j = 0;
        int g = m+n;
        while (i <= g && i <= g) {
            if(m * i + x == n * j + y) {
                result = m * i + x;
                break;
            } else if(m * i + x > n * j + y) {
                j++;
            } else if(m * i + x < n * j + y) {
                i++;
            }
        }

        return result;
    }
}