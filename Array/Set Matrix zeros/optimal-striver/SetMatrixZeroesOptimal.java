import java.util.Arrays;

public class SetMatrixZeroesOptimal {

    public static int[][] zeroMatrix(int[][] matrix, int n, int m) {
        // int[] col = new int[m]; -> tracked using matrix[0][..]
        // int[] row = new int[n]; -> tracked using matrix[..][0]
        int col0 = 1;

        // Step 1: Traverse the matrix and mark the 1st row & 1st col accordingly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the i-th row
                    matrix[i][0] = 0;

                    // Mark the j-th column
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Update the inner submatrix from (1, 1) to (n - 1, m - 1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // Check for col & row markers
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Finally update the 1st row and then the 1st column
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = zeroMatrix(matrix, n, m);

        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
