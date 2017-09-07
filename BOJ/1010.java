import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int x, y;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(solution(x, y)+"\n");
        }

        System.out.print(sb.toString());
    }

    private static int solution(int x, int y) {
        if(x == 1) {
            return x*y;
        }

        long result = 1;
        int modN = x;
        int modA = 1;
        for(int i = y-x+1; i <= y; i++) {
            result *= i;
            if(result % modA == 0 && modA <= modN) {
                result /= modA;
                modA++;
            }
        }

        return (int)result;
    }
}