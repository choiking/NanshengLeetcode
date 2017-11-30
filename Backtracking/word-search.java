public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {//use board[i].length, because it doesn't have to be a matrix
                if (word.charAt(0) == board[i][j]) {//start from the begin pos
                    if (dfs(visited, 0, i, j, board, word)) {
                        return true;
                    } 
                }
            }
        }
        return false;
    }
    boolean dfs(boolean[][] visited, int index, int i, int j, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] 
            || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        if (dfs(visited, index + 1, i + 1, j, board, word) || dfs(visited, index + 1, i - 1, j, board, word)
           || dfs(visited, index + 1, i, j + 1, board, word) || dfs(visited, index + 1, i, j - 1, board, word)) {
            return true;
        }
        visited[i][j] = false; //visited will always 夹住 recursive method
        
        
        
        return false;
    }