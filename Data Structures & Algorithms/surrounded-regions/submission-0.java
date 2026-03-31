class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Step 1: Traverse boundaries
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][m-1] == 'O') dfs(i, m-1, board);
        }

        for(int j = 0; j < m; j++) {
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[n-1][j] == 'O') dfs(n-1, j, board);
        }

        // Step 2 & 3: Convert
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X'; // surrounded
                } else if(board[i][j] == 'S') {
                    board[i][j] = 'O'; // safe
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // boundary check
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'S'; // mark safe

        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
}