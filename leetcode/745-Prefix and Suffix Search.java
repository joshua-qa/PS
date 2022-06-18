/**
 * 450ms / 56.82%.. 최적화 어느정도 가능해보이는데 이쯤에서 컷
 */
class WordFilter {
    private Trie root;
    public WordFilter(String[] words) {
        root = new Trie();
        for (int n = 0; n < words.length; n++) {
            int wordLength = words[n].length();
            int suffixCount = wordLength < 10 ? wordLength : 10;
            // suffixcount 3, i = 3-1 (2) , i >= 3 - 3
            char[] chars = words[n].toCharArray();
            String currKey = "#" + words[n];
            for (int i = wordLength-1; i >= wordLength-suffixCount; i--) {
                currKey = chars[i] + currKey;
                root.insert(currKey, n);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return this.root.search(suffix + "#" + prefix);
    }
}

class Trie {
    private Trie[] node;
    private int outputIndex;
    private boolean output;
    private static final int NODE_COUNT = 27;
    private static final int SHARP_INDEX = 26;

    public Trie() {
        node = new Trie[NODE_COUNT];
        outputIndex = -1;
    }

    public void insert(String key, int wordIndex) {
        insertInternal(key.toCharArray(), wordIndex, 0);
    }

    private void insertInternal(char[] key, int wordIndex, int index) {
        if (key.length == index) {
            this.output = true;
            this.outputIndex = wordIndex;
            return;
        }

        int nodeIndex = key[index] == '#' ? SHARP_INDEX : key[index] - 'a';
        if (this.node[nodeIndex] == null) {
            this.node[nodeIndex] = new Trie();
        }
        this.node[nodeIndex].insertInternal(key, wordIndex, index+1);
    }

    public int search(String key) {
        return searchInternal(key.toCharArray(), 0);
    }

    private int searchInternal(char[] key, int currIndex) {
        if (key.length == currIndex) {
            return getMaxOutputIndex(this);
        }
        int nodeIndex = key[currIndex] == '#' ? SHARP_INDEX : key[currIndex] - 'a';
        if (this.node[nodeIndex] == null) {
            return -1;
        }
        return this.node[nodeIndex].searchInternal(key, currIndex+1);
    }

    private int getMaxOutputIndex(Trie root) {
        int result = root.output ? root.outputIndex : -1;
        for (int i = 0; i < SHARP_INDEX; i++) {
            if (root.node[i] != null) {
                int outputIndex = getMaxOutputIndex(root.node[i]);
                if (result < outputIndex) {
                    result = outputIndex;
                }
            }
        }
        return result;
    }
}