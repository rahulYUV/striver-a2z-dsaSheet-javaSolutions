import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class threeOct {
    public static void main(String[] args) {
        
    }
    class Solution {
        private static class Cell {
            int i;
            int j;
            int h;
            Cell(int i, int j, int h) {
                this.i = i;
                this.j = j;
                this.h = h;
            }
        }

        public int trapRainWater(int[][] heightMap) {
          final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
          final int m = heightMap.length;
          if (m == 0) return 0;
          final int n = heightMap[0].length;
          if (n == 0) return 0;
          int ans = 0;
          Queue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.h));
          boolean[][] seen = new boolean[m][n];
      
          for (int i = 0; i < m; ++i) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            seen[i][0] = true;
            seen[i][n - 1] = true;
          }
      
          for (int j = 1; j < n - 1; ++j) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            seen[0][j] = true;
            seen[m - 1][j] = true;
          }
      
          while (!minHeap.isEmpty()) {
            final int i = minHeap.peek().i;
            final int j = minHeap.peek().j;
            final int h = minHeap.poll().h;
            for (int[] dir : DIRS) {
              final int x = i + dir[0];
              final int y = j + dir[1];
              if (x < 0 || x == m || y < 0 || y == n)
                continue;
              if (seen[x][y])
                continue;
              if (heightMap[x][y] < h) {
                ans += h - heightMap[x][y];
                minHeap.offer(new Cell(x, y, h));
              } else {
                minHeap.offer(new Cell(x, y, heightMap[x][y]));
              }
              seen[x][y] = true;
            }
          }
      
          return ans;
        }
      }

}
