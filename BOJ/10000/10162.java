import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final int BUTTON_A = 300;
    final int BUTTON_B = 60;
    final int BUTTON_C = 10;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0, c = 0;
        if(n % 10 != 0) {
            System.out.print("-1");
        } else {
            while(n >= BUTTON_A) {
                n -= BUTTON_A;
                a++;
            }
            while(n >= BUTTON_B) {
                n -= BUTTON_B;
                b++;
            }
            while(n >= BUTTON_C) {
                n -= BUTTON_C;
                c++;
            }
            System.out.print(a + " " + b + " " + c);
        }
    }
}