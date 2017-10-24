import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        ArrayList<Order> postit = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if(q.equals("order")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                postit.add(new Order(a,b));
                printPostit(postit);
            } else if(q.equals("sort")) {
                Collections.sort(postit, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        if(o1.time == o2.time) {
                            return o1.table - o2.table;
                        } else {
                            return o1.time - o2.time;
                        }
                    }
                });
                printPostit(postit);
            } else if(q.equals("complete")) {
                int t = Integer.parseInt(st.nextToken());
                for(Order o : postit) {
                    if(o.table == t) {
                        postit.remove(o);
                        break;
                    }
                }
                printPostit(postit);
            }
        }

        System.out.print(sb);
    }

    private void printPostit(ArrayList<Order> postit) {
        if(postit.isEmpty()) {
            sb.append("sleep");
        } else {
            for (Order o : postit) {
                sb.append(o.table + " ");
            }
        }
        sb.append("\n");
    }
}

class Order {
    int table;
    int time;
    public Order(int table, int time) {
        this.table = table;
        this.time = time;
    }
}