import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private int flushCount, maxMatch, maxNumber;
    private final int MAX = 5;
    private int[] group = new int[4];
    private int[] num = new int[9];
    private StringTokenizer st;
    private ArrayList<Card> deck = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());
            switch (color) {
                case 'R' :
                    group[0]++;
                    break;
                case 'B' :
                    group[1]++;
                    break;
                case 'Y' :
                    group[2]++;
                    break;
                case 'G' :
                    group[3]++;
                    break;
            }
            num[number-1]++;
            maxNumber = Math.max(maxNumber, number);
            deck.add(new Card(color, number));
        }

        for(int i = 0; i < group.length; i++) {
            maxMatch = Math.max(group[i], maxMatch);
        }
        for(int i = 0; i < num.length; i++) {
            if(flushCount == 0 && num[i] == 0) {
                continue;
            } else if(flushCount != 0 && num[i] == 0) {
                break;
            } else {
                flushCount++;
            }
        }

        int max = 0;

        max = Math.max(isCaseOne(), max);
        max = Math.max(isCaseTwo(), max);
        max = Math.max(isCaseThree(), max);
        max = Math.max(isCaseFour(), max);
        max = Math.max(isCaseFive(), max);
        max = Math.max(isCaseSix(), max);
        max = Math.max(isCaseSeven(), max);
        max = Math.max(isCaseEight(), max);
        if(max == 0) {
            max = maxNumber + 100;
        }

        System.out.print(max);
    }

    private int isCaseOne() {
        if(maxMatch == 5 && flushCount == 5) {
            return maxNumber + 900;
        } else {
            return 0;
        }
    }

    private int isCaseTwo() {
        for(int i = 0; i < num.length; i++) {
            if(num[i] == 4) {
                return i+1+800;
            }
        }
        return 0;
    }

    private int isCaseThree() {
        int twoCount = -1, threeCount = -1;
        for(int i = 0; i < num.length; i++) {
            if(num[i] == 2) {
                twoCount = i+1;
            } else if(num[i] == 3) {
                threeCount = i+1;
            }
        }
        if(twoCount != -1 && threeCount != -1) {
            return (threeCount * 10) + twoCount + 700;
        } else {
            return 0;
        }
    }

    private int isCaseFour() {
        if(maxMatch == 5 && flushCount != 5) {
            return maxNumber + 600;
        } else {
            return 0;
        }
    }

    private int isCaseFive() {
        if(maxMatch != 5 && flushCount == 5) {
            return maxNumber + 500;
        } else {
            return 0;
        }
    }

    private int isCaseSix() {
        for(int i = 0; i < num.length; i++) {
            if(num[i] == 3) {
                return i+1+400;
            }
        }
        return 0;
    }

    private int isCaseSeven() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length; i++) {
            if(num[i] == 2) {
                list.add(i+1);
            }
        }
        if(list.size() == 2) {
            return (list.get(1) * 10) + list.get(0) + 300;
        } else {
            return 0;
        }
    }

    private int isCaseEight() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length; i++) {
            if(num[i] == 2) {
                list.add(i+1);
            }
        }
        if(list.size() == 1) {
            return list.get(0) + 200;
        } else {
            return 0;
        }
    }
}

class Card {
    char color;
    int number;
    public Card(char color, int number) {
        this.color = color;
        this.number = number;
    }
}