import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            sb.append(jbox(p) + "\n");
        }
        System.out.print(sb);
    }

    private String jbox(int n) {
        String s = "";
        char[][] box = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == n-1) {
                    box[i][j] = '#';
                } else {
                    box[i][j] = 'J';
                }
            }
        }

        for(char[] c : box) {
            s += String.valueOf(c) + "\n";
        }

        return s;
    }
}