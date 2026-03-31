class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new pair(grid[0][0],0,0));
        int vis[][]=new int[n][m];
        vis[0][0]=1;
    int delrow[]={1,0,-1,0};
    int delcol[]={0,-1,0,1};
    while(!pq.isEmpty()){
        int dist=pq.peek().distance;
        int row=pq.peek().row;
        int col=pq.peek().col;
        pq.poll();
        if(row==n-1&&col==m-1) return dist;
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0){
                vis[nr][nc]=1;
                pq.offer(new pair(Math.max(dist,grid[nr][nc]),nr,nc));
            }

        }
    }
    return -1;
        
    }
}
class pair{
    int distance;
    int row;
    int col;
    pair(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
