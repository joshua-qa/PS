import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    int n, m;
    ArrayList<Integer> triangle = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1, j = 2; i < 1100; i += j, j++) {
            triangle.add(i);
        }

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append((get(input) ? 1 : 0) + "\n");
        }

        System.out.print(sb);
    }

    private boolean get(int n) {
        int max = 0;
        for(int i = 0; i < triangle.size(); i++) {
            if(triangle.get(i) >= n) {
                max = i;
                break;
            }
        }

        for(int i = 0; i <= max; i++) {
            for(int j = 0; j <= max; j++) {
                for(int k = 0; k <= max; k++) {
                    if(triangle.get(i) + triangle.get(j) + triangle.get(k) == n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}