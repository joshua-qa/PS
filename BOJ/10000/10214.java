import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int y, g;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 9; j++) {
                String[] str = br.readLine().split(" ");
                y += Integer.parseInt(str[0]);
                g += Integer.parseInt(str[1]);
            }
            if(y == g) {
                sb.append("Draw\n");
            } else {
                sb.append(y > g ? "Yonsei\n" : "Korea\n");
            }
            y = 0;
            g = 0;
        }

        System.out.print(sb);
    }
}