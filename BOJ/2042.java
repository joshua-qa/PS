import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int n, m, k, a, b, c, h;
    long[] segtree;
    long[] nums;
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        h = (int)Math.ceil(Math.log(n) / Math.log(2));
        h = 1 << (h+1);

        segtree = new long[h];
        nums = new long[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        init(1, nums.length-1, 1);

        for(int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 1) {
                update(1, nums.length - 1, b, c, 1);
            } else {
                bw.write(query(1, nums.length - 1, 1, b, c) + "\n");
            }
        }

        bw.close();
    }

    private long init(int start, int end, int node) {
        if(start == end) {
            return segtree[node] = nums[start];
        }

        return segtree[node] = init(start, (start+end)/2, node*2) + init((start+end)/2+1, end, node*2+1);
    }

    private long query(int start, int end, int node, int i, int j) {
        if(end < i || start > j) {
            return 0;
        } else if(i <= start && end <= j) {
            return segtree[node];
        }

        return query(start, (start+end)/2, node*2, i, j) + query((start+end)/2+1, end, node*2+1, i, j);
    }

    private long update(int start, int end, int index, int value, int node) {
        if(index < start || index > end) {
            return segtree[node];
        }
        if(start == end) {
            return segtree[node] = value;
        }

        return segtree[node] = update(start, (start + end) / 2, index, value, node * 2) + update((start + end) / 2 + 1, end, index, value, node * 2 + 1);

    }
}