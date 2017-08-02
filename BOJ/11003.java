import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    int[] numList;
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        numList = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }

        deque.add(0);
        sb.append(numList[0] + " ");
        for(int i = 1; i < n; i++) {
            if(!deque.isEmpty() && numList[deque.peekLast()] >= numList[i]) {
                while(!deque.isEmpty() && numList[deque.peekLast()] >= numList[i]) {
                    deque.pollLast();
                }
            }

            deque.addLast(i);
            sb.append(numList[deque.peekFirst()] + " ");
            if(deque.peekFirst() <= i-m+1) {
                deque.pollFirst();
            }
        }

        System.out.print(sb);
    }
}