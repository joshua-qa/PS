import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private int[] numList;
    private final int QUERY_ONE = 1;
    private final int QUERY_TWO = 2;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);
        numList = new int[n+1];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int queryNum = Integer.parseInt(st.nextToken());
            if(QUERY_TWO == queryNum) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                sb.append(queryTwo(a,b,c,d) + "\n");
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(queryOne(a,b) + "\n");
            }
        }
        System.out.print(sb);
    }

    private int queryOne(int a, int b) {
        int result = 0;
        for(int i = a; i <= b; i++) {
            result += numList[i];
        }

        int temp = numList[a];
        numList[a] = numList[b];
        numList[b] = temp;
        return result;
    }

    private int queryTwo(int a, int b, int c, int d) {
        int result = 0;
        for(int i = a; i <= b; i++) {
            result += numList[i];
        }

        for(int i = c; i <= d; i++) {
            result -= numList[i];
        }

        return result;
    }
}