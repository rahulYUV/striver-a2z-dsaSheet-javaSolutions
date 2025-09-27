package Arrays.Medium;

import java.util.Arrays;

/**
 * Sort012 - A utility class for sorting arrays containing only 0s, 1s, and 2s.
 * 
 * This class provides two different approaches to solve the Dutch National Flag problem:
 * 1. Counting Sort Approach: O(n) time complexity, O(1) space complexity
 * 2. Dutch National Flag Algorithm: O(n) time complexity, O(1) space complexity (single pass)
 * 
 * The Dutch National Flag problem is a classic computer science problem where we need to
 * sort an array containing only three distinct values (0, 1, 2) in a single pass.
 * 
 * @author Rahul kumar
 * @version 1.0
 * @since 2025
 */
public class Sort012 {

    /**
     * Main method to demonstrate the Sort012 functionality with comprehensive test cases.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Sort012 Test Suite ===\n");
        
        // Test Case 1: Basic functionality
        testCase1();
        
        // Test Case 2: All zeros
        testCase2();
        
        // Test Case 3: All ones
        testCase3();
        
        // Test Case 4: All twos
        testCase4();
        
        // Test Case 5: Single element
        testCase5();
        
        // Test Case 6: Empty array
        testCase6();
        
        // Test Case 7: Already sorted
        testCase7();
        
        // Test Case 8: Reverse sorted
        testCase8();
        
        // Test Case 9: Large array
        testCase9();
        
        // Test Case 10: Edge case with null array
        testCase10();
    }

    /**
     * Test Case 1: Basic functionality with mixed elements
     */
    private static void testCase1() {
        System.out.println("Test Case 1: Basic functionality");
        int[] arr = {0, 1, 2, 0, 1, 2};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy1 = arr.clone();
        int[] arrCopy2 = arr.clone();
        
        sortByCounting(arrCopy1);
        sortByDutchNationalFlag(arrCopy2);
        
        System.out.println("After counting sort: " + Arrays.toString(arrCopy1));
        System.out.println("After Dutch National Flag: " + Arrays.toString(arrCopy2));
        System.out.println("✓ Both methods produce the same result\n");
    }

    /**
     * Test Case 2: Array with all zeros
     */
    private static void testCase2() {
        System.out.println("Test Case 2: All zeros");
        int[] arr = {0, 0, 0, 0};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ All zeros remain in place\n");
    }

    /**
     * Test Case 3: Array with all ones
     */
    private static void testCase3() {
        System.out.println("Test Case 3: All ones");
        int[] arr = {1, 1, 1, 1};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ All ones remain in place\n");
    }

    /**
     * Test Case 4: Array with all twos
     */
    private static void testCase4() {
        System.out.println("Test Case 4: All twos");
        int[] arr = {2, 2, 2, 2};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ All twos remain in place\n");
    }

    /**
     * Test Case 5: Single element array
     */
    private static void testCase5() {
        System.out.println("Test Case 5: Single element");
        int[] arr = {1};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ Single element remains unchanged\n");
    }

    /**
     * Test Case 6: Empty array
     */
    private static void testCase6() {
        System.out.println("Test Case 6: Empty array");
        int[] arr = {};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ Empty array remains empty\n");
    }

    /**
     * Test Case 7: Already sorted array
     */
    private static void testCase7() {
        System.out.println("Test Case 7: Already sorted");
        int[] arr = {0, 0, 1, 1, 2, 2};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ Already sorted array remains unchanged\n");
    }

    /**
     * Test Case 8: Reverse sorted array
     */
    private static void testCase8() {
        System.out.println("Test Case 8: Reverse sorted");
        int[] arr = {2, 2, 1, 1, 0, 0};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        int[] arrCopy = arr.clone();
        sortByDutchNationalFlag(arrCopy);
        System.out.println("After sorting: " + Arrays.toString(arrCopy));
        System.out.println("✓ Reverse sorted array is now properly sorted\n");
    }

