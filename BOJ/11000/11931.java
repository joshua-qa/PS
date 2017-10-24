import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> numList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numList, Comparator.reverseOrder());

        for(int i : numList) {
            sb.append(i + "\n");
        }

        System.out.print(sb);
    }
}