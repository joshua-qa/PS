package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int pushNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            s = br.readLine();
            if(s.contains("push")) {
                pushNum = Integer.parseInt(s.substring(5, s.length()));
                queue.offer(pushNum);
            } else if(s.equals("pop")) {
                if(queue.peek() == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else if(s.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if(s.equals("empty")) {
                if(queue.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if(s.equals("front")) {
                if(queue.peek() == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek() + "\n");
                }
            } else if(s.equals("back")) {
                if(queue.peek() == null) {
                    sb.append("-1\n");
                } else {
                    Iterator<Integer> it = queue.iterator();
                    int temp = 0;
                    while(it.hasNext()) {
                        temp = it.next();
                    }
                    sb.append(temp + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}