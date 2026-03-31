

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

     Node dfs(Node node, Map<Node, Node> map){
        
        // FIX 1: return cloned node
        if(map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        // FIX 2: Node instead of int
        for(Node nei : node.neighbors){
            
            // FIX 3: pass map
            clone.neighbors.add(dfs(nei, map));
        }

        return clone;
    }
}