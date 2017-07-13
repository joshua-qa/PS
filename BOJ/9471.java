import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int p = Integer.parseInt(br.readLine());

        for(int i = 0; i < p; i++) {
            String str[] = br.readLine().split(" ");
            sb.append(str[0] + " " + fibo(Integer.parseInt(str[1])) + "\n");
        }
        System.out.print(sb.toString());
    }

    private int fibo(int n) {
        long a = 1;
        long b = 0;
        long fibo = 0;
        int i = 0;

        while(true) {
            i++;
            if(i > 3 && a % n == 1 && b % n == 1) {
                return i-3;
            }
            fibo = (a % n) + (b % n);
            a = b;
            b = fibo;
        }
    }
}