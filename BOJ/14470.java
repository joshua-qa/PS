import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    boolean freeze;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int cTime = Integer.parseInt(br.readLine());
        int dTime = Integer.parseInt(br.readLine());
        int eTime = Integer.parseInt(br.readLine());
        int result = 0;
        int curr = start;
        if(start <= 0) {
            freeze = true;
        }

        while(curr < end) {
            if(curr < 0 && freeze) {
                result += cTime;
                curr++;
            } else if(curr == 0 && freeze) {
                result += dTime;
                freeze = false;
            } else if(curr >= 0 && !freeze) {
                result += eTime;
                curr++;
            }
        }

        System.out.print(result);
    }
}