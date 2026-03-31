class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        // ✅ Step 1: Cycle detection
        if (dfsCycle(0, -1, vis, adj)) return false;

        // ✅ Step 2: Connectivity check
        for (boolean v : vis) {
            if (!v) return false;
        }

        return true;
    }

    boolean dfsCycle(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                if (dfsCycle(nei, node, vis, adj)) return true;
            } 
            else if (nei != parent) {
                return true; // cycle found
            }
        }
        return false;
    }
}