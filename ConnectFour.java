import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    private static char[][] board = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();
        char currentPlayer = PLAYER_ONE;

        boolean gameEnded = false;
        while (!gameEnded) {
            int column = getColumn(currentPlayer);
            dropDisc(currentPlayer, column);
            displayBoard();
            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("The board is full. It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println();
    }

    private static int getColumn(char player) {
        Scanner scanner = new Scanner(System.in);
        int column;
        while (true) {
            System.out.print("Player " + player + ", choose a column (1-7): ");
            column = scanner.nextInt();
            if (column < 1 || column > COLUMNS || board[0][column - 1] != EMPTY) {
                System.out.println("Invalid column. Please try again.");
            } else {
                break;
            }
        }
        return column - 1;
    }

    private static void dropDisc(char player, int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = player;
                break;
            }
        }
    }

    private static boolean checkWin(char player) {
        // Check horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        // Check diagonal (bottom-left to top-right)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check diagonal (top-left to bottom-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
