import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        int resultX = 0;
        int resultY = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int inputX = Integer.parseInt(st.nextToken());
            if(!x.containsKey(inputX)) {
                x.put(inputX, 1);
            } else {
                x.put(inputX, 2);
            }
            int inputY = Integer.parseInt(st.nextToken());
            if(!y.containsKey(inputY)) {
                y.put(inputY, 1);
            } else {
                y.put(inputY, 2);
            }
        }

        for(int i : x.keySet()) {
            if(x.get(i) == 1) {
                resultX = i;
            }
        }
        for(int i : y.keySet()) {
            if(y.get(i) == 1) {
                resultY = i;
            }
        }

        System.out.print(resultX + " " + resultY);
    }
}