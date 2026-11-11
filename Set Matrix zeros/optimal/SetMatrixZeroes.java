
import java.util.Arrays;

public class SetMatrixZeroes {
    // Updates the matrix after zeroing affected rows and columns.
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;

        // An empty matrix has no row or column to update.
        if (rows == 0) {
            return;
        }

        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check whether the first row must be cleared later.
        for (int col = 0; col < cols; col++) {
            // A zero in the first row must be remembered before markers change it.
            if (matrix[0][col] == 0) {
                firstRowZero = true;
            }
        }

        // Check whether the first column must be cleared later.
        for (int row = 0; row < rows; row++) {
            // A zero in the first column must be remembered before markers change it.
            if (matrix[row][0] == 0) {
                firstColZero = true;
            }
        }

        // Store row and column markers inside the first row and first column.
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                // An inner zero marks its whole row and column.
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Apply markers to the inner part of the matrix.
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                // A zero row marker or column marker clears this cell.
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // The saved first-row status decides whether the first row is cleared.
        if (firstRowZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        // The saved first-column status decides whether the first column is cleared.
        if (firstColZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 0, 4},
            {5, 6, 7, 8},
            {9, 0, 11, 12},
            {13, 14, 15, 16}
        };

        // instance for class Solution
        setZeroes(matrix);
        printMatrix(matrix);
    }

    // Prints the matrix rows.
    private static void printMatrix(int[][] matrix) {
        // Print each row on a separate line.
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}