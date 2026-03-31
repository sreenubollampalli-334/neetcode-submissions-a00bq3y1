

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // Build graph (b → a)
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] path = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        // DFS on all nodes
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, path, st)) {
                    return new int[0]; // cycle found
                }
            }
        }

        // Build result from stack
        int[] res = new int[numCourses];
        int idx = 0;

        while (!st.isEmpty()) {
            res[idx++] = st.pop();
        }

        return res;
    }

    static boolean dfs(int node, List<List<Integer>> adj,
                       int[] vis, int[] path, Stack<Integer> st) {

        vis[node] = 1;
        path[node] = 1;

        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                if (dfs(nei, adj, vis, path, st)) return true;
            } 
            else if (path[nei] == 1) {
                return true; // cycle detected
            }
        }

        path[node] = 0;   // 🔥 backtrack
        st.push(node);    // add after DFS

        return false;
    }
}