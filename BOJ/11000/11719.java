package Joshua.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(r);

        String line;

        while ((line = b.readLine()) != null) {
            System.out.println(line);
        }
    }
}