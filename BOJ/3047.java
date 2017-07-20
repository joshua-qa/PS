import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n);

        char[] m = br.readLine().toCharArray();

        for(int i = 0; i < 3; i++) {
            System.out.print(n[(m[i] - 'A')] + " ");
        }
    }
}