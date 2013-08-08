package games;

/**
 * Tic-Tac-Toe game that supports up to a N x N square.
 *
 * @author jtan
 * @version 8/8/13
 */

public class UltraTicTacToe {
    // Holds internal state of the board. The board is a matrix of -1's, 0's, and 1's.
    // -1 = "O", 0 = null, 1 = "X"
    private int[][] board;
    private int size;

    public UltraTicTacToe(int size) {
        //init board
        this.size = size;
        board = new int[size][size];
    }

    public UltraTicTacToe(int[][] board) {
        if (board == null) throw new NullPointerException();

        //init with preset board
        this.size = board.length;
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Checks to see if there is a winner.
     *
     * @return
     */
    public boolean validateWin() {
        // temporary buffers to hold "state sums" as we iterate through the rows, cols, and diagonals to check for a winner
        int diag1State = 0;
        int diag2State = 0;
        int[] rowState = new int[size];
        int[] colState = new int[size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                // check row: if current row's state sum is 3 or -3, you're a winner!
                int currentRowState = rowState[row] + board[row][col];
                if (Math.abs(currentRowState) == 3) {
                    return true;
                } else {
                    rowState[row] = currentRowState;
                }

                // check col: if current col's state sum is 3 or -3, you're a winner!
                int currentColState = colState[col] + board[col][row];
                if (Math.abs(currentColState) == 3) {
                    return true;
                } else {
                    colState[col] = currentColState;
                }

                // check diags: if current diag's state sum is 3 or -3, you're a winner!
                if (row == col) { // diag1
                    int currentDiag1State = diag1State + board[row][col];
                    if (Math.abs(currentDiag1State) == 3) {
                        return true;
                    } else {
                        diag1State = currentDiag1State;
                    }
                }

                if (row + col == (size - 1)) { // diag2
                    int currentDiag2State = diag2State + board[row][col];
                    if (Math.abs(currentDiag2State) == 3) {
                        return true;
                    } else {
                        diag2State = currentDiag2State;
                    }
                }
            }
        }

        return false;
    }
}
