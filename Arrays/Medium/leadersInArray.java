package Arrays.Medium;

import java.util.Arrays;

public class leadersInArray {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2]; // store value and original index
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        // sort based on values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];
            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // if no pair found
    }

    // for testing
    public static void main(String[] args) {
        leadersInArray obj = new leadersInArray();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
