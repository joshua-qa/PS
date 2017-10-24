import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, ans = 100;
    int[][] paper = new int[101][101];
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(paper[i][j] == 1) {
                    paper[i][j] += paper[i-1][j];
                }
            }
        }
        
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(paper[i][j] == 0) {
                    continue;
                } else {
                    int currCount = 1;
                    int currMin = paper[i][j];
                    for(int k = j+1; k <= 100; k++) {
                        if(paper[i][k] == 0) {
                            break;
                        }
                        if(currMin > paper[i][k]) {
                            currCount++;
                            currMin = paper[i][k];
                            if (ans < currMin * currCount) {
                                ans = currMin * currCount;
                            }
                        } else {
                            currCount++;
                            if (ans < currMin * currCount) {
                                ans = currMin * currCount;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}