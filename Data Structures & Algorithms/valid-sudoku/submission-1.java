

class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {

            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for(int j = 0; j < 9; j++) {

                // Row check
                if(board[i][j] != '.') {
                    if(!row.add(board[i][j])) return false;
                }

                // Column check
                if(board[j][i] != '.') {
                    if(!col.add(board[j][i])) return false;
                }

                // Box check
                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;

                if(board[r][c] != '.') {
                    if(!box.add(board[r][c])) return false;
                }
            }
        }

        return true;
    }
}