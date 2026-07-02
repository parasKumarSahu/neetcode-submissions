class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = getAdj(times, n);

        int[] dist = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;

        //(dist, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        pq.add(new int[]{0, k-1});

        while(!pq.isEmpty()) {
            int[] finalNode = pq.poll();
            int i = finalNode[1];
            int d = finalNode[0];
            dist[i] = Math.min(dist[i], d);

            for(int[] neigh: adj.get(i)) {
                if(dist[neigh[0]] > dist[i]+neigh[1]) {
                    dist[neigh[0]] = dist[i]+neigh[1];
                    pq.add(new int[]{dist[i]+neigh[1], neigh[0]});
                }
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++) {
            if(ans < dist[i]) ans = dist[i];
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // node -> [(node, dist)  ]
    private List<List<int[]>> getAdj(int[][] times, int n) {
        List<List<int[]>> adj = new ArrayList();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] t: times) {
            adj.get(t[0]-1).add(new int[]{t[1]-1, t[2]});
        }

        return adj;
    }
}
