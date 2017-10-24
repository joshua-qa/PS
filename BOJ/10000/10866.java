import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public Node head = new Node();
    public int size;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input; i++) {
            String str = br.readLine();
            if(str.indexOf("push_front") != -1) {
                int data = Integer.parseInt(str.split(" ")[1]);
                push_front(data);
            } else if(str.indexOf("push_back") != -1) {
                int data = Integer.parseInt(str.split(" ")[1]);
                push_back(data);
            } if(str.equals("pop_front")) {
                sb.append(pop_front() + "\n");
            } else if(str.equals("pop_back")) {
                sb.append(pop_back() + "\n");
            } else if(str.equals("size")) {
                sb.append(size() + "\n");
            } else if(str.equals("empty")) {
                sb.append((empty() ? 1 : 0) + "\n");
            } else if(str.equals("front")) {
                sb.append(front() + "\n");
            } else if(str.equals("back")) {
                sb.append(back() + "\n");
            }
        }

        System.out.println(sb);
    }

    private void push_front(int n) {
        Node frontNode = new Node();
        frontNode.data = n;
        frontNode.next = head.next;
        frontNode.prev = head;
        if(size() > 0) {
            frontNode.next.prev = frontNode;
        }
        head.next = frontNode;
        size++;
        if(size() == 1) {
            head.prev = frontNode;
        }
    }

    private void push_back(int n) {
        Node backNode = new Node();
        backNode.data = n;
        backNode.next = head;
        backNode.prev = head.prev;
        if(size() > 0) {
            backNode.prev.next = backNode;
        }
        head.prev = backNode;
        size++;
        if(size() == 1) {
            head.next = backNode;
        }
    }

    private int pop_front() {
        if(size == 0) {
            return -1;
        }

        Node frontNode = head.next;
        size--;
        if(size() == 0) {
            head.next = null;
            head.prev = null;
        } else {
            head.next = frontNode.next;
            frontNode.next.prev = head;
        }
        return frontNode.data;
    }

    private int pop_back() {
        if(size == 0) {
            return -1;
        }

        Node backNode = head.prev;
        size--;
        if(size() == 0) {
            head.next = null;
            head.prev = null;
        } else {
            head.prev = backNode.prev;
            backNode.prev.next = head;
        }
        return backNode.data;
    }

    private int size() {
        return size;
    }

    private boolean empty() {
        return size() == 0;
    }

    private int front() {
        return !empty() ? head.next.data : -1;
    }

    private int back() {
        return !empty() ? head.prev.data : -1;
    }

}

class Node {
    int data;
    Node prev;
    Node next;

    public Node() {

    }
}