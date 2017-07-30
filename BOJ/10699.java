import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        String dateFormat = "yyyy-MM-dd";
        TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        df.setTimeZone(tz);
        Date d = new Date();
        System.out.print(df.format(d));
    }
}