import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14647 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] set = br.readLine().split(" ");
        int height = Integer.parseInt(set[0]);
        int width = Integer.parseInt(set[1]);

        String[][] strArr = new String[height][];
        for (int i = 0; i < height; i++) {
            strArr[i] = br.readLine().split(" ");
        }


        int sum = 0;
        int[][] arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int count = 0;
                for (int k = 0; k < strArr[i][j].length(); k++) if (strArr[i][j].charAt(k) == '9') count++;
                arr[i][j] = count;
                sum += count;
            }
        }


        int max = 0;

        for (int i = 0; i < height; i++) {
            int sumOfLine = 0;
            for (int j = 0; j < width; j++) {
                sumOfLine += arr[i][j];
            }

            if (max < sumOfLine) {
                max = sumOfLine;
            }
        }
        for (int i = 0; i < width; i++) {
            int sumOfLine = 0;
            for (int j = 0; j < height; j++) {
                sumOfLine += arr[j][i];
            }

            if (max < sumOfLine) {
                max = sumOfLine;
            }
        }

        System.out.println(sum - max);
    }
}