class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int ind = board[i][j] - '1';
                int b = i/3 * 3+ j/3;
                if(row[i][ind]==1||col[j][ind]==1||box[b][ind]==1) return false;
                row[i][ind] = 1;
                col[j][ind] = 1;
                box[b][ind] = 1;
            }
        }
        return true;
    }
}