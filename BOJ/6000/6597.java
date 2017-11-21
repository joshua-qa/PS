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

    static class Task {
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            while(true) {
                String input = in.nextLine();

                if(input.equals("-1")) {
                    break;
                }

                StringTokenizer st = new StringTokenizer(input);

                char[] preorder = st.nextToken().toCharArray();
                char[] inorder = st.nextToken().toCharArray();

                getPostOrder(inorder.length, preorder, inorder);
                sb.append("\n");
            }

            out.print(sb);
        }

        private int searchRoot(char c, char[] inorder) {
            for(int i = 0; i < inorder.length; i++) {
                if(inorder[i] == c) {
                    return i;
                }
            }

            return -1;
        }

        private void getPostOrder(int n, char[] preorder, char[] inorder) {
            int root = searchRoot(preorder[0], inorder);

            if(root != 0) {
                char[] newPreorder = Arrays.copyOfRange(preorder, 1, root+1);
                char[] newInorder = Arrays.copyOfRange(inorder, 0, root);
                getPostOrder(newPreorder.length, newPreorder, newInorder);
            }

            if(root != n-1) {
                char[] newPreorder = Arrays.copyOfRange(preorder, root+1, n);
                char[] newInorder = Arrays.copyOfRange(inorder, root+1, n);
                getPostOrder(newPreorder.length, newPreorder, newInorder);
            }

            sb.append(preorder[0]);
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

    }
}