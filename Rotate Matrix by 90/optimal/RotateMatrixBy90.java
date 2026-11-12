import java.util.*;

public class RotateMatrixBy90 {
    // Rotates the square matrix by 90 degrees clockwise.
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose the matrix by swapping across the main diagonal.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse every row to complete the clockwise rotation.
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
        
    }

    private static void reverseRow(int[] row) {
            int left = 0;
            int right = row.length - 1;

            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
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
