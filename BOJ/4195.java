import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, m, first, second;
    int[] union;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int a = 0; a < n; a++) {
            Map<String, Integer> userList = new HashMap<>();
            int userCount = 0;
            m = Integer.parseInt(br.readLine());

            union = new int[m * 2 + 1];

            for (int i = 0; i < m; i++) {
                String[] str = br.readLine().split(" ");
                if(!userList.containsKey(str[0])) {
                    userCount++;
                    union[userCount] = userCount;
                    userList.put(str[0], userCount);
                    first = userCount;
                } else {
                    first = userList.get(str[0]);
                }
                if(!userList.containsKey(str[1])) {
                    userCount++;
                    union[userCount] = userCount;
                    userList.put(str[1], userCount);
                    second = userCount;
                } else {
                    second = userList.get(str[1]);
                }
                union(first, second);
                sb.append(getNetwork(union[first], userCount) + "\n");
            }
        }
        System.out.print(sb);
    }

    private int getNetwork(int u, int userCount) {
        int result = 0;
        for(int i = 1; i <= userCount; i++) {
            if(union[i] == u) {
                result++;
            } else {
                if(find(i) == u) {
                    result++;
                }
            }
        }
        return result;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return;
        }
        union[y] = x;
    }

    private int find(int n) {
        if(union[n] == n) {
            return n;
        } else {
            return union[n] = find(union[n]);
        }
    }
}