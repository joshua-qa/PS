import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] list = new int[1001];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int curr = 0;
        int i = 1;
        int result = 0;

        while(curr <= b) {
            for(int j = 1; j <= i; j++) {
                if(curr > b) {
                    break;
                }
                list[curr] = i;
                curr++;
            }
            i++;
        }

        for(int n = a-1; n < b; n++) {
            result += list[n];
        }

        System.out.print(result);
    }
}