import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final int[] pieces = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < pieces.length; i++) {
            int piece = Integer.parseInt(st.nextToken());
            sb.append(pieces[i] - piece + " ");
        }
        System.out.print(sb);
    }
}