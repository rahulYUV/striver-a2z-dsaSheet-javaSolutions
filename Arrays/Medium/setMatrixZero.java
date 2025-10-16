package Arrays.Medium;

import java.util.Arrays;

public class setMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 0},
            {1, 1, 1}
        };

        // Using extra space approach
        System.out.println("Using extra space:");
        setZeroExtraSpace(arr);

        // Resetting array for in-place approach
        int[][] arr2 = {
            {1, 0, 0},
            {1, 1, 1}
        };

        System.out.println("Using in-place optimization:");
        setZeroInPlace(arr2);
    }

    /**
     * Approach 1: Using extra space (row and column markers)
     * Time: O(n * m), Space: O(n + m)
     */
    public static void setZeroExtraSpace(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        // Step 1: Mark rows and columns that contain zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Set elements to zero based on markers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 3: Print the result
        for (int[] x : arr) {
            System.out.println(Arrays.toString(x));
        }
    }

    /**
     * ✅ Approach 2: Optimized in-place solution using first row and column as markers
     * Time: O(n * m), Space: O(1)
     */
    public static void setZeroInPlace(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col0 = false;

        // Step 1: Use first row and column as markers
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark column
                }
            }
        }

        // Step 2: Traverse in reverse to avoid overwriting markers
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) matrix[i][0] = 0;
        }

        // Step 3: Print the result
        for (int[] x : matrix) {
            System.out.println(Arrays.toString(x));
        }
    }
}