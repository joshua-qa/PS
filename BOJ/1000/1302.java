import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    HashMap<String, Integer> sell = new HashMap<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(!sell.containsKey(s)) {
                sell.put(s, 1);
            } else {
                sell.put(s, sell.get(s)+1);
            }
        }

        int max = 0;
        String ans = "";

        for(String s : sell.keySet()) {
            if(sell.get(s) > max) {
                max = sell.get(s);
                ans = s;
            } else if (sell.get(s) == max) {
                if(s.compareTo(ans) < 0) {
                    ans = s;
                }
            }
        }

        System.out.print(ans);
    }
}