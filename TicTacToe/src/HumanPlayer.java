import java.util.Scanner;
/**
 * Human player class
 * @author - Ruth Yukhnovetsky
 */

public class HumanPlayer implements Player {

    /**
     * plays a turn for given mark
     * @param board the currently played board
     * @param mark mark of player
     * @return updated board
     */
    public boolean playTurn(Board board, Mark mark){
      while (!tryPlayTurn(board, mark)){
          System.out.println("Wrong coordinates,please try again");
      }
      return true;
    }


    private boolean tryPlayTurn(Board board, Mark mark){
        //asks the user to enter coordinates until valid
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter coordinates of mark");
        String input = scan.nextLine();
        int row = Integer.parseInt("" + input.charAt(0))- 1;
        int col = Integer.parseInt("" + input.charAt(1)) - 1;

        return board.putMark(mark, row, col);
    }

}
