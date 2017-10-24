import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start, des, curr;
        int[] basket = new int[n];
        for(int i = 1; i <= n; i++) {
            basket[i-1] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            des = Integer.parseInt(st.nextToken()) - 1;
            curr = basket[start];
            basket[start] = basket[des];
            basket[des] = curr;
        }

        for(int i : basket) {
            System.out.print(i + " ");
        }
    }
}