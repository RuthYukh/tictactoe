/**
 * class of tournament
 * represents a tournament with two types of players, number of rounds and a given renderer.
 * @author Ruth Yukhnovetsky
 */

public class Tournament {

    private int rounds;
    private Renderer renderer;
    private Player[] players;

    /**
     * constructor of tournament
     * @param rounds number of rounds to play
     * @param renderer given render
     * @param players array of given players
     */
    public Tournament(int rounds, Renderer renderer, Player[] players){
        this.rounds = rounds;
        this.renderer = renderer;
        this.players = players;
    }

    /**
     * Plays a game as many times as given rounds number,
     * prints the result at the end.
     */
    public void playTournament(){

        int numberOfDraw = 0, numberOfWinsPlayer1 = 0, numberOfWinsPlayer2 = 0;
        for (int numOfRound = 1 ; numOfRound <= rounds ; numOfRound ++){
            Game game = new Game(players[numOfRound % 2], players[(numOfRound+1) % 2], renderer);
            Mark currWinner = game.run();
            if (currWinner == Mark.X){
                 if (numOfRound % 2 == 0){
                     numberOfWinsPlayer1 ++;
                 }
                 else {
                     numberOfWinsPlayer2++;
                 }
            }
            if (currWinner == Mark.O){
                if ((numOfRound+1) % 2 == 0){
                    numberOfWinsPlayer1 ++;
                }
                else {
                    numberOfWinsPlayer2++;
                }
            }
            if (currWinner == Mark.BLANK){
                numberOfDraw++;
            }
        }
        System.out.println("Number of wins for player1 = " + numberOfWinsPlayer1 +
                ", number of wins for player2 = " + numberOfWinsPlayer2 +
                ", number of draws: " + numberOfDraw + ".");
    }


    public static void main (String[] args){
        PlayerFactory playerFactory = new PlayerFactory();
        RendererFactory rendererFactory = new RendererFactory();
        int rounds = Integer.parseInt(args[0]);
        Renderer renderer = rendererFactory.buildRenderer(args[1]);
        Player player1 = playerFactory.buildPlayer(args[2]);
        Player player2 = playerFactory.buildPlayer(args[3]);
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        Tournament tournament = new Tournament(rounds, renderer, players);
        tournament.playTournament();
    }
}

