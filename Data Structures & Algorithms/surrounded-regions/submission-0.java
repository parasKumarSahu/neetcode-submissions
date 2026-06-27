class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O') {
                    if(dfs(board, i, j, 'P')) {
                        dfs(board, i, j, 'X');
                    } else {
                        dfs(board, i, j, 'O');
                    }
                }
            }
        }        
    }

    private boolean dfs(char[][] board, int i, int j, char write) {
        int n = board.length;
        int m = board[0].length;

        if(i<0 || j<0 || i>=n || j>=m) return false;
        if(board[i][j] == write || board[i][j] == 'X') return true;

        board[i][j] = write;

        return dfs(board, i+1, j, write)
        && dfs(board, i-1, j, write)
        && dfs(board, i, j+1, write)
        && dfs(board, i, j-1, write);

    }
}
