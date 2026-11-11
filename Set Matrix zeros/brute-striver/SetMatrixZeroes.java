import java.util.*;

public class SetMatrixZeroes {
    // Marks all non-zero elements in row i as -1
    private static void markRow(int[][] arr, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    // Marks all non-zero elements in column j as -1
    private static void markCol(int[][] arr, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    // Main function to set zeroes
    public static void zeroMatrix(int[][] arr, int n, int m) {
        // Step 1: Traverse the matrix and mark rows/columns with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, m, i);
                    markCol(arr, n, j);
                }
            }
        }

        // Step 2: Convert all -1 markers into 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        zeroMatrix(matrix, n, m);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}