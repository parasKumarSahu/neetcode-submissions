
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] p: prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] curr = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(dfsIsCyclic(i, adj, visited, curr)) return false;
            }

        }

        return true;
    }

    private boolean dfsIsCyclic(
        int i, List<List<Integer>> adj, boolean[] visited, boolean[] curr) {
        if(curr[i]) return true;

        curr[i] = true;

        for(int n: adj.get(i)) {
            if(!visited[n]) {
                if(dfsIsCyclic(n, adj, visited, curr)) return true;
            }
        }

        curr[i] = false; //revert before backtracking from current dfs branch
        visited[i] = true;

        return false;
    }
}
