import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        m -= 45;
        if(m < 0) {
            m += 60;
            h--;
        }

        if(h < 0) {
            h = 23;
        }

        System.out.print(h + " " + m);
    }
}