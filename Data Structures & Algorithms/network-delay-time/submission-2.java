class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        pq.offer(new pair(0, k));
        dist[k] = 0;

        // Build graph
        for (int e[] : times) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];
            adj.get(u).add(new int[]{v, cost});
        }

        // Dijkstra
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int currDist = p.dist;
            int node = p.node;

            for (int it[] : adj.get(node)) {
                int adjnode = it[0];
                int edgeweight = it[1];

                if (currDist + edgeweight < dist[adjnode]) {
                    dist[adjnode] = currDist + edgeweight;
                    pq.offer(new pair(dist[adjnode], adjnode));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}

class pair {
    int dist;
    int node;

    pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}