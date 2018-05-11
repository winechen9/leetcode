public class Design_Tic_Tac_Toc_348 {
    /*
    Design a Tic-tac-toe game that is played between two players on a n x n grid.

    You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
     */

    class TicTacToe {
        int[] rows;
        int[] cols;
        int diagnal;
        int antiDiag;
        int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.rows = new int[n];
            this.cols = new int[n];
            this.diagnal = 0;
            this.antiDiag = 0;
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int add = (player == 1) ? 1 : -1;
            rows[row] += add;
            cols[col] += add;
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n) return player;
            if(row == col){
                diagnal += add;
                if(Math.abs(diagnal) == n) return player;
            }
            if(row == n - col - 1){
                antiDiag += add;
                if(Math.abs(antiDiag) == n) return player;
            }
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
