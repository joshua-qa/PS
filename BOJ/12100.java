import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] init;
    int max, size;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        init = new int[n][n];
        size = n;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 : up, 2 : down, 3 : left, 4 : right
        for(int i = 1; i <= 4; i++) {
            rec(init, 5, i);
        }

        System.out.print(max);
    }

    private void rec(int[][] board, int n, int command) {
        if(n == 0) {
            return;
        }
        int[][] curr = new int[size][size];
        for(int i = 0; i < curr.length; i++) {
            System.arraycopy(board[i], 0, curr[i], 0, board[i].length);
        }

        if(command == 1) {
            curr = moveUp(board);
        } else if(command == 2) {
            curr = moveDown(board);
        } else if(command == 3) {
            curr = moveLeft(board);
        } else {
            curr = moveRight(board);
        }

        for(int i = 1; i <= 4; i++) {
            rec(curr, n-1, i);
        }
    }

    private int[][] moveUp(int[][] currBoard) {
        int[][] moveBoard = new int[size][size];
        for(int i = 0; i < moveBoard.length; i++) {
            System.arraycopy(currBoard[i], 0, moveBoard[i], 0, currBoard[i].length);
        }
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(moveBoard[j][i] > max) {
                    max = moveBoard[j][i];
                }
                if(moveBoard[j][i] == 0) {
                    continue;
                } else {
                    while(j-1 >= 0 && moveBoard[j-1][i] == 0) {
                        moveBoard[j-1][i] = moveBoard[j][i];
                        moveBoard[j][i] = 0;
                        j--;
                    }
                }
            }
            for(int j = 0; j < size-1; j++) {
                if(moveBoard[j][i] == moveBoard[j+1][i]) {
                    moveBoard[j][i] *= 2;
                    if(moveBoard[j][i] > max) {
                        max = moveBoard[j][i];
                    }
                    moveBoard[j+1][i] = 0;
                    int k = j+2;
                    while(k < size && moveBoard[k][i] != 0) {
                        moveBoard[k-1][i] = moveBoard[k][i];
                        moveBoard[k][i] = 0;
                        k++;
                    }
                }
            }
        }

        return moveBoard;
    }

    private int[][] moveDown(int[][] currBoard) {
        int[][] moveBoard = new int[size][size];
        for(int i = 0; i < moveBoard.length; i++) {
            System.arraycopy(currBoard[i], 0, moveBoard[i], 0, currBoard[i].length);
        }
        for(int i = 0; i < size; i++) {
            for(int j = size-1; j >= 0; j--) {
                if(moveBoard[j][i] > max) {
                    max = moveBoard[j][i];
                }
                if(moveBoard[j][i] == 0) {
                    continue;
                } else {
                    while(j+1 < size && moveBoard[j+1][i] == 0) {
                        moveBoard[j+1][i] = moveBoard[j][i];
                        moveBoard[j][i] = 0;
                        j++;
                    }
                }
            }
            for(int j = size-1; j > 0; j--) {
                if(moveBoard[j][i] == moveBoard[j-1][i]) {
                    moveBoard[j][i] *= 2;
                    if(moveBoard[j][i] > max) {
                        max = moveBoard[j][i];
                    }
                    moveBoard[j-1][i] = 0;
                    int k = j-2;
                    while(k >= 0 && moveBoard[k][i] != 0) {
                        moveBoard[k+1][i] = moveBoard[k][i];
                        moveBoard[k][i] = 0;
                        k--;
                    }
                }
            }
        }

        return moveBoard;
    }

    private int[][] moveLeft(int[][] currBoard) {
        int[][] moveBoard = new int[size][size];
        for(int i = 0; i < moveBoard.length; i++) {
            System.arraycopy(currBoard[i], 0, moveBoard[i], 0, currBoard[i].length);
        }
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(moveBoard[i][j] > max) {
                    max = moveBoard[j][i];
                }
                if(moveBoard[i][j] == 0) {
                    continue;
                } else {
                    while(j-1 >= 0 && moveBoard[i][j-1] == 0) {
                        moveBoard[i][j-1] = moveBoard[i][j];
                        moveBoard[i][j] = 0;
                        j--;
                    }
                }
            }
            for(int j = 0; j < size-1; j++) {
                if(moveBoard[i][j] == moveBoard[i][j+1]) {
                    moveBoard[i][j] *= 2;
                    if(moveBoard[i][j] > max) {
                        max = moveBoard[i][j];
                    }
                    moveBoard[i][j+1] = 0;
                    int k = j+2;
                    while(k < size && moveBoard[i][k] != 0) {
                        moveBoard[i][k-1] = moveBoard[i][k];
                        moveBoard[i][k] = 0;
                        k++;
                    }
                }
            }
        }

        return moveBoard;
    }

    private int[][] moveRight(int[][] currBoard) {
        int[][] moveBoard = new int[size][size];
        for(int i = 0; i < moveBoard.length; i++) {
            System.arraycopy(currBoard[i], 0, moveBoard[i], 0, currBoard[i].length);
        }
        for(int i = 0; i < size; i++) {
            for(int j = size-1; j >= 0; j--) {
                if(moveBoard[i][j] > max) {
                    max = moveBoard[j][i];
                }
                if(moveBoard[i][j] == 0) {
                    continue;
                } else {
                    while(j+1 < size && moveBoard[i][j+1] == 0) {
                        moveBoard[i][j+1] = moveBoard[i][j];
                        moveBoard[i][j] = 0;
                        j++;
                    }
                }
            }
            for(int j = size-1; j > 0; j--) {
                if(moveBoard[i][j] == moveBoard[i][j-1]) {
                    moveBoard[i][j] *= 2;
                    if(moveBoard[i][j] > max) {
                        max = moveBoard[i][j];
                    }
                    moveBoard[i][j-1] = 0;
                    int k = j-2;
                    while(k >= 0 && moveBoard[i][k] != 0) {
                        moveBoard[i][k+1] = moveBoard[i][k];
                        moveBoard[i][k] = 0;
                        k--;
                    }
                }
            }
        }

        return moveBoard;
    }
}