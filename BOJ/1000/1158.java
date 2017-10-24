import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int t = 1;

        while(!queue.isEmpty()) {
            int q = queue.remove();
            if(t % m != 0) {
                queue.add(q);
            } else {
                if(queue.isEmpty()) {
                    sb.append(q + ">");
                } else {
                    sb.append(q + ", ");
                }
            }
            t++;
        }

        System.out.print(sb.toString());
    }
}