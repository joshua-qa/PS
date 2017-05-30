import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jgchoi.qa on 2017. 5. 30..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[][] numArray = new int[N][N];
        int count = 0;
        int x = N, y = N-1;
        int flag = -1, depth = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                numArray[i][j] = ++count;
            }
        }

        for(int k = 0; k < N; k++) {
            count--;
            sb.append(numArray[--x][y]);
            if(count > 0) {
                sb.append(", ");
            }
        }

        while(count > 0) {
            if (flag == -1 && y > depth) {
                sb.append(numArray[x][--y]);
            } else if (flag == -1 && x < N-depth-1) {
                sb.append(numArray[++x][y]);
            } else if (flag == 1 && y < N-depth-1) {
                sb.append(numArray[x][++y]);
            } else if (flag == 1 && x > depth) {
                sb.append(numArray[--x][y]);
            }

            if (count > 1) {
                sb.append(", ");
            }

            count--;

            if(y == depth && x == N-depth-1) {
                flag *= -1;
                depth++;
            } else if(y == N-depth-1 && x == depth) {
                flag *= -1;
            }
        }

        System.out.print(sb.toString());
    }
}