class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) grid[i][j] = -1;
                if(grid[i][j] == 1) grid[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 2) grid[i][j] = 0;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }    

        int maxDist = 0;    
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
               maxDist = Math.max(maxDist, grid[i][j]);
            }
        }
        
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
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
