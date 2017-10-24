import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] A = new int[10];
    private static int[] B = new int[10];
    private static int[] judge = new int[10];
    private static int aScore, bScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] > B[i]) {
                judge[i] = 1;
                aScore += 3;
            } else if(A[i] < B[i]) {
                judge[i] = 2;
                bScore += 3;
            } else {
                judge[i] = 0;
                aScore += 1;
                bScore += 1;
            }
        }

        if(aScore > bScore) {
            System.out.println("A");
        } else if(aScore < bScore) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }
    }
}