import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            int[] perm = new int[m+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                perm[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            boolean[] check = new boolean[m+1];
            for(int j = 1; j <= m; j++) {
                if (!check[j]) {
                    count++;
                    dfs(j, perm, check);
                }
            }
            sb.append(count + "\n");
        }

        System.out.print(sb);
    }

    private void dfs(int n, int[] perm, boolean[] check) {
        if(check[n]) {
            return;
        } else {
            check[n] = true;
            dfs(perm[n], perm, check);
        }
    }
}