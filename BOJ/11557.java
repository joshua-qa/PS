import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private String maxSchool;
    private int maxDrink;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            for(int j = 0; j < x; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int d = Integer.parseInt(st.nextToken());
                if(d > maxDrink) {
                    maxDrink = d;
                    maxSchool = s;
                }
            }
            sb.append(maxSchool + "\n");
            maxDrink = 0;
        }
        System.out.print(sb);
    }
}