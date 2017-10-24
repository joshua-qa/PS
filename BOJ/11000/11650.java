import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    ArrayList<Point> pointList = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String s[] = br.readLine().split(" ");
            pointList.add(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        Collections.sort(pointList);
        for(Point p : pointList) {
            sb.append(p.x + " " + p.y + "\n");
        }

        System.out.print(sb.toString());
    }
}

class Point implements Comparable {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        int compareX = ((Point) o).x;
        int compareY = ((Point) o).y;

        if(this.x != compareX) {
            return this.x - compareX;
        } else {
            return this.y - compareY;
        }
    }
}