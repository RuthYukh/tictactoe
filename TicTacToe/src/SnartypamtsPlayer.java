/**
 * Represents a super smart player, who is most likely to win by outsmarting other players.
 * @author Ruth Yukhnovetsky
 */
public class SnartypamtsPlayer implements Player {
    private boolean goRight = true;

    /**
     * plays turn for ms snartypamts.
     * If mark can be put to the right, keep putting marks to the right to achieve a streak.
     * If not, go down.
     * @param board given board
     * @param mark player's mark
     * @return true when mark is put
     */
    public boolean playTurn(Board board, Mark mark) {
        //the strategy is to first put a mark in the middle
        if (board.putMark(mark, (Board.SIZE - 1) / 2, (Board.SIZE - 1) / 2)) {
            return true;
        }

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (goRight && board.putMark(mark, i, j)) {
                    return true;
                } else {
                    goRight = false;
                    if(!board.putMark(mark, j, i)) //go down instead of right
                        goRight = true;
                }
            }
        }
        return false;
    }
}
