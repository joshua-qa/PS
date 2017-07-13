import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        prime();
        int n = Integer.valueOf(br.readLine());
        StringBuffer sb = new StringBuffer();

        boolean flag = false;

        if(n > 7) {
            for (int i = 2; i < n; i++) {
                if (prime[i]) {
                    continue;
                }
                for (int j = 2; j < n; j++) {
                    if (prime[j]) {
                        continue;
                    }
                    for (int k = 2; k < n; k++) {
                        if ((n - i - j - k) < 2 || prime[k] || prime[n - i - j - k]) {
                            continue;
                        }

                        if (!prime[n - i - j - k]) {
                            sb.append(i + " " + j + " " + k + " " + (n - i - j - k));
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sb.toString());
        }
    }

    private static void prime() {
        prime[1] = true;
        for(int i = 2; i*i <= prime.length; i++) {
            for(int j = i*2; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}