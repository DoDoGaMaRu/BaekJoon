import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2460 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int max = 0;
        String[] set;
        for (int i = 0; i < 10; i++) {
            set = br.readLine().split(" ");

            count -= Integer.parseInt(set[0]);
            count += Integer.parseInt(set[1]);

            if (max < count) {
                max = count;
            }
        }

        System.out.println(max);
    }
}