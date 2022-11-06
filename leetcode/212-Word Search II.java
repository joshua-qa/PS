// 946ms. 생각한대로 풀었더니 바로 맞아서 기쁘다. 최적화는 할 수 있지만 일단 여기까지
class Solution {
    private int width, height, maxWordLength;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private char[][] input;
    private Set<String> result;
    private Trie trie;
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        input = board;

        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
            maxWordLength = Math.max(word.length(), maxWordLength);
        }

        width = board[0].length;
        height = board.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = board[i][j] - 'a';
                if (trie.node[index] == null) {
                    continue;
                }
                boolean[][] visit = new boolean[height][width];
                visit[i][j] = true;
                dfs(i, j, visit, String.valueOf(board[i][j]), trie.node[index]);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(int x, int y, boolean[][] visit, String currStr, Trie currNode) {
        if (currNode.getMatchList() != null && currNode.getMatchList().contains(currStr)) {
            result.add(currStr);
        }
        if (currStr.length() == maxWordLength) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currX >= height || currY < 0 || currY >= width || visit[currX][currY]) {
                continue;
            }

            int index = input[currX][currY] - 'a';
            if (currNode.node[index] == null) {
                continue;
            }

            visit[currX][currY] = true;
            dfs(currX, currY, visit, currStr + input[currX][currY], currNode.node[index]);
            visit[currX][currY] = false;
        }
    }

    class Trie {
        private Trie[] node;
        private List<String> matchList;

        public Trie() {
            this.node = new Trie[26];
        }

        public void insert(String str) {
            int index = 0;
            int length = str.length();

            Trie curr = this;
            while (true) {
                int c = str.charAt(index) - 'a';
                if (curr.node[c] == null) {
                    curr.node[c] = new Trie();
                }
                curr = curr.node[c];
                if (index == length-1) {
                    if (curr.matchList == null) {
                        curr.matchList = new ArrayList<>();
                    }
                    curr.matchList.add(str);
                    break;
                }
                index++;
            }
        }

        public List<String> getMatchList() {
            return matchList;
        }
    }
}
