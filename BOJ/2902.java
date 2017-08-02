import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split("-");
        for(String s : str) {
            sb.append(s.charAt(0));
        }

        System.out.print(sb);
    }
}