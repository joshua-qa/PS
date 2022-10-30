// 50ms. 자력으로 풀었다..
// 비슷한 문제가 백준에 있어서 풀어본 경험이 있었고, 나름 자신 있었는데.. k가 2 이상이 될 수 있다는 점에서 다소 까다로운 문제였음.
class Solution {
    private int width, height;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private boolean[][][] visit;
    public int shortestPath(int[][] grid, int k) {
        int min = Integer.MAX_VALUE;
        width = grid[0].length;
        height = grid.length;
        visit = new boolean[height][width][k+1];
        Queue<Block> queue = new ArrayDeque<>();

        queue.offer(new Block(0, 0, k, 0));

        while (!queue.isEmpty()) {
            Block curr = queue.poll();
            if (isEnd(curr)) {
                min = Math.min(min, curr.getMove());
                continue;
            }

            if (curr.move >= min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int currX = curr.getX() + dirX[i];
                int currY = curr.getY() + dirY[i];

                if (currX == height-1 && currY == width-1) {
                    queue.offer(new Block(currX, currY, curr.getRemainEliminate(), curr.getMove()+1));
                    continue;
                }

                if (currX < 0 || currX >= height || currY < 0 || currY >= width) {
                    continue;
                }

                if (grid[currX][currY] == 1 && curr.getRemainEliminate() > 0) {
                    if (visit[currX][currY][curr.getRemainEliminate()-1]) {
                        continue;
                    }
                    visit[currX][currY][curr.getRemainEliminate()-1] = true;
                    queue.offer(new Block(currX, currY, curr.getRemainEliminate()-1, curr.getMove()+1));
                    continue;
                }

                if (grid[currX][currY] == 0) {
                    if (visit[currX][currY][curr.getRemainEliminate()]) {
                        continue;
                    }
                    visit[currX][currY][curr.getRemainEliminate()] = true;
                    queue.offer(new Block(currX, currY, curr.getRemainEliminate(), curr.getMove()+1));
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isEnd(Block curr) {
        return curr.getX() == height-1 && curr.getY() == width-1;
    }

    class Block {
        private int x;
        private int y;
        private int remainEliminate;
        private int move;

        public Block(int x, int y, int remainEliminate, int move) {
            this.x = x;
            this.y = y;
            this.remainEliminate = remainEliminate;
            this.move = move;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRemainEliminate() {
            return remainEliminate;
        }

        public int getMove() {
            return move;
        }
    }
}
