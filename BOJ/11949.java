import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    int n, m;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[] studentNumber = new int[n+1];
        int[] card = new int[m+1];
        for(int i = 1; i <= n; i++) {
            studentNumber[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= m; i++) {
            card[i] = 1;
            for(int j = 2; j <= n; j++) {
                card[i] = j;
                if(studentNumber[j-1] % i > studentNumber[j] % i) {
                    int temp = studentNumber[j-1];
                    studentNumber[j-1] = studentNumber[j];
                    studentNumber[j] = temp;
                }
            }
        }

        for(int i : studentNumber) {
            if(i != 0) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}