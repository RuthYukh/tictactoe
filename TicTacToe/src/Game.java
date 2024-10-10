/**
 * Game class - creates a game for two players
 * @author - Ruth Yukhnovetsky
 */

public class Game {

    private Player playerX;
    private Player playerO;
    private Renderer renderer;

    /**
     * creates a game
     * @param playerX player X
     * @param playerO player O
     * @param renderer creating the board
     */
    public Game(Player playerX, Player playerO, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    /**
     * runs a game
     * @return winner of the game
     */
    public Mark run(){
        Board board = new Board();
        this.renderer.renderBoard(board);

        while (!board.gameEnded()) {
            playerX.playTurn(board, Mark.X);
            this.renderer.renderBoard(board);
            if (!board.gameEnded()) {
                playerO.playTurn(board, Mark.O);
                this.renderer.renderBoard(board);
            }
        }
        return board.getWinner();
    }
}