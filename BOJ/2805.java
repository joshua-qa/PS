import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N, M;
    private long result;
    private int[] tree = new int[1000000];
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        st = new StringTokenizer(br.readLine());

        long max = 0;
        long min = 0;

        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > max) {
                max = tree[i];
            }
        }

        rec(min, (min+max) / 2, max);
        System.out.print(result);
    }

    private void rec(long min, long mid, long max) {
        if(min > max) {
            result = mid;
            return;
        }

        long curr = 0;

        for(int i = 0; i < tree.length; i++) {
            if(tree[i] >= mid) {
                curr += tree[i] - mid;
            }
        }

        if(curr < M) {
            rec(min, (min+mid-1)/2, mid-1);
        } else {
            rec(mid+1, (mid+max+1)/2, max);
        }
    }
}