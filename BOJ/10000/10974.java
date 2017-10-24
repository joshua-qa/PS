import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int a, b;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());
        for(int i = 1; i <= a; i++) {
            boolean[] check = new boolean[a+1];
            check[i] = true;
            rec(a, a, check, String.valueOf(i));
        }
        System.out.print(sb);
    }

    private void rec(int a, int curr, boolean[] check, String s) {
        if(curr == 1) {
            sb.append(s.trim()+"\n");
            return;
        }

        for(int i = 1; i <= a; i++) {
            if(check[i]) {
                continue;
            } else {
                check[i] = true;
                rec(a, curr-1, check, s + " " + String.valueOf(i));
                check[i] = false;
            }
        }
    }
}