import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    StringTokenizer st;
    ArrayList<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = n; i >= 1; i--) {
            if(n % i == 0) {
                numList.add(n / i);
            }
        }

        if(numList.size() >= m) {
            System.out.print(numList.get(m-1));
        } else {
            System.out.print(0);
        }
    }
}