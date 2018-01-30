

public class WordDictionary {
    /** Initialize your data structure here. */
    //implement a Trie
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];//only letters a-z or "."
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();//the root node is always empty.
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //we need to do a level order traversal on trie

        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        int index = 0;
        while (index < word.length()) {
            int level = q.size();
            if (level == 0) break;
                for (int i = 0; i < level; i++) {
                    TrieNode item = q.poll();
                    if (word.charAt(index) == '.') {
                        for (TrieNode t : item.children) {
                            if (t != null) q.offer(t);
                        }
                    }
                    else {
                        TrieNode cur = item.children[word.charAt(index) - 'a'];
                        if (cur != null) q.offer(cur);
                    }
                }
                index++;
            }
        for (TrieNode leave : q) {
            if (leave.isWord) return true;
        }
        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */