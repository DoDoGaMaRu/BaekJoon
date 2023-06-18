import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2638 {
    static class Set {
        int i;
        int j;

        public Set(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    static int[][] count;
    static boolean[][] cheese;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");
        int height = Integer.parseInt(set[0]);
        int width = Integer.parseInt(set[1]);

        cheese = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            set = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                if (set[j].charAt(0) == '1') {
                    cheese[i][j] = true;
                }
            }
        }

        int time = 0;
        while (true) {
            visited = new boolean[height][width];
            count = new int[height][width];
            bfs();
            if (deleteCheese()) {
                time++;
            }
            else {
                break;
            }
        }

        System.out.println(time);
    }

    static boolean deleteCheese() {
        boolean find = false;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[1].length; j++) {
                if (count[i][j] >= 2) {
                    find = true;
                    cheese[i][j] = false;
                }
            }
        }
        return find;
    }

    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1, 0, 0};

    static void bfs() {
        Queue<Set> queue = new LinkedList<>();
        queue.add(new Set(0, 0));

        while (!queue.isEmpty()) {
            Set cur = queue.poll();

            if (visited[cur.i][cur.j]) continue;

            visited[cur.i][cur.j] = true;
            for (int i = 0; i < di.length; i++) {
                try {
                    if (!visited[cur.i + di[i]][cur.j + dj[i]]) {
                        if (cheese[cur.i + di[i]][cur.j + dj[i]]) {
                            count[cur.i + di[i]][cur.j + dj[i]]++;
                        }
                        else {
                            queue.add(new Set(cur.i + di[i], cur.j + dj[i]));
                        }
                    }
                }
                catch (Exception e) {
                    continue;
                }
            }
        }
    }
}