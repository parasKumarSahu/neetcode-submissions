class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(board, word, i, j, 0)) 
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int n = board.length;
        int m = board[0].length;

        if(i<0 || j<0 || i>=n || j>=m) return false;

        if(board[i][j] != word.charAt(k)) return false;

        if(k == word.length()-1) return true;

        char tmp = board[i][j];
        board[i][j] = '#';

        boolean ans = dfs(board, word, i+1, j, k+1) ||
                        dfs(board, word, i-1, j, k+1) ||
                        dfs(board, word, i, j+1, k+1) ||
                        dfs(board, word, i, j-1, k+1);

        board[i][j] = tmp;

        return ans;
    }
}
