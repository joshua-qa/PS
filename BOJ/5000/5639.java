import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.run(in, out);
        out.close();
    }

    static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    static class Task {
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            int root = in.nextInt();

            Node rootNode = new Node(root);
            while(true) {
                int curr = Integer.parseInt(in.nextLine());
                if(curr == -1) {
                    break;
                }

                Node node = new Node(curr);
                addNode(rootNode, node);
            }

            postOrder(rootNode);

            out.print(sb);
        }

        private void postOrder(Node node) {
            if(node == null) {
                return;
            }

            postOrder(node.leftChild);
            postOrder(node.rightChild);
            sb.append(node.value).append("\n");
        }

        private void addNode(Node root, Node curr) {
            if(root.value > curr.value) {
                if(root.leftChild == null) {
                    root.leftChild = curr;
                } else {
                    addNode(root.leftChild, curr);
                }
            } else if(root.value < curr.value) {
                if(root.rightChild == null) {
                    root.rightChild = curr;
                } else {
                    addNode(root.rightChild, curr);
                }
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextLine() {
            String s;
            try {
                s = reader.readLine();
            } catch (Exception e) {
                return "-1";
            }
            if(s == null || s.equals("")) {
                return "-1";
            }

            return s;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}