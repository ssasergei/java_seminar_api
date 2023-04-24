package seminar2;

import java.util.HashSet;

public class HW_task4 {

    public static void main(String[] args) {
        char[][] validateBoard = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println("Is validate: " + isValidate(validateBoard));

        char[][] invalidateBoard = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '8', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println("Is validate: " + isValidate(invalidateBoard));
    }

   
    private static boolean isValidate(char[][] board) {
        HashSet<Character> set;

        // check rows
        for (int row = 0; row < 9; row++) {
            set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char cell = board[col][row];
                if (cell != '.' && !set.add(cell)) {
                    return false;
                }
            }
        }

        // check cols
        for (int col = 0; col < 9; col++) {
            set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char cell = board[col][row];
                if (cell != '.' && !set.add(cell)) {
                    return false;
                }
            }
        }

        // check blocks
        for (int block = 0; block < 9; block++) {
            set = new HashSet<>();
            int colStart = (block / 3) * 3;
            int rowStart = (block % 3) * 3;
            for (int col = colStart; col < colStart + 3; col++) {
                for (int row = rowStart; row < rowStart + 3; row++) {
                    char c = board[col][row];
                    if (c != '.' && !set.add(c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    
}
