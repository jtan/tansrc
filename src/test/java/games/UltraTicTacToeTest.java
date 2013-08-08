package games;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author jtan
 * @version 8/8/13
 */
public class UltraTicTacToeTest {

    @Test
    public void testIsWinner() {
        int[][] board1 = {
                {-1, -1, -1},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] board2 = {
                {0, -1, -1},
                {1, 1, 1},
                {-1, 0, -1}
        };

        int[][] board3 = {
                {0 , 0, 1},
                {0, 1, 1},
                {1, 0, 0}
        };

        int[][] board4 = {
                {-1, 0, 0},
                {0, -1, 0},
                {0, 0, -1}
        };

        int[][] board5 = {
                {-1, 1, -1},
                {1, 1, -1},
                {1, -1, 1}
        };

        UltraTicTacToe game = new UltraTicTacToe(board1);
        assertBoard(game, board1, true);
        assertBoard(game, board2, true);
        assertBoard(game, board3, true);
        assertBoard(game, board4, true);
        assertBoard(game, board5, false);
    }

    private void assertBoard(UltraTicTacToe game, int[][] board, boolean expected) {
        game.setBoard(board);
        Assert.assertEquals(game.validateWin(), expected);
    }
}
