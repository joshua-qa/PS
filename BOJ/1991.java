package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Node[] node = new Node[n];

        for(int i = 0; i < n; i++) {
            node[i] = new Node(String.valueOf((char)(65+i)));
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int curr = st.nextToken().charAt(0) - 65;
            int l = st.nextToken().charAt(0) - 65;
            int r = st.nextToken().charAt(0) - 65;
            if(l >= 0) {
                node[curr].setLeft(node[l]);
            }
            if(r >= 0) {
                node[curr].setRight(node[r]);
            }
        }

        preorder(node[0]);
        System.out.println("");
        inorder(node[0]);
        System.out.println("");
        postorder(node[0]);
    }

    public void preorder(Node n) {
        if(n == null) {
            return;
        }
        System.out.print(n.getData());
        preorder(n.getLeft());
        preorder(n.getRight());
    }

    public void inorder(Node n) {
        if(n == null) {
            return;
        }
        inorder(n.getLeft());
        System.out.print(n.getData());
        inorder(n.getRight());
    }

    public void postorder(Node n) {
        if(n == null) {
            return;
        }
        postorder(n.getLeft());
        postorder(n.getRight());
        System.out.print(n.getData());
    }
}

class Node {
    private String data;
    private Node left;
    private Node right;

    public Node(String data) {
        this.setData(data);
    }

    public String getData() {return data;}
    public void setData(String data) {this.data = data;}
    public Node getLeft() {return left;}
    public void setLeft(Node left) {this.left = left;}
    public Node getRight() {return right;}
    public void setRight(Node right) {this.right = right;}
}