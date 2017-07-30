import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i % 2 == 1) {
                    sb.append("* ");
                } else {
                    sb.append(" *");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}