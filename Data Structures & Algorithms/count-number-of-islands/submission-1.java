class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<pair> q=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    q.offer(new pair(i,j));
                    bfs(grid,vis,q);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
     void bfs(char grid[][],int vis[][],Queue<pair> q){
         int n=grid.length;
        int m=grid[0].length;
        int delrow[]={0,-1,0,1};
        int delcol[]={-1,0,1,0};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nr=row+delrow[i];
                int nc=col+delcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]=='1'&&vis[nr][nc]==0){
                    q.offer(new pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
    }
}
class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
