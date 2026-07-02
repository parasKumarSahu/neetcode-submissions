class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        int[] size = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] e: edges) {
            int a = find(parent, e[0]-1);
            int b = find(parent, e[1]-1);

            if(a == b) return e;
            else union(parent, size, a, b);

        }

        return new int[0];
    }

    private int find(int[] parent, int i) {
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    private int union(int[] parent, int[] size, int a, int b) {
        if(size[a] > size[b]) {
            parent[b] = a;
            size[a] += size[b];
            return a;
        } else {
            parent[a] = b;
            size[b] += size[a];
            return b;
        }
    }
}
