import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    ArrayList<album> albumList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fillData();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(get(start, end));
        }
        System.out.print(sb);
    }

    public String get(int start, int end) {
        StringBuilder mapSb = new StringBuilder();
        int count = 0;
        for(album a : albumList) {
            if(a.year >= start && a.year <= end) {
                count++;
                mapSb.append(a.toString() + "\n");
            }
        }

        return count + "\n" + mapSb.toString();
    }

    public void fillData() {
        albumList.add(new album(1967, "DavidBowie"));
        albumList.add(new album(1969, "SpaceOddity"));
        albumList.add(new album(1970, "TheManWhoSoldTheWorld"));
        albumList.add(new album(1971, "HunkyDory"));
        albumList.add(new album(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"));
        albumList.add(new album(1973, "AladdinSane"));
        albumList.add(new album(1973, "PinUps"));
        albumList.add(new album(1974, "DiamondDogs"));
        albumList.add(new album(1975, "YoungAmericans"));
        albumList.add(new album(1976, "StationToStation"));
        albumList.add(new album(1977, "Low"));
        albumList.add(new album(1977, "Heroes"));
        albumList.add(new album(1979, "Lodger"));
        albumList.add(new album(1980, "ScaryMonstersAndSuperCreeps"));
        albumList.add(new album(1983, "LetsDance"));
        albumList.add(new album(1984, "Tonight"));
        albumList.add(new album(1987, "NeverLetMeDown"));
        albumList.add(new album(1993, "BlackTieWhiteNoise"));
        albumList.add(new album(1995, "1.Outside"));
        albumList.add(new album(1997, "Earthling"));
        albumList.add(new album(1999, "Hours"));
        albumList.add(new album(2002, "Heathen"));
        albumList.add(new album(2003, "Reality"));
        albumList.add(new album(2013, "TheNextDay"));
        albumList.add(new album(2016, "BlackStar"));
    }
}

class album {
    int year;
    String albumName;
    public album(int year, String albumName) {
        this.year = year;
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return year + " " + albumName;
    }
}