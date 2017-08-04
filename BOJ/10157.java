import java.io.*;

public class Main {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int h = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[0]);
        int n = Integer.parseInt(br.readLine());
        int x = h;
        int y = w-1;
        int i = -1, j = 0;
        int pos = 1;

        int max = w * h;
        int[][] map = new int[w][h];

        if(max < n) {
            sb.append(0);
        } else {
            int count = 1;

            while(count <= n && count <= max) {
                for(int p = 0; p < x; p++) {

                    i += pos;
                    map[j][i] = count++;
                    if(count > n) {
                        break;
                    }
                }

                if(count > n || count > max) {
                    break;
                }
                x--;

                for(int p = 0; p < y; p++) {
                    j += pos;
                    map[j][i] = count++;
                    if(count > n) {
                        break;
                    }
                }
                y--;

                pos *= -1;
            }
            sb.append((j+1) + " " + (i+1));
        }

        System.out.println(sb);
    }
}