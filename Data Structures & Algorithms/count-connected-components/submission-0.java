class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        List<List<Integer>> adj = getAdj(n, edges);
        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                ans++;
                dfs(adj, visited, i);
            }
        }

        return ans;
    }

    private void dfs(
        List<List<Integer>> adj, Set<Integer> visited, int curr) {

        visited.add(curr);

        for(int neigh: adj.get(curr)) {
            if(visited.contains(neigh)) continue;

            dfs(adj, visited, neigh);
        }
    } 

    private List<List<Integer>> getAdj(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return adj;
    }
}
