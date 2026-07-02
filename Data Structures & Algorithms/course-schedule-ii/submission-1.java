class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> adj = getAdjList(numCourses, prerequisites);

        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            for(int neigh: adj.get(i)) {
                inDegree[neigh] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
         
        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for(int neigh: adj.get(curr)) {
                inDegree[neigh] -= 1;
                if(inDegree[neigh] == 0) q.add(neigh);
            }      
        }

        if(ans.size() == numCourses)
            return ans.stream().mapToInt(Integer::intValue).toArray();
        else return new int[0];
    }

    private List<List<Integer>> getAdjList(
        int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p: prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        return adj;
    }
}
