import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue;
    int[] P;
    int[] G;
    int[] D;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            queue = new LinkedList<>();
            P = new int[n+1];
            D = new int[n+1];
            G = new int[n+1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                P[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                G[y]++;
            }

            for(int j = 1; j <= n; j++) {
                if(G[j] == 0) {
                    queue.add(j);
                    D[j] = P[j];
                }
            }

            for(int j = 1; j <= n; j++) {
                int x = queue.remove();

                for(int curr : graph.get(x)) {
                    G[curr]--;
                    if(D[curr] < D[x] + P[curr]) {
                        D[curr] = D[x] + P[curr];
                    }

                    if(G[curr] == 0) {
                        queue.add(curr);
                    }
                }
            }

            int w = Integer.parseInt(br.readLine());
            sb.append(D[w] + "\n");
        }
        System.out.print(sb);
    }
}