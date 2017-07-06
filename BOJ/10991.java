import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            for(int k = i+1; k < n; k++) {
                sb.append(" ");
            }
            for(int j = 0; j <= i; j++) {
                sb.append("* ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}