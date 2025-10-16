package Arrays.Medium;

import java.util.Arrays;

public class setMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 0},
            {1, 1, 1}
        };

        setZero(arr);
    }

    public static void setZero(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        // First pass: mark rows and columns that need to be zeroed
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Second pass: set zeros based on markers
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }

        // Print the result
        for (int[] x : arr) {
            System.out.println(Arrays.toString(x));
        }
    }
}