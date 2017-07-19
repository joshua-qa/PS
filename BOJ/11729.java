import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rec(n, 1, 3);
        int count = (int)Math.pow(2, n);
        System.out.println(count - 1);
        System.out.print(sb);
    }

    private void rec(int n, int start, int target) {
        if(n == 0) {
            return;
        }
        rec(n-1, start, 6 - start - target);
        sb.append(start + " " + target + "\n");
        rec(n-1, 6 - start - target, target);
    }
}