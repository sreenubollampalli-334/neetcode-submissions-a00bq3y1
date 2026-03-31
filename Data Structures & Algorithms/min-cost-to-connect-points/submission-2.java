class Solution {
    int parent[];
    int rank[];
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new ArrayList<>();
        int n=points.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{cost,i,j});

            }
        }
        //sort edges by edge weight
        edges.sort((a,b)->a[0]-b[0]);

        int edgesused=0;
        int mincost=0;
        for(int it[]:edges){
            if(union(it[1],it[2])){
                mincost+=it[0];
                edgesused++;
                if(edgesused==n-1) break;
            }
        }
        return mincost;

        
    }
     boolean union(int a,int b){
        int u=find(a);
        int v=find(b);
        if(u==v) return false;
        if(rank[u]<rank[v]) parent[u]=v;
        else if(rank[v]<rank[u]) parent[v]=u;
        else{
            parent[v]=u;
            rank[u]++;
        }
        return true;

    }
     int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

}
