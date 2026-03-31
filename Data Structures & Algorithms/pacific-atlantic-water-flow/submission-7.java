class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int visp[][]=new int[n][m];
        int visa[][]=new int[n][m];
        Queue<pair> qp=new LinkedList<>();
         Queue<pair> qa=new LinkedList<>();
         for(int i = 0; i < n; i++){
           qp.offer(new pair(i,0));
           visp[i][0]=1;
        }
        for(int j = 0; j < m; j++){
             qp.offer(new pair(0,j));
           visp[0][j]=1;
            
        }
         for(int i = 0; i < n; i++){
            qa.offer(new pair(i, m-1));
            visa[i][m-1] = 1;
        }
        for(int j = 0; j < m; j++){
            qa.offer(new pair(n-1, j));
            visa[n-1][j] = 1;
        }
        bfs(heights,qp,visp);
        bfs(heights,qa,visa);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visp[i][j]==1&&visa[i][j]==1) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;

        
    }
     void bfs(int grid[][], Queue<pair> q,int vis[][]){
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            int delrow[]={0,-1,0,1};
            int delcol[]={-1,0,1,0};
            for(int i=0;i<4;i++){
                int nr=row+delrow[i];
                int nc=col+delcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&grid[nr][nc]>=grid[row][col]){
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
