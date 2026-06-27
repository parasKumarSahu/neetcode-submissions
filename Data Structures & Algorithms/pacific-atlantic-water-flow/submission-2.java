/*
2 1
1 2
*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] visitedPacific = new boolean[n][m];
        for(int i=0; i<n; i++) dfs(heights, visitedPacific, i, 0, 0);
        for(int j=1; j<m; j++) dfs(heights, visitedPacific, 0, j, 0);

        boolean[][] visitedAtlantic = new boolean[n][m];
        for(int i=0; i<n; i++) dfs(heights, visitedAtlantic, i, m-1, 0);
        for(int j=0; j<m-1; j++) dfs(heights, visitedAtlantic, n-1, j, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevVal) {
        int n = heights.length;
        int m = heights[0].length;

        if(i<0 || j<0 || i>=n || j>=m || heights[i][j] < prevVal) return;
        if(visited[i][j]) return;

        visited[i][j] = true;

        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
    }
}
