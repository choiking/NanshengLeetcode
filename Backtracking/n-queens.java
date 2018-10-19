/*
    time complexity: O(n!).
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        //buildBoard
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }
    private void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {//return res;
            List<String> list = new ArrayList<> ();
            for (int i = 0; i < board.length; i++)
                list.add(new String(board[i]));
            res.add(list);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, col + 1, res);
                board[row][col] = '.';//this Q fails, so mark it as '.'
            }
        }

    }

    private boolean validate(char[][] board, int row, int col) {
        //check previous Q
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (i == row || Math.abs(i - row) == Math.abs(j - col))) 
                    return false;
            }
        }
        return true;
    }
