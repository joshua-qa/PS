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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] hotelAmount = new int[h];
        int[][] week = new int[h][w];

        for(int i = 0; i < h; i++) {
            hotelAmount[i] = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < w; j++) {
                week[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(n, b, hotelAmount, week);
        if(result == -1) {
            System.out.println("stay home");
        } else {
            System.out.println(result);
        }
    }

    private int solution(int n, int b, int[] hotelAmount, int[][] week) {
        int min = 500001;

        for(int i = 0; i < hotelAmount.length; i++) {
            for(int j = 0; j < week[i].length; j++) {
                if(week[i][j] < n) {
                    continue;
                }
                if(week[i][j] >= n && ( hotelAmount[i] * week[i][j] <= b )) {
                    min = Math.min(min, hotelAmount[i] * n);
                }
            }
        }

        if(min == 500001) {
            return -1;
        } else {
            return min;
        }
    }
}