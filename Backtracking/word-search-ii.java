class Solution {
    //     class Trie {

    //     class TrieNode {
    //         boolean isWord;
    //         TrieNode[] children = new TrieNode[26];
    //     }

    //     private TrieNode root;


    //     /** Initialize your data structure here. */
    //     public Trie() {
    //         root = new TrieNode();
    //     }

    //     /** Inserts a word into the trie. */
    //     public void insert(String word) {
    //         TrieNode temp = root;
    //         for (int i = 0; i < word.length(); i++) {
    //             if (temp.children[word.charAt(i) - 'a'] == null) {// if it is NOT null, means it exists!
    //                 temp.children[word.charAt(i) - 'a'] = new TrieNode();
    //             }
    //             temp = temp.children[word.charAt(i) - 'a'];
    //         }
    //         temp.isWord = true;
    //     }

    //     /** Returns if the word is in the trie. */
    //     public boolean search(String word) {
    //         TrieNode temp = root;
    //         for (int i = 0; i < word.length(); i++) {
    //             if (temp.children[word.charAt(i) - 'a'] == null) {
    //                 return false;
    //             }
    //             temp = temp.children[word.charAt(i) - 'a'];
    //         }
    //         return temp.isWord;
    //     }

    //     /** Returns if there is any word in the trie that starts with the given prefix. */
    //     public boolean startsWith(String prefix) {
    //         TrieNode temp = root;
    //         for (int i = 0; i < prefix.length(); i++) {
    //             if (temp.children[prefix.charAt(i) - 'a'] == null) {
    //                 return false;
    //             }
    //             temp = temp.children[prefix.charAt(i) - 'a'];
    //         }
    //         for (int i = 0; i < 26; i++) {
    //             if (temp.children[i] != null) {
    //                 return true;//prefix means at least ONE char left at the word.
    //             }
    //         }
    //         return true;//which means it is the left node(so it's isWord must be true);
    //     }
    // }
    //end of Trie Data Structrue


    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }//construct a Trie
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(trie, i, j, "", board, visited);
            }
        }
        return new ArrayList<> (res);
    }
    void dfs(Trie trie, int i, int j, String tempStr, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]) return;
        tempStr += board[i][j];
        if (!trie.startsWith(tempStr)) return;//If the current tempStr does not exist in all words' prefix, stop it immediately. 
        if (trie.search(tempStr)) {
            res.add(tempStr);
        }
        visited[i][j] = true;
        dfs(trie, i + 1, j, tempStr, board, visited);
        dfs(trie, i - 1, j, tempStr, board, visited);
        dfs(trie, i, j + 1, tempStr, board, visited);
        dfs(trie, i, j - 1, tempStr, board, visited);
        visited[i][j] = false;
    }
}



public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}

public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
