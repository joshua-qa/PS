import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] P = new int[3];
    int[] temp = new int[6];
    int[] MAX = new int[3];
    int[] MIN = new int[3];
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        MAX[0] = Integer.parseInt(st.nextToken());
        MAX[1] = Integer.parseInt(st.nextToken());
        MAX[2] = Integer.parseInt(st.nextToken());

        MIN[0] = MAX[0];
        MIN[1] = MAX[1];
        MIN[2] = MAX[2];

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            P[0] = Integer.parseInt(st.nextToken());
            P[1] = Integer.parseInt(st.nextToken());
            P[2] = Integer.parseInt(st.nextToken());
            
            temp[0] = Math.max(MAX[0], MAX[1]) + P[0];
            temp[1] = Math.max(MAX[0], Math.max(MAX[1], MAX[2])) + P[1];
            temp[2] = Math.max(MAX[1], MAX[2]) + P[2];

            temp[3] = Math.min(MIN[0], MIN[1]) + P[0];
            temp[4] = Math.min(MIN[0], Math.min(MIN[1], MIN[2])) + P[1];
            temp[5] = Math.min(MIN[1], MIN[2]) + P[2];

            MAX[0] = temp[0];
            MAX[1] = temp[1];
            MAX[2] = temp[2];
            MIN[0] = temp[3];
            MIN[1] = temp[4];
            MIN[2] = temp[5];
        }

        System.out.println(Math.max(MAX[0], Math.max(MAX[1], MAX[2])) + " " + Math.min(MIN[0], Math.min(MIN[1], MIN[2])));
    }
}