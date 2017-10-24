import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int[][] D = new int[A.length+1][B.length+1];
        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                } else {
                    D[i][j] = D[i][j-1] > D[i-1][j] ? D[i][j-1] : D[i-1][j];
                }
            }
        }

        System.out.print(D[A.length][B.length]);
    }
}