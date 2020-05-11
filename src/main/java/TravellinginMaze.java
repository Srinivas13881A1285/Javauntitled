import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Srinivas_Chintakindhi
 */

public class TravellinginMaze {
    static String mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols) {
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        Queue<Integer> dateQueue = new LinkedList<>();

        boolean[][] visited = new boolean[initThickness.length][initThickness[0].length];
        int sr = 0;
        int sc = 0;
        boolean reachEnd = false;

        visited[sr][sc] = true;
        rowQueue.add(sr);
        columnQueue.add(sc);
        dateQueue.add(0);

        while (!rowQueue.isEmpty()) {
            sr = rowQueue.poll();
            sc = columnQueue.poll();
            int day = dateQueue.poll();

            if (sr == initThickness.length - 1 && sc == initThickness.length - 1) {
                reachEnd = true;
                break;
            }

            explore_neighbours(initThickness, rate, threshold, sr, sc, visited, rowQueue, columnQueue, dateQueue,day+1);
        }
        if (reachEnd)
            return "YES";

        return "NO";
    }

    private static void explore_neighbours(int[][] m, long[][] rate, int threshold, int sr, int sc, boolean[][] visited,
                                          Queue<Integer> rowQueue, Queue<Integer> columnQueue, Queue<Integer> dayQueue,int day) {
        int[] dr = {0, 1};
        int[] dc = {1, 0};

        for (int i = 0; i < 2; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (r < 0 || c < 0)
                continue;
            if (r >= m.length || c >= m[0].length)
                continue;

//            if (visited[r][c] == true)
//                continue;

            int cost = (int) (day * rate[r][c] + m[r][c]);

            if (cost > threshold)
                continue;

            rowQueue.add(r);
            columnQueue.add(c);
            dayQueue.add(day);

//            visited[r][c] = true;
        }

    }


    public static void main(String[] args) {
        int[][] initThickness = {
                { 1,1,1},
                {1,1,1},
                {1,1,1}
        };

        long[][] rate = {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
        int threshold = 5;
        int rows = 3;
        int cols = 3;
        String s = mazeTraveller(threshold, initThickness, rate, rows, cols);
        System.out.println("s = " + s);
    }
}
