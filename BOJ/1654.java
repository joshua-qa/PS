import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int N, M;
    private long result;
    private long[] lan;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        lan = new long[N];
        long max = 0;

        for(int i = 0; i < N; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(lan[i], max);
        }

        rec(1, (1+max) / 2, max);
        System.out.print(result);
    }

    private void rec(long min, long mid, long max) {
        if(min > max) {
            result = mid;
            return;
        }
        int curr = 0;

        for(long i : lan) {
            curr += i / mid;
        }

        if(curr < M) {
            rec(min, (min+mid-1)/2, mid-1);
        } else {
            rec(mid+1, (mid+max+1)/2, max);
        }
    }
}