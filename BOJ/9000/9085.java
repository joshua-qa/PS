import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int temp = 0;
            for(int j = 0; j < t; j++) {
                temp += Integer.parseInt(st.nextToken());
            }
            sb.append(temp + "\n");
        }

        System.out.print(sb);
    }
}