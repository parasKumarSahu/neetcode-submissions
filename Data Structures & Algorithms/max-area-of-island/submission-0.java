class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,
                    dfs(grid, visited, i, j));
                }
            }
        }
        
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m) return 0;
        if(grid[i][j] != 1 || visited[i][j]) return 0;

        visited[i][j] = true;

        return 1 + 
        dfs(grid, visited, i+1, j) +
        dfs(grid, visited, i-1, j) +
        dfs(grid, visited, i, j+1) +
        dfs(grid, visited, i, j-1);

    }
}
