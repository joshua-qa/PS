import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            ArrayList<Player> playerList = new ArrayList<>();
            for(int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                playerList.add(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
            }
            Player pp = Collections.max(playerList, Comparator.comparingInt(value -> value.cost));
            sb.append(pp.name + "\n");
        }

        System.out.print(sb);
    }
}

class Player {
    int cost;
    String name;
    public Player(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }
}