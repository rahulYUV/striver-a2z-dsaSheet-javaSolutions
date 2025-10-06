/**
 * LeetCode Problem: Swim in Rising Water
 * 
 * Given an n x n integer matrix grid where each value grid[i][j] represents 
 * the elevation at that point (i,j), return the least time until you can reach 
 * the bottom right square (n-1, n-1) if you start at the top left square (0, 0).
 * 
 * Solution uses Union-Find (Disjoint Set Union) data structure to efficiently
 * track connectivity between cells as water level rises.
 * 
 * @author rahulYUV
 * @version 1.0
 * @since 2025-10-06
 */
public class sixOct {
    
    /**
     * Solution class implementing the Swim in Rising Water algorithm
     * using Union-Find with path compression optimization.
     */
    static class Solution {
        // Parent array for Union-Find data structure
        private int[] parent;

        /**
         * Finds the minimum time to swim from top-left to bottom-right corner.
         * 
         * Algorithm:
         * 1. Initialize Union-Find structure for all grid cells
         * 2. Create mapping from elevation values to cell positions
         * 3. Process cells in ascending order of elevation (time)
         * 4. For each time t, connect all cells with elevation <= t
         * 5. Return time when start and end cells become connected
         * 
         * @param grid 2D integer array representing elevation map
         * @return minimum time needed to reach destination
         * 
         * Time Complexity: O(n² * α(n²)) where α is inverse Ackermann function
         * Space Complexity: O(n²) for Union-Find parent array and height mapping
         */
        public int swimInWater(int[][] grid) {
            int n = grid.length;
          
            // Initialize Union-Find parent array
            // Each cell initially points to itself as parent
            parent = new int[n * n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
          
            // Create a mapping from elevation value to its position in grid
            // heightToIndex[h] stores the flattened index of cell with height h
            int[] heightToIndex = new int[n * n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int height = grid[row][col];
                    int flattenedIndex = row * n + col;
                    heightToIndex[height] = flattenedIndex;
                }
            }
          
            // Direction vectors for exploring 4 adjacent cells (up, right, down, left)
            int[] directions = {-1, 0, 1, 0, -1};
          
            // Process cells in order of increasing elevation (time)
            for (int time = 0; time < n * n; time++) {
                // Get the position of cell with current elevation
                int currentIndex = heightToIndex[time];
                int currentRow = currentIndex / n;
                int currentCol = currentIndex % n;
              
                // Connect current cell with all adjacent cells that have been processed
                // (cells with elevation <= current time)
                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = currentRow + directions[dir];
                    int nextCol = currentCol + directions[dir + 1];
                  
                    // Check if adjacent cell is within bounds and already accessible
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n 
                        && grid[nextRow][nextCol] <= time) {
                        // Union the two cells in the disjoint set
                        int nextIndex = nextRow * n + nextCol;
                        union(find(nextIndex), find(currentIndex));
                    }
                }
                
                // Check if start (0,0) and end (n-1,n-1) are connected
                // This check should be outside the direction loop
                if (find(0) == find(n * n - 1)) {
                    return time;
                }
            }
          
            // This should never be reached given problem constraints
            return -1;
        }

        /**
         * Find operation with path compression optimization for Union-Find.
         * 
         * @param x the element to find root for
         * @return root of the set containing x
         */
        private int find(int x) {
            if (parent[x] != x) {
                // Path compression: make x point directly to root
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        /**
         * Union operation to merge two sets in Union-Find structure.
         * 
         * @param rootX root of first set
         * @param rootY root of second set
         */
        private void union(int rootX, int rootY) {
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    /**
     * Main method to demonstrate the solution with test cases.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Basic 2x2 grid
        int[][] grid1 = {
            {0, 2},
            {1, 3}
        };
        
        // Test case 2: More complex 3x3 grid
        int[][] grid2 = {
            {0, 1, 2, 3, 4},
            {24, 23, 22, 21, 5},
            {12, 13, 14, 15, 16},
            {11, 17, 18, 19, 20},
            {10, 9, 8, 7, 6}
        };
        
        System.out.println("=== Swim in Rising Water Solution ===");
        System.out.println("Test Case 1 - 2x2 Grid:");
        printGrid(grid1);
        System.out.println("Minimum time to reach destination: " + solution.swimInWater(grid1));
        
        System.out.println("\nTest Case 2 - 5x5 Grid:");
        printGrid(grid2);
        System.out.println("Minimum time to reach destination: " + solution.swimInWater(grid2));
    }
    
    /**
     * Helper method to print grid in a formatted way.
     * 
     * @param grid 2D array to print
     */
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}
