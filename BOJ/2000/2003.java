import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.valueOf(st.nextToken());
        }

        System.out.print(solve(n, m, num));
    }

    private static int solve(int n, int m, int[] num) {
        if(n == 1) {
            return (m == num[0]) ? 1 : 0;
        }
        int start = 0, end = 1, count = 0, curr = num[start] + num[end];

        while(true) {
            if(end == n-1 && curr < m) {
                break;
            }

            if(curr > m && start <= end) {
                curr -= num[start++];
            } else if(curr == m) {
                count++;
                if(end == n-1) {
                    break;
                }
                curr += num[++end];
            } else {
                curr += num[++end];
            }
        }

        return count;
    }
}