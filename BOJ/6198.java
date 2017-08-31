import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final int MAX = 1000000009;
    int n, p;
    long ans;
    int[] C = new int[80001];
    int[] D = new int[80001];
    Stack<Integer> cows = new Stack<>();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        C[n] = MAX;

        for(int i = 0; i <= n; i++) {
            while(!cows.isEmpty() && C[i] >= C[cows.peek()]) {
                int curr = cows.pop();
                D[curr] = i - curr - 1;
            }
            cows.push(i);
        }

        for(int i : D) {
            ans += i;
        }

        System.out.print(ans);
    }
}