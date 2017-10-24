import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;

        if(n == m && n == k) {
            ans = 10000 + (n * 1000);
        } else if(n == m || n == k) {
            ans = 1000 + (n * 100);
        } else if(m == k) {
            ans = 1000 + (m * 100);
        } else {
            ans = Math.max(Math.max(n, m), k) * 100;
        }

        System.out.print(ans);
    }
}