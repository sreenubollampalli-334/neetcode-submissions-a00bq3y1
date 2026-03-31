class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int vis[]=new int[numCourses];
        int path[]=new int[numCourses];
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
           adj.get(v).add(u);
        }
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,vis,path,adj)) return false;
            }
        }
        return true;
        
    }
    static boolean dfs(int node,int vis[],int path[],List<List<Integer>> adj){
        vis[node]=1;
        path[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,path,adj)) return true;
            }
            else if(path[it]==1) return true;
        }
        path[node]=0;
        return false;
    }

}
