

class Solution {

    class Pair {
        int node, dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Create graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : times){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        // Step 3: Min Heap (node, distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        pq.offer(new Pair(k, 0));
        dist[k] = 0;

        // Step 4: Dijkstra
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;

            for(int[] it : adj.get(node)){
                int next = it[0];
                int weight = it[1];

                if(d + weight < dist[next]){
                    dist[next] = d + weight;
                    pq.offer(new Pair(next, dist[next]));
                }
            }
        }

        // Step 5: Find answer
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}