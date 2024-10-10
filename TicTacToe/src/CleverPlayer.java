public class CleverPlayer implements Player{

    public boolean playTurn(Board board, Mark mark) {
        for (int i = 0 ; i < Board.SIZE ; i ++){
            for (int j = 0 ; j < Board.SIZE ; j ++){
                if(board.putMark(mark, i , j))
                    return true;
            }
        }
        return false;
    }
}
