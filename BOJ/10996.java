import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            sb.append("*");
        } else {
            for(int i = 0; i < n*2; i++) {
                for(int j = 0; j < n; j++) {
                    if((i + j) % 2 == 0) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}