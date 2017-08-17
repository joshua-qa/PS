import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;

        for(int i = 1; i <= 9; i++) {
            int a = Integer.parseInt(br.readLine());
            if(max < a) {
                max = a;
                index = i;
            }
        }

        System.out.println(max + "\n" + index);
    }
}