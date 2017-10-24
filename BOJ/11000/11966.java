import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> powList = new ArrayList<>();
        int j = 1;
        for(int i = 0; i < 31; i++) {
            powList.add(j);
            j *= 2;
        }
        int n = Integer.parseInt(br.readLine());

        if(powList.contains(n)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}