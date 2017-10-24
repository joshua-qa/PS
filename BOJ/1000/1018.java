import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m;
    char[][] map;
    StringTokenizer st;
    char[] W = {87, 66, 87, 66, 87, 66, 87, 66};
    char[] B = {66, 87, 66, 87, 66, 87, 66, 87};
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int count = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n-7; i++) {
            for(int j = 0; j < m-7; j++) {
                int checkCount = check(i, j);
                if(count > checkCount) {
                    count = checkCount;
                }
            }
        }

        System.out.print(count);
    }

    private int check(int x, int y) {
        int wStartCount = 0;
        int bStartCount = 0;

        for(int i = x; i < x+8; i++) {
            if((i-x) % 2 == 0) {
                for (int j = y; j < y + 8; j++) {
                    if(W[j-y] != map[i][j]) {
                        wStartCount++;
                    }
                }
            } else {
                for (int j = y; j < y + 8; j++) {
                    if(B[j-y] != map[i][j]) {
                        wStartCount++;
                    }
                }
            }
        }

        for(int i = x; i < x+8; i++) {
            if((i-x) % 2 == 0) {
                for (int j = y; j < y + 8; j++) {
                    if(B[j-y] != map[i][j]) {
                        bStartCount++;
                    }
                }
            } else {
                for (int j = y; j < y + 8; j++) {
                    if(W[j-y] != map[i][j]) {
                        bStartCount++;
                    }
                }
            }
        }

        return Math.min(wStartCount, bStartCount);
    }
}