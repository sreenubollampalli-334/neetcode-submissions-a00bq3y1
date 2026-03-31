class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initialize parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return e; // 🔥 cycle edge found
            }

            union(u, v);
        }

        return new int[0];
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        parent[pu] = pv;
    }
}