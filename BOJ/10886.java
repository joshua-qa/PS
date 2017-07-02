import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zero = 0, one = 0, temp = 0;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            if(temp == 1) {
                one++;
            } else {
                zero++;
            }
        }

        System.out.println((one > zero) ? "Junhee is cute!" : "Junhee is not cute!");
    }
}