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

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Task {
        int n, m, ans, count, time;
        int[][] map;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Point> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                    if(map[i][j] != 0) {
                        count++;
                    }
                }
            }

            while(true) {
                time++;
                int[][] currMap = getResult();
                boolean flag = true;
                int groupCount = 0;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(currMap[i][j] == 0) {
                            continue;
                        } else {
                            groupCount = getGroup(i, j, currMap);
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) {
                        break;
                    }
                }
                if(count > 0 && groupCount != count) {
                    ans = time;
                    break;
                } else if(count <= 0) {
                    ans = 0;
                    break;
                }

                map = currMap;
            }

            out.print(ans);
        }

        private int getGroup(int i, int j, int[][] newMap) {
            int result = 0;
            boolean[][] check = new boolean[n][m];
            visit.offer(new Point(i, j));
            check[i][j] = true;

            while(!visit.isEmpty()) {
                Point curr = visit.poll();
                result++;

                for (int k = 0; k < dx.length; k++) {
                    if (curr.x + dx[k] < 0 || curr.x + dx[k] >= n || curr.y + dy[k] < 0 || curr.y + dy[k] >= m) {
                        continue;
                    }
                    if (!check[curr.x + dx[k]][curr.y + dy[k]] && newMap[curr.x + dx[k]][curr.y + dy[k]] != 0) {
                        visit.offer(new Point(curr.x + dx[k], curr.y + dy[k]));
                        check[curr.x + dx[k]][curr.y + dy[k]] = true;
                    }
                }
            }

            return result;
        }

        private int[][] getResult() {
            int[][] newMap = new int[n][m];

            int x = 0;
            int y = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != 0) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }

            boolean[][] check = new boolean[n][m];
            visit.offer(new Point(x, y));
            check[x][y] = true;

            while(!visit.isEmpty()) {
                Point curr = visit.poll();
                newMap[curr.x][curr.y] = map[curr.x][curr.y];

                for (int k = 0; k < dx.length; k++) {
                    if (curr.x + dx[k] < 0 || curr.x + dx[k] >= n || curr.y + dy[k] < 0 || curr.y + dy[k] >= m) {
                        continue;
                    }

                    if(map[curr.x + dx[k]][curr.y + dy[k]] == 0 && newMap[curr.x][curr.y] > 0) {
                        newMap[curr.x][curr.y]--;
                    }

                    if (!check[curr.x + dx[k]][curr.y + dy[k]] && map[curr.x + dx[k]][curr.y + dy[k]] != 0) {
                        visit.offer(new Point(curr.x + dx[k], curr.y + dy[k]));
                        check[curr.x + dx[k]][curr.y + dy[k]] = true;
                    }
                }

                if(newMap[curr.x][curr.y] == 0) {
                    count--;
                }
            }

            return newMap;
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