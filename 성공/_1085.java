import java.util.Scanner;

public class _1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] target = {sc.nextInt(), sc.nextInt()};
        int[] sq = {sc.nextInt(), sc.nextInt()};

        System.out.print(min(target[0], target[1], sq[0] - target[0], sq[1] - target[1]));
    }

    public static int min(int... num) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }

        return min;
    }
}