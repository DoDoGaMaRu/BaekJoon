import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1051 {
    static char[][] employees;
    static boolean[] select;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");
        int height = Integer.parseInt(set[0]);
        int width = Integer.parseInt(set[1]);

        employees = new char[height][width];
        for (int i = 0; i < height; i++) {
            String str = br.readLine();
            for (int j = 0; j < width; j++) {
                employees[i][j] = str.charAt(j);
            }
        }

        int max = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char current = employees[i][j];
                int k = 0;
                while (true) {
                    k++;
                    try {
                        if (
                                employees[i][j] == employees[i+k][j+k]
                                        && employees[i][j] == employees[i][j+k]
                                        && employees[i][j] == employees[i+k][j]
                        ) {
                            int currentSize = (k+1) * (k+1);

                            if (max < currentSize) {
                                max = currentSize;
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException e) {
                        break;
                    }
                }
            }
        }

        System.out.println(max);
    }
}