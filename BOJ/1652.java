import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] room = new char[n][n];

        for(int i = 0; i < n; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int count = 0;
        int wcount = 0;
        int curr = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(room[i][j] == '.') {
                    curr++;
                } else {
                    if(curr >= 2) {
                        count++;
                    }
                    curr = 0;
                }
            }
            if(curr >= 2) {
                count++;
            }
            curr = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(room[j][i] == '.') {
                    curr++;
                } else {
                    if(curr >= 2) {
                        wcount++;
                    }
                    curr = 0;
                }
            }
            if(curr >= 2) {
                wcount++;
            }
            curr = 0;
        }

        System.out.print(count + " " + wcount);
    }
}