import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    int ans = 0;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[board.length][board[0].length()];

        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        solve(map);
        answer = ans;

        return answer;
    }

    private void solve(char[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        int curr = 0;
        char[][] newMap = new char[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            newMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for(int i = 0; i < map.length - 1; i++) {
            for(int j = 0; j < map[0].length - 1; j++) {
                if(map[i][j] == ' ') {
                    continue;
                }
                if(check(map, i, j)) {
                    temp[i][j] = 1;
                    temp[i][j+1] = 1;
                    temp[i+1][j] = 1;
                    temp[i+1][j+1] = 1;
                }
            }
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(temp[i][j] == 1) {
                    newMap[i][j] = ' ';
                }
            }
        }


        for(int i = 0; i < map[0].length; i++) {
            for(int j = map.length - 1; j >= 0; j--) {
                if(temp[j][i] == 1) {
                    curr++;
                    continue;
                } else {
                    int ci = j;
                    while(ci+1 < map.length && newMap[ci+1][i] == ' ') {
                        newMap[ci+1][i] = newMap[ci][i];
                        newMap[ci][i] = ' ';
                        ci++;
                    }
                }
            }
        }

        for(int i = 0; i < newMap.length; i++) {
            for(int j = 0; j < newMap[0].length; j++) {
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }

        if(curr == 0) {
            return;
        } else {
            ans += curr;
            solve(newMap);
        }
    }

    private boolean check(char[][] map, int x, int y) {
        return map[x][y] == map[x][y+1] && map[x][y] == map[x+1][y] && map[x][y] == map[x+1][y+1];
    }

    private boolean isAlphabet(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }

    private boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(",");

        System.out.println(solution(input));

    }

//    public void run() throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("C:/java/kakao/1.txt"));

        // String 배열용
//        while(true) {
//            String s = br.readLine();
//            if(s == null) {
//                break;
//            }
//            s = s.replace("\"", "");
//            s = s.replace("[", "");
//            s = s.replace("]", "");
//            String[] str = s.split(",");
//            System.out.println(solution(str));
//        }
        // String 배열용 (Tokenizer)
//        while(true) {
//            String s = br.readLine();
//
//            if(s == null) {
//                break;
//            }
//            s = s.replace("\"", "");
//            s = s.replace("[", "");
//            s = s.replace("]", "");
//            String[] str = s.split(",");
//            System.out.println(solution(str));
//        }

        // int 배열용
//        while(true) {
//            String s = br.readLine();
//            if(s == null) {
//                break;
//            }
//
//            s = s.replace("[", "");
//            s = s.replace("]", "");
//            String[] strs = s.split(",");
//            int[] nums = new int[strs.length];
//
//            for(int i = 0; i < nums.length; i++) {
//                nums[i] = Integer.parseInt(strs[i]);
//            }
//            System.out.println(solution(nums));
//        }
//    }
}