    /**
     * Test Case 9: Large array performance test
     */
    private static void testCase9() {
        System.out.println("Test Case 9: Large array (1000 elements)");
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3); // Random 0, 1, or 2
        }
        System.out.println("Array length: " + arr.length);
        
        int[] arrCopy = arr.clone();
        long startTime = System.nanoTime();
        sortByDutchNationalFlag(arrCopy);
        long endTime = System.nanoTime();
        
        System.out.println("Sorting completed in: " + (endTime - startTime) / 1_000_000.0 + " ms");
        System.out.println("✓ Large array sorted successfully\n");
    }

    /**
     * Test Case 10: Null array handling
     */
    private static void testCase10() {
        System.out.println("Test Case 10: Null array handling");
        try {
            sortByDutchNationalFlag(null);
            System.out.println("✗ Should have thrown an exception for null array");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly handled null array: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Counting Sort Approach: Counts the number of 0s, 1s, and 2s, then reconstructs the array.
     * 
     * Algorithm:
     * 1. Count the occurrences of 0, 1, and 2 in the array
     * 2. Reconstruct the array by placing 0s first, then 1s, then 2s
     * 
     * Time Complexity: O(n) - Two passes through the array
     * Space Complexity: O(1) - Only using constant extra space for counters
     * 
     * @param arr the input array containing only 0s, 1s, and 2s
     * @throws IllegalArgumentException if array is null or contains invalid elements
     */
    public static void sortByCounting(int[] arr) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        // Edge case: empty array or single element
        if (arr.length <= 1) {
            return;
        }
        
        // Count occurrences of 0, 1, and 2
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int element : arr) {
            if (element == 0) {
                count0++;
            } else if (element == 1) {
                count1++;
            } else if (element == 2) {
                count2++;
            } else {
                throw new IllegalArgumentException("Array contains invalid element: " + element + 
                    ". Only 0, 1, and 2 are allowed.");
            }
        }
        
        // Reconstruct the array
        int index = 0;
        
        // Place all 0s
        for (int i = 0; i < count0; i++) {
            arr[index++] = 0;
        }
        
        // Place all 1s
        for (int i = 0; i < count1; i++) {
            arr[index++] = 1;
        }
        
        // Place all 2s
        for (int i = 0; i < count2; i++) {
            arr[index++] = 2;
        }
    }

    /**
     * Dutch National Flag Algorithm: Optimal single-pass solution using three pointers.
     * 
     * Algorithm:
     * 1. Initialize three pointers: low (0), mid (0), high (n-1)
     * 2. Use mid pointer to traverse the array
     * 3. If arr[mid] == 0: swap with low, increment both low and mid
     * 4. If arr[mid] == 1: increment mid (1 is in correct position)
     * 5. If arr[mid] == 2: swap with high, decrement high (don't increment mid)
     * 6. Continue until mid > high
     * 
     * Time Complexity: O(n) - Single pass through the array
     * Space Complexity: O(1) - Only using constant extra space
     * 
     * @param arr the input array containing only 0s, 1s, and 2s
     * @throws IllegalArgumentException if array is null or contains invalid elements
     */
    public static void sortByDutchNationalFlag(int[] arr) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        // Edge case: empty array or single element
        if (arr.length <= 1) {
            return;
        }
        
        // Initialize three pointers
        int low = 0;    // Points to the boundary of 0s and 1s
        int mid = 0;    // Current element being processed
        int high = arr.length - 1;  // Points to the boundary of 1s and 2s
        
        // Process array until mid crosses high
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Current element is 0, swap with low boundary
                swap(arr, low, mid);
                low++;  // Expand 0s region
                mid++;  // Move to next element
            } else if (arr[mid] == 1) {
                // Current element is 1, it's in correct position
                mid++;  // Just move to next element
            } else if (arr[mid] == 2) {
                // Current element is 2, swap with high boundary
                swap(arr, mid, high);
                high--; // Expand 2s region
                // Don't increment mid, as we need to check the swapped element
            } else {
                throw new IllegalArgumentException("Array contains invalid element: " + arr[mid] + 
                    ". Only 0, 1, and 2 are allowed.");
            }
        }
    }

    /**
     * Utility method to swap two elements in an array.
     * 
     * @param arr the array containing the elements to swap
     * @param i the index of the first element
     * @param j the index of the second element
     * @throws IllegalArgumentException if array is null or indices are out of bounds
     */
    private static void swap(int[] arr, int i, int j) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IllegalArgumentException("Index out of bounds: i=" + i + ", j=" + j + 
                ", array length=" + arr.length);
        }
        
        // Swap elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Validates that an array is properly sorted according to the Dutch National Flag problem.
     * 
     * @param arr the array to validate
     * @return true if the array is properly sorted, false otherwise
     */
    public static boolean isValidSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        // Find the first occurrence of each value
        int first1 = -1, first2 = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && first1 == -1) {
                first1 = i;
            } else if (arr[i] == 2 && first2 == -1) {
                first2 = i;
            }
        }
        
        // Check if all 0s come before all 1s, and all 1s come before all 2s
        if (first1 != -1 && first2 != -1) {
            return first1 < first2;
        }
        
        return true;
    }
}
