import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            System.out.println((int)Math.pow(2, p) - 1);
        }
    }
}