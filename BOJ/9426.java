import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int n, k, curr, h, center;
    long ans;
    final int TREE_SIZE = 65536;
    int[] segtree;
    int[] nums;
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        center = (k+1) / 2;

        h = (int)Math.ceil(Math.log(TREE_SIZE) / Math.log(2));
        h = 1 << (h+1);

        segtree = new int[h];
        nums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++) {
            update(1, TREE_SIZE, nums[i] + 1, 1, 1);
        }

        for(int i = k+1; i <= n; i++) {
            curr = query(1, TREE_SIZE, 1, center);
            ans += curr;
            update(1, TREE_SIZE, nums[i-k] + 1, 1, 2);
            update(1, TREE_SIZE, nums[i] + 1, 1, 1);
        }

        curr = query(1, TREE_SIZE, 1, center);
        ans += curr;

        bw.write(ans + "\n");
        bw.close();
    }

    private int query(int start, int end, int node, int value) {
        if(node*2+1 > segtree.length) {
            return node - TREE_SIZE;
        }
        
        return segtree[node*2] >= value ? query(start, (start+end)/2, node*2, value) : query((start+end)/2+1, end, node*2+1, value - segtree[node*2]);
    }

    private int update(int start, int end, int index, int node, int command) {
        if(index < start || index > end) {
            return segtree[node];
        }
        if(start == end && command == 1) {
            return ++segtree[node];
        } else if(start == end && command == 2) {
            return --segtree[node];
        }

        return segtree[node] = update(start, (start + end) / 2, index, node * 2, command) + update((start + end) / 2 + 1, end, index, node * 2 + 1, command);

    }
}