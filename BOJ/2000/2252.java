import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n, m, x, y;
    int[] inDegree = new int[32001];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    Queue<Integer> visit = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            inDegree[y]++;
        }

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                visit.add(i);
            }
        }

        while(!visit.isEmpty()) {
            int curr = visit.remove();
            sb.append(curr + " ");

            for(int i : graph.get(curr)) {
                inDegree[i]--;

                if(inDegree[i] == 0) {
                    visit.add(i);
                }
            }
        }

        System.out.print(sb);
    }
}