/*

0 - 1 - 2 - 3
     \-----/
      \
       4

*/



class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = getAdj(n, edges);
        Set<Integer> visited = new HashSet<>();

        return dfs(adj, visited, 0, -1) && visited.size() == n;
    }

    private boolean dfs(
        List<List<Integer>> adj, Set<Integer> visited, int curr, int prev) {

        visited.add(curr);
        boolean ans = true;

        for(int neigh: adj.get(curr)) {
            if(visited.contains(neigh) && neigh != prev) return false;
            if(visited.contains(neigh) && neigh == prev) continue;

            ans &= dfs(adj, visited, neigh, curr);
        }

        return ans;
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
