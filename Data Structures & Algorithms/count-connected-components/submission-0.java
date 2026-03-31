class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;

    }
    static void dfs(int node,int vis[],List<List<Integer>>adj){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0) dfs(it,vis,adj);
        }
    }
}
