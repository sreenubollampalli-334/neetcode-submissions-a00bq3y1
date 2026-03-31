class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int fresh=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=2;
                   

                }
                if(grid[i][j]==1) fresh++;

            }
        }
        int time=0;
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().time;
            q.poll();
            time=Math.max(t,time);
            int delrow[]={0,-1,0,1};
            int delcol[]={-1,0,1,0};
            for(int i=0;i<4;i++){
                int nr=row+delrow[i];
                int nc=col+delcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&grid[nr][nc]==1){
                    q.offer(new pair(nr,nc,t+1));
                    cnt++;
                    vis[nr][nc]=1;
                }
            }
        }
        if(fresh!=cnt) return -1;
        return time;
        
    }
}
class pair{
    int row;
    int col;
    int time;
    pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

