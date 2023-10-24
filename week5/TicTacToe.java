package week5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static char[][] board;

    public TicTacToe(char[][] board) {
        TicTacToe.board = board;
    }
    //checkRow method
    public boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    //checkColumn method
    public boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }
    //checkDiagonal method
    public boolean checkDiagonal() {
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }
    //check if player win on diagonal, row or column
    public boolean checkWin() {
        return (checkRow() || checkColumn() || checkDiagonal());
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', 'X' },
                         { EMPTY, 'X', 'O' },
                           { 'O', EMPTY, 'O' } };
        TicTacToe game = new TicTacToe(board);
        if (game.checkWin()) {
            System.out.println("Player X has won");
        } else {
            System.out.println("No one win");
        }
    }
}
