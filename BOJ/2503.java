import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, count;
    char[][] input;
    int[] s, b;
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new char[n][3];
        s = new int[n];
        b = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = st.nextToken().toCharArray();
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        check();

        System.out.print(count);
    }

    private void check() {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(i == j) {
                    continue;
                }
                for(int k = 1; k <= 9; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    int currCount = 0;
                    for(int l = 0; l < n; l++) {
                        int b1 = input[l][0] - '0';
                        int b2 = input[l][1] - '0';
                        int b3 = input[l][2] - '0';
                        int currS = 0, currB = 0;

                        if (b1 == i) {
                            currS++;
                        } else if (b1 == j || b1 == k) {
                            currB++;
                        }
                        if (b2 == j) {
                            currS++;
                        } else if (b2 == i || b2 == k) {
                            currB++;
                        }
                        if (b3 == k) {
                            currS++;
                        } else if (b3 == i || b3 == j) {
                            currB++;
                        }

                        if(currS == s[l] && currB == b[l]) {
                            currCount++;
                        }
                    }
                    if(currCount == n) {
                        count++;
                    }
                }
            }
        }
    }
}