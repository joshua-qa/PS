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
        int n;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            while(n-- > 0) {
                ArrayList<Point> pointList = new ArrayList<>();
                pointList.add(new Point(in.nextInt(), in.nextInt()));
                pointList.add(new Point(in.nextInt(), in.nextInt()));
                pointList.add(new Point(in.nextInt(), in.nextInt()));
                pointList.add(new Point(in.nextInt(), in.nextInt()));

                pointList.sort(new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        if(o1.x == o2.x) {
                            return o2.y - o1.y;
                        } else {
                            return o2.x - o1.x;
                        }
                    }
                });

                Point p = pointList.get(0);
                Point q = pointList.get(1);
                Point r = pointList.get(2);
                Point s = pointList.get(3);

                int length1 = (q.y - p.y) * (q.y - p.y) + (q.x - p.x) * (q.x - p.x);
                int length2 = (r.y - p.y) * (r.y - p.y) + (r.x - p.x) * (r.x - p.x);
                int length3 = (s.y - r.y) * (s.y - r.y) + (s.x - r.x) * (s.x - r.x);
                int length4 = (s.y - q.y) * (s.y - q.y) + (s.x - q.x) * (s.x - q.x);
                int diag1 = (r.y - q.y) * (r.y - q.y) + (q.x - r.x) * (q.x - r.x);
                int diag2 = (s.y - p.y) * (s.y - p.y) + (p.x - s.x) * (p.x - s.x);

                if(length1 == length2 && length3 == length4 && length1 == length3 && diag1 == diag2) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }

            out.print(sb);
        }

        class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
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