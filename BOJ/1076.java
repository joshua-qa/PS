import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> colorList = new ArrayList<>();
        colorList.add("black");
        colorList.add("brown");
        colorList.add("red");
        colorList.add("orange");
        colorList.add("yellow");
        colorList.add("green");
        colorList.add("blue");
        colorList.add("violet");
        colorList.add("grey");
        colorList.add("white");
        long[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long[] multiple = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int firstIndex = colorList.indexOf(first);
        int secondIndex = colorList.indexOf(second);
        int thirdIndex = colorList.indexOf(third);

        long result = (value[firstIndex] * 10 + value[secondIndex]) * multiple[thirdIndex];

        System.out.print(result);
    }
}