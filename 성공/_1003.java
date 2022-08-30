import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        int input;

        for (int i = 0; i < time; i++) {

            input = Integer.parseInt(br.readLine());
            System.out.printf("%d %d\n", fibonacci0(input), fibonacci1(input));
        }
    }

    public static int fibonacci0(int n) {
        int prev = 1;
        int cur = 0;
        int temp;

        if (n == 0) {
            return prev;
        }

        n--;
        for (int i = 0; i < n; i++) {
            temp = cur;
            cur = prev + cur;
            prev = temp;
        }

        return cur;
    }

    public static int fibonacci1(int n) {
        int prev = 0;
        int cur = 1;
        int temp;

        if (n == 0) {
            return prev;
        }

        n--;
        for (int i = 0; i < n; i++) {
            temp = cur;
            cur = prev + cur;
            prev = temp;
        }

        return cur;
    }
}
