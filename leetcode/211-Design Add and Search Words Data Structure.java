// 426ms. 처음 제출 결과가 너무 느려서 maxLength로 한번 최적화했더니 절반 이상 줄었다. bfs 대신 dfs를 써도 됐을듯!
class WordDictionary {
    private TrieNode head;
    private int[] maxLength;
    public WordDictionary() {
        this.head = new TrieNode();
        this.maxLength = new int[26];
    }
    
    public void addWord(String word) {
        this.head.insert(word.toCharArray(), 0);
        int length = word.length();
        if (length > this.maxLength[word.charAt(0) - 'a']) {
            this.maxLength[word.charAt(0) - 'a'] = length;
        }
    }

    public boolean search(String word) {
        Queue<Pair<TrieNode, Integer>> queue = new LinkedList<>();
        char[] key = word.toCharArray();
        int wordLength = key.length;
        if (key[0] == '.') {
            for (int i = 0; i < 26; i++) {
                TrieNode child = this.head.getNode(i);
                if (child == null || this.maxLength[i] < wordLength) {
                    continue;
                }
                queue.offer(new Pair<>(child, 0));
            }
        } else {
            TrieNode child = this.head.getNode(key[0] - 'a');
            if (child == null) {
                return false;
            }
            queue.offer(new Pair<>(child, 0));
        }

        while (!queue.isEmpty()) {
            Pair<TrieNode, Integer> curr = queue.poll();
            int currIndex = curr.getValue();
            TrieNode currNode = curr.getKey();
            if (currIndex == wordLength-1) {
                if (currNode.isEnd()) {
                    return true;
                }
                continue;
            }

            if (key[currIndex+1] != '.') {
                TrieNode next = currNode.getNode(key[currIndex+1] - 'a');
                if (next == null) {
                    continue;
                }
                queue.offer(new Pair<>(next, currIndex+1));
                continue;
            }

            for (int i = 0; i < 26; i++) {
                TrieNode next = currNode.getNode(i);
                if (next == null) {
                    continue;
                }
                queue.offer(new Pair<>(next, currIndex+1));
            }
        }

        return false;
    }
}

class TrieNode {
    private TrieNode[] node;
    private boolean isEnd;

    public TrieNode() {
        node = new TrieNode[26];
    }

    public void insert(char[] word, int index) {
        int alphabetIndex = word[index] - 'a';
        if (this.node[alphabetIndex] == null) {
            this.node[alphabetIndex] = new TrieNode();
        }

        if (word.length == index+1) {
            this.node[alphabetIndex].isEnd = true;
            return;
        }

        this.node[alphabetIndex].insert(word, index+1);
    }

    public TrieNode getNode(int alphabetIndex) {
        return this.node[alphabetIndex];
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
