import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            StringBuilder sbTemp = new StringBuilder(br.readLine());
            String[] str = sbTemp.reverse().toString().split(" ");
            for(int j = str.length-1; j >= 0; j--) {
                sb.append(str[j] + " ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}