
    import java.util.Scanner;

// not my own work
    public class TicTacToeSimple {
        // Declare a 3x3 array to represent the game board
        static char[][] board = new char[3][3];

        public static void main(String[] args) {
            // Initialize the board with empty spaces
            initializeBoard();

            // Variable to keep track of the current player ('X' or 'O')
            char currentPlayer = 'X';

            // Variable to check if the game is won or drawn
            boolean gameWon = false;
            boolean draw = false;

            // Create a Scanner object for input
            Scanner scanner = new Scanner(System.in);

            // Main game loop, runs until a player wins, or it's a draw
            while (!gameWon && !draw) {
                printBoard();  // Display the board
                System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3):");

                // Get player input for row and column
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                // Check if the selected cell is empty
                if (board[row][col] == ' ') {
                    // Place the current player's mark on the board
                    board[row][col] = currentPlayer;

                    // Check if the current player has won the game
                    gameWon = checkWin(currentPlayer);

                    if (!gameWon) {
                        // Check if the board is full (draw)
                        draw = checkDraw();

                        // Switch the player if the game isn't won
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Cell is already occupied! Try again.");
                }
            }

            // Display the final board
            printBoard();

            // Display game result
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            // Close the scanner
            scanner.close();
        }

        // Function to initialize the board with empty spaces
        public static void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        // Function to print the current state of the board
        public static void printBoard() {
            System.out.println("  1 2 3");
            for (int i = 0; i < 3; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
                if (i < 2) System.out.println("  -----");
            }
        }

        // Function to check if the current player has won
        public static boolean checkWin(char player) {
            // Check rows, columns, and diagonals
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    return true;
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                    return true;
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                return true;
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
                return true;
            return false;
        }

        // Function to check if the board is full (indicating a draw)
        public static boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;  // If any cell is empty, it's not a draw
                    }
                }
            }
            return true;  // If no empty cells, it's a draw
        }
    }


