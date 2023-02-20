class Solution {
    public boolean isTrue(char[][] board,int row,int col,char target) {
        for(int i = 0;i < 9;i++) {
            if(i == col) {
                continue;
            }
            if(board[row][i] == target) {
                return false;
            }
        }
        for(int i =0 ;i < 9;i++) {
            if(i == row) {
                continue;
            }
            if(board[i][col] == target) {
                return false;
            }
        }
        int start_x = row - row%3;
        int start_y = col - col%3;
        for(int i  = start_x;i <= (start_x + 2);i++) {
            for(int j = start_y; j <= (start_y + 2);j++) {
                if(i == row && j == col) {
                    continue;
                }
                if(board[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0;i < 9;i++) {
            for(int j =0;j < 9;j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!this.isTrue(board,i,j,board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
