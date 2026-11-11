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
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // Record every row and column that contains an original zero.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // A zero marks both its row and its column.
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }

        // Apply the stored row and column markers to the matrix.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // A cell becomes zero when its row or column was marked.
                if (zeroRows[row] || zeroCols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
    // Prints the matrix rows.
    private static void printMatrix(int[][] matrix) {
        // Print each row on a separate line.
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
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

    
}
