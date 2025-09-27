package Arrays.Medium;

/**
 * TwoSum - A utility class for finding two numbers in a sorted array that sum to a target value.
 * 
 * This class provides two different approaches to solve the Two Sum problem:
 * 1. Brute Force Approach: O(n²) time complexity, O(1) space complexity
 * 2. Two Pointer Approach: O(n) time complexity, O(1) space complexity (optimal for sorted arrays)
 * 
 * @author Rahukl kumar
 * @version 1.0
 * @since 2025
 */
public class TwoSum {

    /**
     * Main method to demonstrate the TwoSum functionality with various test cases.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test case 1: Valid pair exists
        int[] arr1 = {2, 7, 11, 15,2};
        int target1 = 18;
        System.out.println("Test Case 1:");
        System.out.println("Array: [2, 7, 11, 15], Target: " + target1);
        System.out.println("Result: " + twoSumTwoPointer(arr1, target1));
        System.out.println();
        
        // Test case 2: No valid pair exists
        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 10;
        System.out.println("Test Case 2:");
        System.out.println("Array: [1, 2, 3, 4, 5], Target: " + target2);
        System.out.println("Result: " + twoSumTwoPointer(arr2, target2));
        System.out.println();
        
        // Test case 3: Edge case - empty array
        int[] arr3 = {};
        int target3 = 5;
        System.out.println("Test Case 3:");
        System.out.println("Array: [], Target: " + target3);
        System.out.println("Result: " + twoSumTwoPointer(arr3, target3));
        System.out.println();
        
        // Test case 4: Edge case - single element
        int[] arr4 = {5};
        int target4 = 5;
        System.out.println("Test Case 4:");
        System.out.println("Array: [5], Target: " + target4);
        System.out.println("Result: " + twoSumTwoPointer(arr4, target4));
    }

    /**
     * Brute Force Approach: Uses two nested loops to find two numbers that sum to target.
     * 
     * Time Complexity: O(n²) - For each element, we check all remaining elements
     * Space Complexity: O(1) - Only using constant extra space
     * 
     * @param arr the input sorted array
     * @param target the target sum to find
     * @return true if two numbers sum to target, false otherwise
     * @throws IllegalArgumentException if array is null
     */
    public static boolean twoSumBruteForce(int[] arr, int target) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        // Check all possible pairs
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Two Pointer Approach: Optimal solution for sorted arrays.
     * Uses two pointers starting from the beginning and end of the array.
     * 
     * Algorithm:
     * 1. Initialize left pointer at start (0) and right pointer at end (n-1)
     * 2. Calculate sum of elements at both pointers
     * 3. If sum equals target, return true
     * 4. If sum is less than target, move left pointer right (increase sum)
     * 5. If sum is greater than target, move right pointer left (decrease sum)
     * 6. Continue until pointers meet
     * 
     * Time Complexity: O(n) - Each element is visited at most once
     * Space Complexity: O(1) - Only using constant extra space
     * 
     * @param arr the input sorted array (must be sorted in ascending order)
     * @param target the target sum to find
     * @return true if two numbers sum to target, false otherwise
     * @throws IllegalArgumentException if array is null
     */
    public static boolean twoSumTwoPointer(int[] arr, int target) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        // Edge case: array has less than 2 elements
        if (arr.length < 2) {
            return false;
        }
        
        // Initialize two pointers
        int left = 0;
        int right = arr.length - 1;
        
        // Two pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return true;
            } else if (sum < target) {
                // Sum is too small, move left pointer to increase sum
                left++;
            } else {
                // Sum is too large, move right pointer to decrease sum
                right--;
            }
        }
        
        // No pair found
        return false;
    }
}