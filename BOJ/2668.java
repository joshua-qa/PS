import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    int n;
    int[] numList;
    boolean[] availableList;
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> visit = new Stack<>();
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numList = new int[n+1];
        availableList = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            numList[i] = Integer.parseInt(br.readLine());
            availableList[numList[i]] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(availableList[i]) {
                visit.add(i);
                dfs(numList[i], i);
            }
        }

        Collections.sort(result);
        sb.append(result.size() + "\n");
        for(int i : result) {
            sb.append(i + "\n");
        }

        System.out.print(sb);
    }

    private void dfs(int target, int start) {
        if(visit.contains(target)) {
            if(start == target) {
                while (!visit.isEmpty()) {
                    availableList[visit.peek()] = false;
                    result.add(visit.pop());
                }
            } else {
                while (!visit.isEmpty()) {
                    visit.pop();
                }
            }
            return;
        }

        visit.push(target);

        dfs(numList[target], start);
    }
}