import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] parkingTime = new int[101];
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int oneCar = Integer.parseInt(st.nextToken());
        int twoCar = Integer.parseInt(st.nextToken());
        int threeCar = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start; j < end; j++) {
                parkingTime[j]++;
            }
        }

        for(int i : parkingTime) {
            if(i == 1) {
                result += oneCar;
            } else if(i == 2) {
                result += twoCar*2;
            } else if(i == 3) {
                result += threeCar*3;
            }
        }
        System.out.print(result);
    }
}