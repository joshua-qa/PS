import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private StringBuilder sb = new StringBuilder();
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] aArray = new int[N];
        int[] bArray = new int[M];
        int[] result = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
        }

        merge(aArray, bArray, result);

        for(int i : result) {
            sb.append(i + " ");
        }
        System.out.print(sb);
    }

    private void merge(int[] aArray, int[] bArray, int[] result) {
        int a = 0, b = 0, i = 0;

        while(i != result.length) {
            if(a < aArray.length && b < bArray.length) {
                if (aArray[a] <= bArray[b]) {
                    result[i++] = aArray[a++];
                } else {
                    result[i++] = bArray[b++];
                }
            } else {
                if(a == aArray.length) {
                    result[i++] = bArray[b++];
                } else {
                    result[i++] = aArray[a++];
                }
            }
        }
    }
}