class PrefixTree {

    PrefixTree[] children;
    boolean isEnd;

    public PrefixTree() {
        children = new PrefixTree[26];
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new PrefixTree();
            }
            
            curr = curr.children[c-'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) break;
            
            curr = curr.children[c-'a'];
        }

        return curr.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for(char c: prefix.toCharArray()) {
            if(curr.children[c-'a'] == null) return false;
            
            curr = curr.children[c-'a'];
        }

        return true;
    }
}
