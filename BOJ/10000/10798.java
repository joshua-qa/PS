import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final int LINE_COUNT = 5;
    final int MAX_LENGTH = 15;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[][] ca = new char[5][15];

        for(int i = 0; i < LINE_COUNT; i++) {
            ca[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < MAX_LENGTH; i++) {
            for(int j = 0; j < LINE_COUNT; j++) {
                if(ca[j].length <= i) {
                    continue;
                }
                sb.append(ca[j][i]);
            }
        }

        System.out.print(sb.toString());
    }
}