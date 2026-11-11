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
        int[][] original = new int[rows][cols];

        // Copy every original value before any mutation happens.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                original[row][col] = matrix[row][col];
            }
        }

        // Original zeros must be read from the unchanged copy.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Only zeros present in the original matrix trigger clearing.
                if (original[row][col] == 0) {
                    // Clear the entire affected row in the real matrix.
                    for (int c = 0; c < cols; c++) {
                        matrix[row][c] = 0;
                    }

                    // Clear the entire affected column in the real matrix.
                    for (int r = 0; r < rows; r++) {
                        matrix[r][col] = 0;
                    }
                }
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