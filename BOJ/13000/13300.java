import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Joshua on 2017-06-14.
 */
public class Main {
    static int s, y, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] student = new int[2][6];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            student[s][y-1]++;
        }

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                if(student[j][i] == 0) {
                    continue;
                } else if(student[j][i] % k != 0) {
                    result += (student[j][i] / k) + 1;
                } else {
                    result += student[j][i] / k;
                }
            }
        }

        System.out.print(result);
    }
}