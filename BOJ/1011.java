import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int x, y;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(solution(y - x) + "\n");
        }
        System.out.print(sb.toString());
    }

    private static int solution(int n) {
        long temp = 0;
        int depth = 0;
        for(int i = 1; i <= 50000; i++) {
            if(temp + i*2 >= n) {
                depth = i;
                break;
            }
            temp += i*2;
        }

        int lineStart = (int)temp;
        int pos = n - lineStart;
        if(pos > depth) {
            return depth * 2;
        } else {
            return depth * 2 - 1;
        }
    }
}