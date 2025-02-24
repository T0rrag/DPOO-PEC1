package edu.uoc.pac1;

public class PAC1Ex3 {

    public static int MAX_ROWS = 6;
    public static int MAX_COLUMNS = 7;

    public static boolean isValidColumn(char[][] board, int column) {
        //CHECK FOR EMPTY COLUMN
        if (column < 0 || column >= MAX_COLUMNS) {
            return false;
        }

        //CHECK FOR FREE SPACE
        return board[0][column] == ' ';

        //ELSE = VALID SPOT
    }

    public static void printBoard(char[][] board) {
        //CHECK ALL ROWS
        for (int i = 0; i < MAX_ROWS; i++) {
            //CHECK ALL COLUMNS IN THAT ROW
            for (int j = 0; j < MAX_COLUMNS; j++) {
                //PRINT
                System.out.print("|" + board[i][j]);
            }
            //NEW LINE
            System.out.println("|");
        }
    }

    public static boolean checkWinHorizontal(char[][] board, char color) {
        //CHECK ALL ROWS
        for (int i = 0; i < MAX_ROWS; i++) {
            //CHECK ALL COLUMNS
            for (int j = 0; j < MAX_COLUMNS - 4; j++) {
                //CHECK FOR 4 MATCH
                if (board[i][j] == color && board[i][j + 1] == color && board[i][j + 2] == color && board[i][j + 3] == color) {
                    //IF MATCH = VICTORY
                    return true;
                }
            }
        }
        //IF NO MATCH = LOSE
        return false;
    }

    public static boolean checkWinVertical(char[][] board, char color) {
        //CHECK ALL COLUMNS
        for (int i = 0; i < MAX_COLUMNS; i++) {
            //CHECK ALL ROWS
            for (int j = 0; j < MAX_ROWS - 3; j++) {
                //CHECK FOR 4 MATCH VERTICALLY
                if (board[j][i] == color && board[j + 1][i] == color && board[j + 2][i] == color && board[j + 3][i] == color) {
                    //IF MATCH = VICTORY
                    return true;
                }
            }
        }
        //IF NO MATCH = LOSE
        return false;
    }


    public static boolean checkWinDiagonal(char[][] board, char color) {
        // METHOD: DESCENT DIAG - TOP/DOWN, LEFT/RIGHT

        // ROW LIMIT
        for (int i = 0; i < MAX_ROWS - 3; i++) {
            // COLUMN LIMIT
            for (int j = 0; j < MAX_COLUMNS - 3; j++) {
                // CHECK FOR MATCH
                if (board[i][j] == color &&
                        board[i + 1][j + 1] == color &&
                        board[i + 2][j + 2] == color &&
                        board[i + 3][j + 3] == color) {
                    // IF MATCH FOUND = VICTORY
                    return true;
                }
            }
        }

        // METHOD: CRESCENT DIAG - DOWN/TOP, LEFT/RIGHT

        // ROW LIMIT
        for (int i = 3; i < MAX_ROWS; i++) {
            // COLUMN LIMIT
            for (int j = 0; j < MAX_COLUMNS - 3; j++) {

                // CHECK FOR MATCH
                if (board[i][j] == color &&
                        board[i - 1][j + 1] == color &&
                        board[i - 2][j + 2] == color &&
                        board[i - 3][j + 3] == color) {
                    // IF MATCH FOUND = VICTORY
                    return true;
                }
            }
        }

        // IF NO MATCH FOUND = LOSE
        return false;
    }


    public static boolean checkWin(char[][] board, char color) {
        // CHECK FOR MATCHES IN ROWS
        if (checkWinHorizontal(board, color)) {
            return true;
        }

        //CHECK FOR MATCHES IN COLUMNS
        if (checkWinVertical(board, color)) {
            return true;
        }

        //CHECK FOR DIAGONAL MATCHES
        return checkWinDiagonal(board, color);

        //ELSE = LOSE
    }


    public static char[][] dropPiece(char[][] board, int column, char color) {
    // CHECK FOR VALID COLMN
        if (!isValidColumn(board, column)) {
            System.out.println("This column is invalid or full.");
            return board;
        }

        // DOWN-TOP SEARCH FOR EMPTY SPOTS
        for (int row = MAX_ROWS - 1; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = color;
                // WHEN EMPTY BREAK TO PLACE PIECE
                break;
            }
        }

        // PRINT BOARD AFTER PLACEMENT
        printBoard(board);

        // WINNER CHECK
        if (checkWin(board, color)) {
            System.out.println("Color " + color + " wins!");
        }

        return board;
    }
}