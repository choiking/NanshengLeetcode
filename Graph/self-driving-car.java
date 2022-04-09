import java.util.PriorityQueue;

class SelfDrivingCar {
    int m, n;
    int[][] map;
    boolean[][] seen;
    int shortestTimeToDestination(int[][] input) {
        m = input.length;
        n = input[0].length;
        map = input;
        seen = new boolean[m][n];
        return dfs(0, 0);
    }

    // min value starting from (i, j) to destination
    int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || seen[i][j]) {
            return Integer.MAX_VALUE;
        }
        seen[i][j] = true;
        if (i == m - 1 && j == n - 1) {
            seen[i][j] = false;
            return map[i][j];
        }
        int l = dfs(i, j - 1);
        int r = dfs(i, j + 1);
        int u = dfs(i - 1, j);
        int d = dfs(i, j + 1);
        seen[i][j] = false;
        System.out.println(i + " " + j + " " + l + " " + r + " " + u + " " + d);
        return Math.max(map[i][j], Math.min(Math.min(l, r), Math.min(u, d)));
    }

    /* 
    0 1 1 
        1 
        3 1
    */


   int test() {
      int[] map = new int[5];
      map[0] = 1;
      map[1] = 2;
      PriorityQueue<Integer> pq = new PriorityQueue<> (26, (a,b) -> map[a] - map[b]);
      pq.offer(0);
      pq.offer(1);
      System.out.println(pq.poll());
      System.out.println(pq.poll());

      map[0] = 3;

      pq.offer(0);
      pq.offer(1);
      System.out.println(pq.poll());
      System.out.println(pq.poll());

      return 5;
   }

    public static void main(String[] args) {
        // int[][] map = new int[][] {{0,1,1,1},{2,3,1,4},{2,4,3,1}};
        SelfDrivingCar selfDrivingCar = new SelfDrivingCar();
        // selfDrivingCar.shortestTimeToDestination(map);
        selfDrivingCar.test();
    }
}