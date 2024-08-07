import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        // Use try-with-resources to ensure the Scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            while (!gameOver) {
                printBoard(board);
                System.out.println("Player " + player + ", enter row and column: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ') {
                    System.out.println("Invalid move. Try again!");
                } else {
                    board[row][col] = player;
                    gameOver = haveWon(board, player); // place the element
                    if (gameOver) {
                        printBoard(board);
                        System.out.println("Player " + player + " has won!");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                }
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check the diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }
}
