class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
        
    }
    static boolean dfs(char[][] board, String word,int i,int j,int ind){
            if (ind == word.length()) return true;
           int n=board.length;
        int m=board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(ind)) {
            return false;
        }

        char temp=board[i][j];
        board[i][j]='*';
        boolean found= dfs(board,word,i-1,j,ind+1)||
        dfs(board,word,i+1,j,ind+1)||
        dfs(board,word,i,j-1,ind+1)||
        dfs(board,word,i,j+1,ind+1);
        board[i][j]=temp;
        return found;

    }
}
