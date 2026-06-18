class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;

        for(int i=0; i<n; i++) {
            Set<Character> s = new HashSet<>();

            for(int j=0; j<m; j++) {
                if(s.contains(board[i][j])) return false;
                else if(board[i][j] != '.') s.add(board[i][j]);
           }
        }         

        for(int j=0; j<m; j++) {
            Set<Character> s = new HashSet<>();

            for(int i=0; i<n; i++) {
                if(s.contains(board[i][j])) return false;
                else if(board[i][j] != '.') s.add(board[i][j]);
           }
        }  

        for(int a=0; a<9; a += 3) {
            for(int b=0; b<9; b += 3) {
                Set<Character> s = new HashSet<>();

                for(int i=a; i<a+3; i++) {
                    for(int j=b; j<b+3; j++) {
                        if(s.contains(board[i][j])) return false;
                        else if(board[i][j] != '.') s.add(board[i][j]);
                    }
                }           
            }
        }  

        return true;
    }
}
