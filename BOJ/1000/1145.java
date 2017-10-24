import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[5];
        int count = 0, result = 100000000;

        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int a = 0; a < array.length; a++) {
            if(array[a] == 0) {
                continue;
            }
            for (int i = array[a]; i < 1000000; i += array[a]) {
                count = 0;
                for (int j = 0; j < 5; j++) {
                    if(array[j] == 0) {
                        continue;
                    }
                    if (i % array[j] == 0) {
                        count++;
                    }
                }
                if (count >= 3) {
                    result = Math.min(result, i);
                    break;
                }
            }
        }

        System.out.print(result);
    }
}