import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int n, k, center;
    long ans;
    final int TREE_SIZE = 65536;
    int[] segtree = new int[131072];
    int[] nums;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        center = (k+1) / 2;

        nums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++) {
            update(1, TREE_SIZE, nums[i] + 1, 1, 1);
        }

        for(int i = k+1; i <= n; i++) {
            ans += query(1, TREE_SIZE, 1, center);
            update(1, TREE_SIZE, nums[i-k] + 1, 1, 2);
            update(1, TREE_SIZE, nums[i] + 1, 1, 1);
        }

        ans += query(1, TREE_SIZE, 1, center);

        System.out.print(ans);
    }

    private int query(int start, int end, int node, int value) {
        if(start == end) {
            return start-1;
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