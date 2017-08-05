import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
    String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String d = st.nextToken();
        String m = st.nextToken();

        if(d.length() == 1) {
            d = "0" + d;
        }
        if(m.length() == 1) {
            m = "0" + m;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date date = sdf.parse("2009"+m+d);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK);

        System.out.print(dayOfWeek[dayNum-1]);
    }
}