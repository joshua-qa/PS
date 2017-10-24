import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int[] student = new int[1000000];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        String[] str = br.readLine().trim().split(" ");
        int b = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        long result = 0;

        for(int i = 0; i < n; i++) {
            student[i] -= b;
            result++;
            if(student[i] > 0) {
                result += student[i] / c;
                if(student[i] % c != 0) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}