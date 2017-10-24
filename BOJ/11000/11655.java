import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] ca = br.readLine().toCharArray();

        for(int i = 0; i < ca.length; i++) {
            if(ca[i] - 'A' >= 0 && ca[i] - 'A' < 26) {
                ca[i] += 13;
                if(ca[i] - 'A' > 25) {
                    ca[i] -= 26;
                }
            } else if(ca[i] - 'a' >= 0 && ca[i] - 'a' < 26) {
                ca[i] += 13;
                if(ca[i] - 'a' > 25) {
                    ca[i] -= 26;
                }
            } else {
                continue;
            }
        }

        System.out.println(ca);
    }
}