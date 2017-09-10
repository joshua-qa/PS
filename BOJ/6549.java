import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, height;
    long ans;
    int[] segtree, H;
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            height = (int)(Math.log(n) / Math.log(2));
            height = 2 << (height+1);

            segtree = new int[height];

            if(n == 0) {
                break;
            } else {
                H = new int[n];
                for(int j = 0; j < H.length; j++) {
                    H[j] = Integer.parseInt(st.nextToken());
                }
            }

            init(0, H.length-1, 1);
            getBiggest(0, H.length-1);
            sb.append(ans + "\n");
            ans = 0;
        }

        System.out.print(sb);
    }

    private void getBiggest(int start, int end) {
        if(start > end) {
            return;
        } else if(start == end) {
            ans = Math.max(ans, H[start]);
            return;
        }

        int currMinPos = query(0, H.length-1, 1, start, end);
        long currMinHeight = H[currMinPos];
        long currMaxStick = (end - start + 1) * currMinHeight;
        ans = Math.max(ans, currMaxStick);

        getBiggest(start, currMinPos-1);
        getBiggest(currMinPos+1, end);
    }

    private int init(int start, int end, int node) {
        if(start == end) {
            return segtree[node] = start;
        }

        int m1 = init(start, (start+end)/2, node*2);
        int m2 = init((start+end)/2+1, end, node*2+1);
        if(H[m1] >= H[m2]) {
            return segtree[node] = m2;
        } else {
            return segtree[node] = m1;
        }
    }

    private int query(int start, int end, int node, int i, int j) {
        if(end < i || start > j) {
            return -1;
        } else if(i <= start && end <= j) {
            return segtree[node];
        }

        int m1 = query(start, (start+end)/2, node*2, i, j);
        int m2 = query((start+end)/2+1, end, node*2+1, i, j);

        if(m1 == -1) {
            return m2;
        } else if(m2 == -1) {
            return m1;
        } else {
            return H[m1] > H[m2] ? m2 : m1;
        }
    }
}