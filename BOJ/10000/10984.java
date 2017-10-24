import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, c, total;
        double g, score;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            c = 0;
            g = 0;
            score = 0;
            total = 0;
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                g = Double.parseDouble(st.nextToken());
                total += c;
                score += (double)c * g;
            }
            sb.append(total + " " + String.format("%.1f", score / total) + "\n");
        }

        System.out.print(sb.toString());
    }
}