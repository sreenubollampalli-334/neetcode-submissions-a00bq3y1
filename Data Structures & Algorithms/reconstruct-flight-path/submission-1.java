
class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        dfs("JFK");

        return result;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = graph.get(src);

        while(pq != null && !pq.isEmpty()) {
            String next = pq.poll(); // take smallest lexicographically
            dfs(next);
        }

        // add after visiting all edges
        result.add(0, src);
    }
}