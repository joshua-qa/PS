import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int count = 0;
        boolean[] check = new boolean[n+1];
        ArrayList<Integer> delete = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(!check[i]) {
                check[i] = true;
                count++;
                delete.add(i);
            }
            for(int j = i*2; j <= n; j += i) {
                if(!check[j]) {
                    check[j] = true;
                    count++;
                    delete.add(j);
                }
            }
        }
        System.out.print(delete.get(k-1));
    }
}