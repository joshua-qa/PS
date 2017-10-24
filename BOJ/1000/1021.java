import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> popNum = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            popNum.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(queue(n, m, popNum));
    }

    private static int queue(int n, int m, ArrayList<Integer> popNum) {
        int result = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while(!popNum.isEmpty()) {

            if (deque.getFirst() == popNum.get(0)) {
                while(!popNum.isEmpty() && deque.getFirst() == popNum.get(0)) {
                    deque.removeFirst();
                    popNum.remove(0);
                }
            }

            if(popNum.isEmpty()) {
                break;
            }

            int posFirst = index(deque, popNum.get(0));

            if(posFirst > deque.size() / 2) {
                int temp = deque.removeLast();
                deque.addFirst(temp);
                result++;
            } else {
                int temp = deque.removeFirst();
                deque.addLast(temp);
                result++;
            }
        }

        return result;
    }

    private static int index(ArrayDeque<Integer> ad, int num) {
        Iterator<Integer> it = ad.iterator();
        int i = 0;
        while(it.hasNext()) {
            int curr = it.next();
            if(curr == num) {
                return i;
            } else {
                i++;
            }
        }

        return -1;
    }
}