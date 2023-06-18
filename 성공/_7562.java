import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7562 {
    static class Dot{
        int i, j, count;

        public Dot(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    static boolean[][] visit;
    static int endI, endJ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] set = br.readLine().split(" ");
            int startI = Integer.parseInt(set[0]);
            int startJ = Integer.parseInt(set[1]);

            set = br.readLine().split(" ");
            endI = Integer.parseInt(set[0]);
            endJ = Integer.parseInt(set[1]);

            visit = new boolean[size][size];

            System.out.println(bfs(new Dot(startI, startJ, 0)));
        }
    }

    static int[] di = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int bfs(Dot start) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(start);
        int ans = 0;

        while(!queue.isEmpty()) {
            Dot cur = queue.poll();

            if (cur.i == endI && cur.j == endJ) {
                ans = cur.count;
                break;
            }

            try {
                if (!visit[cur.i][cur.j]) {
                    visit[cur.i][cur.j] = true;
                    for (int i = 0; i < di.length; i++) {
                        queue.add(new Dot(cur.i + di[i], cur.j + dj[i], cur.count + 1));
                    }
                }
            }
            catch (Exception e) {
                continue;
            }
        }

        return ans;
    }
}