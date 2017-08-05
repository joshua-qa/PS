import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] cup = {1, 0, 0};
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ca = br.readLine().toCharArray();
        for(char c : ca) {
            if(c == 'A') {
                shuffleA();
            } else if(c == 'B') {
                shuffleB();
            } else if(c == 'C') {
                shuffleC();
            }
        }

        for(int i = 0; i < 3; i++) {
            if(cup[i] == 1) {
                System.out.print(i+1);
            }
        }
    }

    private void shuffleA() {
        int temp = cup[1];
        cup[1] = cup[0];
        cup[0] = temp;
    }

    private void shuffleB() {
        int temp = cup[1];
        cup[1] = cup[2];
        cup[2] = temp;
    }

    private void shuffleC() {
        int temp = cup[2];
        cup[2] = cup[0];
        cup[0] = temp;
    }
}