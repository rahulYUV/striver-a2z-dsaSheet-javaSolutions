public class fourthOct {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(sol.maxArea(height)); // Expected output: 49
    }
}

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            ans = Math.max(ans, minHeight * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return ans;
    }
}
