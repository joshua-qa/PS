import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private StringTokenizer st;
    private ArrayList<ColorBall> ballList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c, s, total = 0;
        int[] sumArray = new int[n];
        int[] colorSum = new int[n+1];
        ColorBall curr;
        ColorBall search;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            colorSum[c] += s;
            total += s;
            ballList.add(new ColorBall(i, c, s));
        }

        Collections.sort(ballList, new Comparator<ColorBall>() {
            @Override
            public int compare(ColorBall o1, ColorBall o2) {
                if(o1.size == o2.size) {
                    return o1.color - o2.color;
                } else {
                    return o1.size - o2.size;
                }
            }
        });


        for(int i = n-1; i >= 0; i--) {
            curr = ballList.get(i);
            sumArray[curr.index] = total;
            for(int j = i-1; j >= 0; j--) {
                search = ballList.get(j);
                if(search.size == curr.size && search.color != curr.color) {
                    sumArray[curr.index] -= search.size;
                } else if(search.size < curr.size) {
                    break;
                }
            }
            total -= curr.size;
            sumArray[curr.index] -= colorSum[curr.color];
            colorSum[curr.color] -= curr.size;
        }

        for(int i = 0; i < n; i++) {
            sb.append(sumArray[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}

class ColorBall {
    int index;
    int color;
    int size;

    public ColorBall(int index, int color, int size) {
        this.index = index;
        this.color = color;
        this.size = size;
    }
}