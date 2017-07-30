import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private Stack<Integer> stack = new Stack<>();
    private int[] basket;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] str = br.readLine().trim().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        basket = new int[n];
        for(int i = 1; i <= n; i++) {
            basket[i-1] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            change(x, y);
        }

        for(int i : basket) {
            sb.append(i + " ");
        }
        System.out.print(sb);
    }

    private void change(int x, int y) {
        for(int i = x; i <= y; i++) {
            stack.push(basket[i-1]);
        }
        for(int i = x; i <= y; i++) {
            basket[i-1] = stack.pop();
        }
    }
}