import java.util.Random;

/**
 * Represents a player who randomly puts mark.
 * @author Ruth Yukhnovetsky
 */
public class WhateverPlayer implements Player{

    /**
     * plays whatever's turn in a random manner
     * @param board given board
     * @param mark the player's mark
     * @return true when mark is put.
     */
    public boolean playTurn(Board board, Mark mark) {
        Random rand = new Random();
        int row = rand.nextInt(Board.SIZE);
        int col = rand.nextInt(Board.SIZE);

        while (!board.putMark(mark, row, col)){
            row = rand.nextInt(Board.SIZE);
            col = rand.nextInt(Board.SIZE);
        }
        return true;
    }
}
