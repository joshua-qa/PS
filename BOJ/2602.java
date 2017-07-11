import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[][] D = new int[21][101];
    int[][] A = new int[21][101];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] target = br.readLine().toCharArray();
        char[] devil = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();
        int range = devil.length - target.length + 1;

        for(int i = 1; i <= range; i++) {
            if(target[0] == devil[i-1]) {
                D[1][i] = D[1][i-1] + 1;
            } else {
                D[1][i] = D[1][i-1];
            }

            if(target[0] == angel[i-1]) {
                A[1][i] = A[1][i-1] + 1;
            } else {
                A[1][i] = A[1][i-1];
            }
        }

        for(int i = 2; i <= target.length; i++) {
            range = devil.length - target.length + i;
            for(int j = i; j <= range; j++) {
                if(i % 2 == 1) {
                    if (devil[j - 1] != target[i - 1]) {
                        D[i][j] = D[i][j - 1];
                    } else {
                        D[i][j] = D[i][j - 1] + D[i - 1][j - 1];
                    }
                } else {
                    if (angel[j - 1] != target[i - 1]) {
                        D[i][j] = D[i][j - 1];
                    } else {
                        D[i][j] = D[i][j - 1] + D[i - 1][j - 1];
                    }
                }
            }
        }

        for(int i = 2; i <= target.length; i++) {
            range = angel.length - target.length + i;
            for(int j = i; j <= range; j++) {
                if(i % 2 == 1) {
                    if (angel[j - 1] != target[i - 1]) {
                        A[i][j] = A[i][j - 1];
                    } else {
                        A[i][j] = A[i][j - 1] + A[i - 1][j - 1];
                    }
                } else {
                    if (devil[j - 1] != target[i - 1]) {
                        A[i][j] = A[i][j - 1];
                    } else {
                        A[i][j] = A[i][j - 1] + A[i - 1][j - 1];
                    }
                }
            }
        }

        System.out.println(D[target.length][devil.length] + A[target.length][angel.length]);
    }
}