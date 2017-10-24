import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private Queue<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        int count = 0;
        while(!list.isEmpty()) {
            count++;
            if(count % m == 0) {
                sb.append(list.remove() + ", ");
            } else {
                int temp = list.remove();
                list.add(temp);
            }
        }
        sb.replace(sb.length()-2, sb.length(), ">");

        System.out.println(sb);
    }
}