// 41ms. 오랜만에 구현해보네
class Trie {
    private Trie[] node;
    private boolean isEnd;
    public Trie() {
        node = new Trie[26];
    }
    
    public void insert(String word) {
        int index = 0;
        Trie curr = this;
        while (index < word.length()) {
            if (curr.node[word.charAt(index) - 'a'] == null) {
                curr.node[word.charAt(index) - 'a'] = new Trie();
            }
            curr = curr.node[word.charAt(index) - 'a'];
            index++;
            if (index == word.length()) {
                curr.isEnd = true;
            }
        }
    }
    
    public boolean search(String word) {
        return searchInternal(word, 0, false);
    }
    
    public boolean startsWith(String prefix) {
        return searchInternal(prefix, 0, true);
    }

    private boolean searchInternal(String key, int currIndex, boolean isPrefixSearch) {
        if (currIndex == key.length()) {
            return isPrefixSearch || this.isEnd;
        }
        Trie curr = this.node[key.charAt(currIndex) - 'a'];
        if (curr == null) {
            return false;
        }
        return curr.searchInternal(key, currIndex+1, isPrefixSearch);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
 
