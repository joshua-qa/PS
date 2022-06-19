class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        Trie root = new Trie();
        for (String product : products) {
            root.insert(product);
        }

        StringBuilder sb = new StringBuilder(searchWord.length());
        char[] chars = searchWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            results.add(root.search(sb.toString()));
        }
        return results;
    }
}

class Trie {
    private static final int NODE_COUNT = 26;
    private Trie[] node;
    private TreeSet<String> outputWords;
    private boolean isOutput;

    public Trie() {
        node = new Trie[NODE_COUNT];
        outputWords = new TreeSet<>();
    }

    public void insert(String key) {
        insertInternal(key, 0);
    }

    private void insertInternal(String key, int currIndex) {
        this.outputWords.add(key);
        if (currIndex == key.length()) {
            this.isOutput = true;
            return;
        }

        int currNodeIndex = key.charAt(currIndex) - 'a';
        if (this.node[currNodeIndex] == null) {
            this.node[currNodeIndex] = new Trie();
        }
        this.node[currNodeIndex].insertInternal(key, currIndex+1);
    }

    public List<String> search(String key) {
        List<String> result = new ArrayList<>();
        Trie next = this;
        int length = key.length();
        int index = 0;
        while (next != null && index != length) {
            int currIndex = key.charAt(index) - 'a';
            next = next.node[currIndex];
            index++;
        }
        int size = 3;
        while (next != null && !next.outputWords.isEmpty() && size != 0) {
            size--;
            result.add(next.outputWords.pollFirst());
        }
        return result;
    }
}
