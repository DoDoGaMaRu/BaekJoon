import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1012 {
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int k = 0; k < count; k++) {
            String[] set = br.readLine().split(" ");
            int width = Integer.parseInt(set[0]);
            int height = Integer.parseInt(set[1]);
            int wormCount = Integer.parseInt(set[2]);

            makeMap(width, height, wormCount, br);

            int result = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int temp = dfs(i, j);

                    if (temp != 0) {
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int dfs(int x, int y) {
        try {
            if (!map[y][x]) {
                return 0;
            }
        }
        catch (Exception e) {
            return 0;
        }

        map[y][x] = false;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += dfs(x + dx[i], y + dy[i]);
        }

        return sum + 1;
    }

    public static void makeMap(int width, int height, int wormCount, BufferedReader br) throws Exception {
        map = new boolean[height][width];

        String[] set;
        int x, y;
        for (int i = 0; i < wormCount; i++) {
            set = br.readLine().split(" ");
            x = Integer.parseInt(set[0]);
            y = Integer.parseInt(set[1]);

            map[y][x] = true;
        }
    }
}