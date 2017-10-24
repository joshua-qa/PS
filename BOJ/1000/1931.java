import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private ArrayList<TimeTable> table = new ArrayList<>();
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            table.add(new TimeTable(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(table, new Comparator<TimeTable>() {
            @Override
            public int compare(TimeTable o1, TimeTable o2) {
                if(o1.end == o2.end) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        int i = 0;
        int currStart = 0;
        int currEnd = 0;

        for(TimeTable t : table) {
            if(t.start >= currEnd) {
                currStart = t.start;
                currEnd = t.end;
                i++;
            }
        }

        System.out.print(i);
    }
}

class TimeTable {
    int start;
    int end;
    public TimeTable(int start, int end) {
        this.start = start;
        this.end = end;
    }
}