import java.util.Arrays;

public class SetMatrixZeroesBetter {

    public static int[][] zeroMatrix(int[][] matrix, int n, int m) {
        // Arrays initialized to 0 by default in Java
        int[] row = new int[n];
        int[] col = new int[m];

        // Step 1: Traverse the matrix and mark the row and col arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Update cells to 0 if their row or column is marked
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = zeroMatrix(matrix, n, m);

        for (int[] r : ans) {
            System.out.println(Arrays.toString(r));
        }
    }
}
