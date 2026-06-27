class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }        
    }

    private void dfs(int[][] grid, int i, int j, int dist) {
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m) return;
        if(dist!=0 && grid[i][j] <= dist) return;

        grid[i][j] = dist;
        dist++;

        dfs(grid, i+1, j, dist);
        dfs(grid, i-1, j, dist);
        dfs(grid, i, j+1, dist);
        dfs(grid, i, j-1, dist);
    }
}
