import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class SelfDrivingCar {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    int shortestTimeToDestination(int[][] map) {
        int m = map.length, n = map[0].length;
        int[][] dists = new int[m][n];
        for (int[] dist : dists) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        dists[0][0] = 0;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(t -> dists[t[0]][t[1]]));
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nextX = curr[0] + dir[0], nextY = curr[1] + dir[1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                    continue;
                int[] next = new int[] { nextX, nextY };
                int newDis = dists[curr[0]][curr[1]] + map[nextX][nextY];

                if (newDis < dists[nextX][nextY]) {
                    dists[nextX][nextY] = newDis;
                    q.offer(next);
                }
            }
        }
        System.out.println(dists[m - 1][n - 1]);
        return dists[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] map = new int[][] { { 0, 1, 1, 1 }, { 2, 3, 1, 4 }, { 2, 4, 3, 1 } };
        int[][] map2 = new int[][] { { 0, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        SelfDrivingCar selfDrivingCar = new SelfDrivingCar();
        selfDrivingCar.shortestTimeToDestination(map);
        // selfDrivingCar.test();
    }
}