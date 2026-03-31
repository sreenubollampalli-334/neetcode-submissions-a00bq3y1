class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int maxarea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&vis[i][j]==0){
                    int area=dfs(i,j,grid,vis);
                    maxarea=Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
        
    }
    static int dfs(int row,int col,int grid[][],int vis[][]){
        vis[row][col]=1;
        int area=1;
         int n=grid.length;
        int m=grid[0].length;
        int delrow[]={0,-1,0,1};
        int delcol[]={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1&&vis[nr][nc]==0){
                area+=dfs(nr,nc,grid,vis);
            }
        }
        return area;
    }
}
