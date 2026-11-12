import java.util.Arrays;

public class RotateMatrixBy90 {
    // Rotates the square matrix by 90 degrees clockwise.
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        // Place each value at its clockwise-rotated destination.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        // Copy the rotated arrangement back into the original matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotate(matrix);
        printMatrix(matrix);
    }
}
