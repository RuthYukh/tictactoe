/**
 * Board class - creates a board for the game
 * @author - Ruth Yukhnovetsky
 */

public class Board {
    public static final int SIZE = 6;
    public static final int WIN_STREAK = 4;

    private Mark[][] board = new Mark[SIZE][SIZE];


    /**
     * constructor of board
     */
    public Board() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = Mark.BLANK;
            }
        }
    }

    /**
     * return the mark in given square
     *
     * @param row row coordinate of given square
     * @param col column coordinate of given square
     * @return the mark in given square
     */
    public Mark getMark(int row, int col) {
        if ((row >= SIZE || row < 0) || (col >= SIZE || col < 0)) { // check that coordinates are in scope
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

    private Mark getStatus() {
        //checks status of game - win, in progress or draw
        if (this.checkDiagonalWinning(Mark.X) || this.winningStreakLines(Mark.X)) {
            return Mark.X;
        }
        if (this.winningStreakLines(Mark.O) || this.checkDiagonalWinning(Mark.O)) {
            return Mark.O;
        }
        if (this.getEmptySquaresCount() == 0) {
            return Mark.BLANK;
        }
        return null;
    }

    private boolean winningStreakLines(Mark mark) {
        //check for a streak of row or col
        int countMarkRow = 0, countMarkCol = 0;
        for (int i = 0; i < SIZE; i++) {
            countMarkRow = 0;
            countMarkCol = 0;
            for (int j = 0; j < SIZE; j++) {
                if (getMark(i, j) == mark) {
                    countMarkRow++;
                } else {
                    countMarkRow = 0;
                }
                if (getMark(j, i) == mark) {
                    countMarkCol++;
                } else {
                    countMarkCol = 0;
                }

                if (countMarkCol == WIN_STREAK || countMarkRow == WIN_STREAK) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean winningStreakDiagnalLtR(Mark mark, int i, int j) {
        //check for a streak of diagonal left to right
        int counter = 0;
        while (i < SIZE && j < SIZE) {
            if (getMark(i, j) == mark) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == WIN_STREAK) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    private boolean winningStreakDiagnalRtL(Mark mark, int i, int j) {
        //check for a streak of diagonal right to left
        int counter = 0;
        while (i < SIZE && j < SIZE) {
            if (getMark(i, j) == mark) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == WIN_STREAK) {
                return true;
            }
            i++;
            j--;
        }
        return false;

    }

    private boolean checkDiagonalWinning(Mark mark) {
        //check both diagonals
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (winningStreakDiagnalLtR(mark, i, j) ||
                        winningStreakDiagnalRtL(mark, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getEmptySquaresCount() {
        //counts number of blank squares left
        int count = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == Mark.BLANK) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * put mark in given square if coordinates are legit and square is empty
     *
     * @param mark wanted mark to put
     * @param row  row coordinate
     * @param col  column coordinated
     * @return true if its possible to pur the given mark, false otherwise
     */
    public boolean putMark(Mark mark, int row, int col) {

        if ((row >= SIZE || row < 0) || (col >= SIZE || col < 0)) {
            return false;
        }
        if (this.getMark(row, col) == Mark.BLANK) {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     * returns true if game ended, false otherwise
     *
     * @return true if game ended
     */
    public boolean gameEnded() {
        return this.getStatus() != null;
    }

    /**
     * returns mark of winner
     *
     * @return mark of winner
     */
    public Mark getWinner() {
        if (gameEnded()) {
            switch (this.getStatus()) {
                case X:
                    return Mark.X;
                case O:
                    return Mark.O;
                default:
                    return Mark.BLANK;
            }
        }
        return null;
    }
}
