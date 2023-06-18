import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1063 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");

        int[] king = new int[]{set[0].charAt(0) - 'A', set[0].charAt(1) - '1'};
        int[] dol = new int[]{set[1].charAt(0) - 'A', set[1].charAt(1) - '1'};
        int count = Integer.parseInt(set[2]);

        for (int i = 0; i < count; i++) {
            String opr = br.readLine();
            int[] move = new int[0];

            switch (opr) {
                case "R":
                    move = new int[]{1, 0};
                    break;
                case "L":
                    move = new int[]{-1, 0};
                    break;
                case "B":
                    move = new int[]{0, -1};
                    break;
                case "T":
                    move = new int[]{0, 1};
                    break;
                case "RT":
                    move = new int[]{1, 1};
                    break;
                case "LT":
                    move = new int[]{-1, 1};
                    break;
                case "RB":
                    move = new int[]{1, -1};
                    break;
                case "LB":
                    move = new int[]{-1, -1};
                    break;
            }

            if (king[0] + move[0] > -1 && king[0] + move[0] < 8 && king[1] + move[1] > -1 && king[1] + move[1] < 8) {
                if (king[0] + move[0] == dol[0] && king[1] + move[1] == dol[1]) {
                    if (dol[0] + move[0] > -1 && dol[0] + move[0] < 8 && dol[1] + move[1] > -1 && dol[1] + move[1] < 8) {
                        king[0] += move[0];
                        king[1] += move[1];

                        dol[0] += move[0];
                        dol[1] += move[1];
                    }
                }
                else {
                    king[0] += move[0];
                    king[1] += move[1];
                }
            }
        }
        System.out.print((char) (king[0] + 'A'));
        System.out.println(king[1] + 1);
        System.out.print((char) (dol[0] + 'A'));
        System.out.println(dol[1] + 1);
    }
}