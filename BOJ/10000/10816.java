import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int[] in = new int[20000001];
    private final int P = 10000000;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            in[Integer.parseInt(st.nextToken()) + P]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            sb.append(in[Integer.parseInt(st.nextToken()) + P] + " ");
        }

        System.out.print(sb);
    }
}