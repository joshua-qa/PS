import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, a, b, h;
    int[] segtree;
    int[] nums;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        h = (int)(Math.log(n) / Math.log(2));
        h = 2 << (h+1);

        segtree = new int[h];
        nums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        init(1, nums.length-1, 1);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(query(1, nums.length-1, 1, a, b) + "\n");
        }

        System.out.print(sb);
    }

    private int init(int start, int end, int node) {
        if(start == end) {
            return segtree[node] = nums[start];
        }

        return segtree[node] = Math.min(init(start, (start+end)/2, node*2), init((start+end)/2+1, end, node*2+1));
    }

    private int query(int start, int end, int node, int i, int j) {
        if(end < i || start > j) {
            return Integer.MAX_VALUE;
        } else if(i <= start && end <= j) {
            return segtree[node];
        }

        return Math.min(query(start, (start+end)/2, node*2, i, j), query((start+end)/2+1, end, node*2+1, i, j));
    }
}